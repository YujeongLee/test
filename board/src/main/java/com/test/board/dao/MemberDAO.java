package com.test.board.dao;

import java.util.ArrayList;

import com.test.board.vo.MemberVO;

public interface MemberDAO {
	public void join(MemberVO vo);
	public MemberVO login(MemberVO vo);
	public ArrayList<MemberVO> memberList();
	public MemberVO accountReminder(String email);
	public MemberVO checkId(MemberVO vo);
}