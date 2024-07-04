package com.jang.app.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int join(MemberDTO memberDTO)throws Exception {
		
		return memberDAO.join(memberDTO);
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		// 반환값 MemberDTO 을 사용하려 하는데 변수명을 memberDTO 로 하면
		// null값 올수 있으니 새로운 DTO를 담는  변수를 만들어야 비교가 가능하다
		MemberDTO result = memberDAO.login(memberDTO);
		
		if(result != null) {
			if(result.getMember_pwd().equals(memberDTO.getMember_pwd())) {
				return result;
			} else {
				return null;
			}
		}
		return result;
	}
}
