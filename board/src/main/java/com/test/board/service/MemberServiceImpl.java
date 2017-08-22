package com.test.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.board.dao.MemberDAO;
import com.test.board.util.Mail;
import com.test.board.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Override
	public void join(MemberVO vo) {
		dao.join(vo);
	}
	
	@Override
	public boolean login(MemberVO vo, HttpSession session) {
		if(dao.login(vo) == null) return false;
		session.setAttribute("id", vo.getId());
		return true;
	}

	@Override
	public ArrayList<MemberVO> memberList() {
		return dao.memberList();
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	@Override
	public boolean accountReminder(String email) {
		MemberVO vo = dao.accountReminder(email);
		if(vo != null) {
			Mail.sendMail(vo);
			return true;
		}
		return false;
	}

	@Override
	public boolean checkId(MemberVO vo) {
		if (dao.login(vo) == null) return false;
		return true;	//이미 등록된 아이디
	}
}








