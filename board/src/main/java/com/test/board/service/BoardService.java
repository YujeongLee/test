package com.test.board.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.test.board.util.PageNavigator;
import com.test.board.vo.BoardVO;
import com.test.board.vo.ReplyVO;

public interface BoardService {
	public ArrayList<BoardVO> getBoardList(Map<String, String> map, PageNavigator navi);
	public boolean write(BoardVO vo, MultipartFile uploadFile);
	public BoardVO read(int boardNum);
	public boolean delete(int boardNum);
	public boolean update(BoardVO vo, MultipartFile uploadFile);
	public PageNavigator getNavi(int currentPage, Map<String, String> map);
	public void download(BoardVO boardVO, HttpServletResponse response);
	ArrayList<ReplyVO> getReplyList(int boardNum);
	public void addReply(Map<String, String> map);
	public void deleteReply(ReplyVO vo);
}