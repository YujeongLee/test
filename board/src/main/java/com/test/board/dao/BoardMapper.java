package com.test.board.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.test.board.vo.BoardVO;
import com.test.board.vo.ReplyVO;

public interface BoardMapper {

	public ArrayList<BoardVO> getBoardList(Map<String, String> map, RowBounds rb);
	public int write(BoardVO vo);
	public BoardVO read(int boardNum);
	public void addHit(int boardNum);
	public int delete(int boardNum);
	public int update(BoardVO vo);
	public int getTotal(Map<String, String> map);
	public ArrayList<ReplyVO> getReplyList(int boardNum);
	public void addReply(Map<String, String> map);
	public void deleteReply(ReplyVO vo);
}
