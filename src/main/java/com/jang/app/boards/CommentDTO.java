package com.jang.app.boards;

import java.sql.Date;

public class CommentDTO {
	private Long board_num;
	private Integer board_writer;
	private String board_contents;
	private Date create_date;
	
	public Long getBoard_num() {
		return board_num;
	}
	public void setBoard_num(Long board_num) {
		this.board_num = board_num;
	}
	public Integer getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(Integer board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_contents() {
		return board_contents;
	}
	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
}
