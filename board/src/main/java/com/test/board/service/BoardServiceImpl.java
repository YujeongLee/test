package com.test.board.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.test.board.dao.BoardDAO;
import com.test.board.util.FileService;
import com.test.board.util.PageNavigator;
import com.test.board.vo.BoardVO;
import com.test.board.vo.ReplyVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
	private final int countPerPage = 10;
	private final int pagePerGroup = 5;

	@Override
	public ArrayList<BoardVO> getBoardList(Map<String, String> map, PageNavigator navi) {
		return dao.getBoardList(map, navi.getStartRecord(), navi.getCountPerPage());
	}

	@Override
	public boolean write(BoardVO vo, MultipartFile uploadFile) {
		if(!uploadFile.isEmpty()) {
			String originalFileName = uploadFile.getOriginalFilename();
			String savedFileName = FileService.saveFile(uploadFile);
			
			vo.setOriginalFileName(originalFileName);
			vo.setSavedFileName(savedFileName);
		}
		if(dao.write(vo) == 1) return true;
		return false;
	}

	@Override
	public BoardVO read(int boardNum) {
		dao.addHit(boardNum);
		return dao.read(boardNum);
	}

	@Override
	public boolean delete(int boardNum) {
		String savedFileName = read(boardNum).getSavedFileName();
		
		if(dao.delete(boardNum) != 1) return false;
		FileService.deleteFile(savedFileName);
		return true;
	}

	@Override
	public boolean update(BoardVO vo, MultipartFile uploadFile) {
		String oldSavedFileName = read(vo.getBoardNum()).getSavedFileName();
		
		if(!uploadFile.isEmpty()) {
			String originalFileName = uploadFile.getOriginalFilename();
			String savedFileName = FileService.saveFile(uploadFile);
			
			vo.setSavedFileName(savedFileName);
			vo.setOriginalFileName(originalFileName);
		}
		
		if(dao.update(vo) != 1) {
			FileService.deleteFile(vo.getSavedFileName());
			return false;
		}
		
		if(!uploadFile.isEmpty()) FileService.deleteFile(oldSavedFileName);
		return true;
	}

	@Override
	public PageNavigator getNavi(int currentPage, Map<String, String> map) {
		int totalRecordsCount = dao.getTotal(map);
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, currentPage, totalRecordsCount);
		return navi;
	}

	@Override
	public void download(BoardVO boardVO, HttpServletResponse response) {
		File file = new File("C:/test/" + boardVO.getSavedFileName());
		String originalFileName = boardVO.getOriginalFileName();
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(originalFileName, "UTF-8"));
			response.setContentLength((int)file.length());
			FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<ReplyVO> getReplyList(int boardNum) {
		return dao.getReplyList(boardNum);
	}

	@Override
	public void addReply( Map<String, String> map) {
		dao.addReply(map);
	}

	@Override
	public void deleteReply(ReplyVO vo) {
		dao.deleteReply(vo);
	}
	
}








