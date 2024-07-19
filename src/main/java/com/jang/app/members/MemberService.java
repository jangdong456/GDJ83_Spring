package com.jang.app.members;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.jang.app.accounts.AccountDAO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	private String name = "members";
	
	public int join(MemberDTO memberDTO, MultipartFile files, HttpSession session)throws Exception {
		ServletContext servletContext = session.getServletContext();
		//1. 어디에 저장 ? -> 운영체제가 알고있는 경로
		// HDD에 저장하기 때문에 운영체제가 관리하기에 운영체제 한테 어디에 저장할지 알려줘야한다. 
		String path = servletContext.getRealPath("resources/upload/members");
		System.out.println(path);
		
		File file = new File(path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//2-1. 방식1 파일명 ?? -> 중복되지 않기위해서 시간으로 파일명 설정 
		Calendar calendar = Calendar.getInstance();
		long n = calendar.getTimeInMillis();
		
		//subString
		String fileName = files.getOriginalFilename();
		fileName = fileName.substring(fileName.lastIndexOf("."));
		
		//splitm StringTokenizer
//		String[] fileName = name.split("\\.");
//		name = fileName[fileName.length-1];
		
//		System.out.println(name);
//		name = n+"."+name;
		
		fileName = n+"_"+ files.getOriginalFilename();
		
		// 2-2.방식2 UUID 라이브러리 사용 
		fileName = UUID.randomUUID().toString()+"_"+ files.getOriginalFilename();	
		
		System.out.println(fileName);
		
		
		//3. HDD에 파일저장
		file = new File(file, fileName);
		
		//1)MultipartFile의 메서드 활용 
		// files.transferTo(file);
		
		// ============================================
		// 2)FileCopyUtils의 copy([in],[out])활용
		FileCopyUtils.copy(files.getBytes(), file);
		
		int result = memberDAO.join(memberDTO); //성공
		
		System.out.println("=========== 진 입 ================");
		MemberDTO test = memberDAO.find(memberDTO);
		System.out.println(test.getM_id());
		System.out.println("=========== 끝 ================");
		
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
