package com.jang.app.boards.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jang.app.boards.BoardDAO;
import com.jang.app.boards.BoardDTO;
import com.jang.app.boards.BoardFileDTO;
import com.jang.app.boards.BoardService;
import com.jang.app.files.FileManager;
import com.jang.app.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	@Qualifier("noticeDAO")
	private BoardDAO boardDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		System.out.println("=====List Service ====");
		
		pager.makerow();
		
		long totalCount = boardDAO.getTotalCount(pager);
		
		pager.makeNum(totalCount);
		
		return boardDAO.list(pager);
		
	}

	@Override
	public int add(BoardDTO boardDTO, MultipartFile [] files, HttpSession session) throws Exception {
	
		int result = boardDAO.add(boardDTO); 
		
		if(files == null) {
			return result;
		}
		
		String path = session.getServletContext().getRealPath("resources/upload/Notice");
		
		for(MultipartFile f : files) {
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(path, f);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFilename(fileName);
			boardFileDTO.setOriname(f.getOriginalFilename());
			
			result = boardDAO.addFile(boardFileDTO);
		}
		
		return result; 
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.update(boardDTO); 
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.delete(boardDTO);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.detail(boardDTO);
	}
}
