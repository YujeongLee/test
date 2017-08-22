package com.test.board.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.board.service.MemberService;
import com.test.board.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	// ID / PWD ���� ���� ��硫�
	@RequestMapping(value = "accountReminderForm", method = RequestMethod.GET)
	public String accountReminderForm() {
		return "/member/accountReminderForm";
	}
	
	// ID / PWD ����
	@RequestMapping(value = "accountReminder", method = RequestMethod.POST)
	public String accountReminder(String email, RedirectAttributes rttr) {
		rttr.addFlashAttribute("result", service.accountReminder(email));
		return "redirect:/member/accountReminderForm";
	}
	
	// ����媛��� ���� ��硫� �대��
	@RequestMapping(value = "joinForm", method = RequestMethod.GET)
	public String joinForm() {
		return "/member/joinForm";
	}
	
	// ����媛���
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberVO vo) {
		service.join(vo);
		return "redirect:/";
	}
	
	// 濡�洹몄�� ���� ��硫� �대��
	@RequestMapping(value = "loginForm")
	public String loginForm() {
		return "/member/loginForm";
	}
	
	// 濡�洹몄��
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpSession session, Model model) {
		boolean result = service.login(vo, session);
		if(result) return "redirect:/";
		model.addAttribute("result", result);
		return "forward:/member/loginForm";
	}
	
	// ���� 紐⑸�
	@RequestMapping(value = "memberList", method = RequestMethod.GET)
	public String memberList(Model model) {
		model.addAttribute("memberList", service.memberList());
		return "/member/memberList";
	}
	
	// 濡�洹� ����
		
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		service.logout(session);
		return "redirect:/";
	}
	
	//중복체크
	@RequestMapping(value = "checkId", method = RequestMethod.POST)
	@ResponseBody
	public boolean checkId(MemberVO vo) {
		return service.checkId(vo);
	}
	
}