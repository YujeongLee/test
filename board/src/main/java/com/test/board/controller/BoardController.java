package com.test.board.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.board.service.BoardService;
import com.test.board.util.PageNavigator;
import com.test.board.vo.BoardVO;
import com.test.board.vo.ReplyVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value = "getBoardList", method = RequestMethod.GET)
	public String getBoardList(
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value = "searchKeyword", defaultValue = "") String searchKeyword,
			String searchCondition,
			Map<String, String> map,
			Model model) {
		map.put("searchKeyword", searchKeyword);
		map.put("searchCondition", searchCondition);
		
		PageNavigator navi = service.getNavi(currentPage, map);
		model.addAttribute("boardList", service.getBoardList(map, navi));
		model.addAttribute("navi", navi);
		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("searchCondition", searchCondition);
		return "/board/getBoardList";
	}
	
	@RequestMapping(value = "writeForm", method = RequestMethod.GET)
	public String writeForm() {
		return "/board/boardWriteForm";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(BoardVO vo, MultipartFile uploadFile,RedirectAttributes rttr) {
		rttr.addFlashAttribute("result", service.write(vo, uploadFile));
		return "redirect:/board/getBoardList";
	}
	
	@RequestMapping(value = "read")
	public String read(int boardNum, Model model) {
		model.addAttribute("vo", service.read(boardNum));
		return "/board/boardRead";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int boardNum, RedirectAttributes rttr) {
		rttr.addFlashAttribute("result", service.delete(boardNum));
		return "redirect:/board/getBoardList";
	}
	
	@RequestMapping(value = "updateForm", method = RequestMethod.GET)
	public String updateForm(int boardNum, Model model) {
		model.addAttribute("vo", service.read(boardNum));
		return "/board/boardUpdateForm";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(BoardVO vo, MultipartFile uploadFile, Model model) {
		model.addAttribute("result", service.update(vo, uploadFile));
		model.addAttribute("boardNum", vo.getBoardNum());
		return "forward:/board/read";
	}
	
	@RequestMapping(value = "download", method = RequestMethod.GET)
	public void download(int boardNum, HttpServletResponse response) {
		BoardVO boardVO = service.read(boardNum);
		service.download(boardVO, response);
	}
	
	@RequestMapping(value = "getReplyList", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<ReplyVO> getReplyList(int boardNum) {
		return service.getReplyList(boardNum);
	}
	
	@RequestMapping(value = "writeReply", method = RequestMethod.POST)
	@ResponseBody
	public void writeReply(int boardNum, String id, String replyText, Map<String, String> map) {
			map.put("boardNum", Integer.toString(boardNum));
			map.put("id",id);
			map.put("replyText",replyText);
			service.addReply(map);
	}
	
	@RequestMapping(value = "deleteReply", method = RequestMethod.POST)
	@ResponseBody
	public void deleteReply(ReplyVO vo) {
			service.deleteReply(vo);
	}
}