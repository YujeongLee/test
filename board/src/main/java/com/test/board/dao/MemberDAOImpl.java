package com.test.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.board.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void join(MemberVO vo) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		mapper.join(vo);
	}
	
	@Override
	public MemberVO login(MemberVO vo) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.login(vo);
	}

	@Override
	public ArrayList<MemberVO> memberList() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.memberList();
	}

	@Override
	public MemberVO accountReminder(String email) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.accountReminder(email);
	}

	@Override
	public MemberVO checkId(MemberVO vo) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.checkId(vo);
	}
}








