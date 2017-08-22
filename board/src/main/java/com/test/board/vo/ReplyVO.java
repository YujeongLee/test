package com.test.board.vo;

public class ReplyVO {
	private int replyNum;
	private int boardNum;
	private String id;
	private String replyText;
	private String inputdate;
	
	public ReplyVO() {
	}
	
	public ReplyVO(int replyNum, int boardNum, String id, String replyText, String inputdate) {
		super();
		this.replyNum = replyNum;
		this.boardNum = boardNum;
		this.id = id;
		this.replyText = replyText;
		this.inputdate = inputdate;
	}

	public int getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReplyText() {
		return replyText;
	}

	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	@Override
	public String toString() {
		return "ReplyVO [replyNum=" + replyNum + ", boardNum=" + boardNum + ", id=" + id + ", replyText=" + replyText
				+ ", inputdate=" + inputdate + "]";
	}
	
}
