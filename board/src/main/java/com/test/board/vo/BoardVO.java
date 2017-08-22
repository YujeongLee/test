package com.test.board.vo;

public class BoardVO {
	private int boardNum;
	private String id;
	private String title;
	private String content;
	private String inputdate;
	private int hit;
	private String originalFileName;
	private String savedFileName;
	
	public BoardVO() {}

	public BoardVO(int boardNum, String id, String title, String content, String inputdate, int hit,
			String originalFileName, String savedFileName) {
		super();
		this.boardNum = boardNum;
		this.id = id;
		this.title = title;
		this.content = content;
		this.inputdate = inputdate;
		this.hit = hit;
		this.originalFileName = originalFileName;
		this.savedFileName = savedFileName;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getSavedFileName() {
		return savedFileName;
	}

	public void setSavedFileName(String savedFileName) {
		this.savedFileName = savedFileName;
	}

	@Override
	public String toString() {
		return "BoardVO [boardNum=" + boardNum + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", inputdate=" + inputdate + ", hit=" + hit + ", originalFileName=" + originalFileName
				+ ", savedFileName=" + savedFileName + "]";
	}
	
	
}
