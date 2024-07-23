package com.jang.app.boards;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.jang.app.files.FileDTO;
import com.jang.app.util.Pager;

public interface BoardService {

	//list
	public List<BoardDTO> list(Pager page) throws Exception;
	
	//add 
	int add(BoardDTO boardDTO, MultipartFile [] multipartFiles, HttpSession session) throws Exception;
	
	//update
	int update(BoardDTO boardDTO) throws Exception;
	
	//delete
	int delete(BoardDTO boardDTO) throws Exception;
	
	//detail
	BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	//filedetail
	FileDTO fileDetail(FileDTO fileDTO) throws Exception;

}
