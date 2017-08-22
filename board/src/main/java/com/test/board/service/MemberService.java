package com.test.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.test.board.vo.MemberVO;

public interface MemberService {
	public void join(MemberVO vo);
	public boolean login(MemberVO vo, HttpSession session);
	public ArrayList<MemberVO> memberList();
	public void logout(HttpSession session);
	public boolean accountReminder(String email);
	public boolean checkId(MemberVO vo);
}