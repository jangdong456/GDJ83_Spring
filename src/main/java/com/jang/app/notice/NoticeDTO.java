package com.jang.app.notice;

import java.util.List;

import com.jang.app.members.MemberDTO;
import com.jang.app.notice.boards.BoardDTO;

public class NoticeDTO extends BoardDTO {
	

	//	private Integer m_id;

	private List<MemberDTO> dtos;


	public List<MemberDTO> getDtos() {
		return dtos;
	}
	public void setDtos(List<MemberDTO> dtos) {
		this.dtos = dtos;
	}

//	public Integer getM_id() {
//		return m_id;
//	}
//	public void setM_id(Integer m_id) {
//		this.m_id = m_id;
//	}

	
}
