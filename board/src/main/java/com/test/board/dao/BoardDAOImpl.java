package com.test.board.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.board.vo.BoardVO;
import com.test.board.vo.ReplyVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<BoardVO> getBoardList(Map<String, String> map, int startRecord, int countPerPage) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		RowBounds rb = new RowBounds(startRecord, countPerPage);
		return mapper.getBoardList(map, rb);
	}

	@Override
	public int write(BoardVO vo) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.write(vo);
	}

	@Override
	public BoardVO read(int boardNum) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.read(boardNum);
	}

	@Override
	public void addHit(int boardNum) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.addHit(boardNum);
	}

	@Override
	public int delete(int boardNum) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.delete(boardNum);
	}

	@Override
	public int update(BoardVO vo) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.update(vo);
	}

	@Override
	public int getTotal(Map<String, String> map) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.getTotal(map);
	}
	
	@Override
	public ArrayList<ReplyVO> getReplyList(int boardNum) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.getReplyList(boardNum);
	}

	@Override
	public void addReply(Map<String, String> map) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.addReply(map);
	}

	@Override
	public void deleteReply(ReplyVO vo) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.deleteReply(vo);
	}
}








