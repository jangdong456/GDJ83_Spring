package com.jang.app.members;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jang.app.accounts.AccountDAO;
import com.jang.app.files.FileManager;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private FileManager fileManager;
	
	private String name = "members";
	
	public int join(MemberDTO memberDTO, MultipartFile files, HttpSession session)throws Exception {
		ServletContext servletContext = session.getServletContext();
		//1. 어디에 저장 ? -> 운영체제가 알고있는 경로
		// HDD에 저장하기 때문에 운영체제가 관리하기에 운영체제 한테 어디에 저장할지 알려줘야한다. 
		String path = servletContext.getRealPath("resources/upload/members");
		System.out.println(path);
		
		int result = memberDAO.join(memberDTO); //성공
		

		MemberDTO test = memberDAO.find(memberDTO);
		
		String fileName = fileManager.fileSave(path, files);
		
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setM_id(test.getM_id());
		memberFileDTO.setFilename(fileName);
		memberFileDTO.setOriname(files.getOriginalFilename());
		
		
		result = memberDAO.addFile(memberFileDTO);
		
		return result;
	}
	
//	public MemberDTO login(MemberDTO memberDTO) throws Exception{
//		//map : key로 꺼내려고 | list는 인덱스 번호를 알아야하니 귀찮
////		Map<String, Object> map = new HashMap<String, Object>();
//		
//		// 반환값 MemberDTO 을 사용하려 하는데 변수명을 memberDTO 로 하면
//		// null값 올수 있으니 새로운 DTO를 담는  변수를 만들어야 비교가 가능하다
//		MemberDTO result = memberDAO.login(memberDTO);
//
//		if(result != null) {
//			if(result.getMember_pwd().equals(memberDTO.getMember_pwd())) {
////				List<AccountDTO> account = accountDAO.list(result);
////				map.put("member",result);
////				map.put("accounts", account);
//				return result;
//			} else {
//				
//			}
//		}
//		return null;
//	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		MemberDTO result = memberDAO.login(memberDTO);
		if (result != null && result.getMember_pwd().equals(memberDTO.getMember_pwd())) {
			return result;
		}
		return null;
	}
	
	public int update(MemberDTO memberDTO) throws Exception{
		return memberDAO.update(memberDTO);
	}
	
	public int delete(MemberDTO memberDTO)throws Exception {
		return memberDAO.delete(memberDTO);
	}
	
	public MemberDTO detail(MemberDTO memberDTO)throws Exception {
		return memberDAO.detail(memberDTO);
	}

}
