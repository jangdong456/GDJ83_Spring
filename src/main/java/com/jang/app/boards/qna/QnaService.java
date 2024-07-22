package com.jang.app.boards.qna;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jang.app.boards.BoardDTO;
import com.jang.app.boards.BoardFileDTO;
import com.jang.app.boards.BoardService;
import com.jang.app.files.FileManager;
import com.jang.app.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		// 1. rownum 계산
		pager.makerow();
		
		// 2. pageing 계산
		pager.makeNum(qnaDAO.getTotalCount(pager));
		return qnaDAO.list(pager);
	}

	@Override
	public int add(BoardDTO boardDTO ,MultipartFile [] files, HttpSession session) throws Exception {

		int result = qnaDAO.add(boardDTO);
		
		if(files == null) {
			return result;
		}
		
		ServletContext servletContext = session.getServletContext();
		String path = servletContext.getRealPath("resources/upload/Qna");
		System.out.println(path);
		
		for(MultipartFile f : files) {
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(path, f);
			
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setBoard_num(boardDTO.getBoard_num());
			boardFileDTO.setFilename(fileName);
			boardFileDTO.setOriname(f.getOriginalFilename());
			result = qnaDAO.addFile(boardFileDTO);
		}

		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.delete(boardDTO);
		
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.detail(boardDTO);
	}
	
	public int reply(QnaDTO qnaDTO) throws Exception {
		// 옮기는것은 BoardDTO 지만 QnaDTO에 ref, sep ,deft 정보가 있기에 QnaDTO 으로 형변환시켜준다,
		// parent = 부모의 값
		// board_num을 알기위해서 qnaDAO.detail메서드를 사용해 값을 받아온다.
		QnaDTO parent = (QnaDTO)qnaDAO.detail(qnaDTO);
		// 1. step을 +1씩 업데이트 하는 코드
		int result = qnaDAO.replyUpdate(parent);
		
		// 2. 답글의 REF, STEP, DEPTH를 세팅
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		result = qnaDAO.reply(qnaDTO);
		
		//파일저장
		
		return result;
	}

}
