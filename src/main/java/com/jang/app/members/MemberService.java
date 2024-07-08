package com.jang.app.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.app.accounts.AccountDAO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	public int join(MemberDTO memberDTO)throws Exception {
		
		return memberDAO.join(memberDTO);
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		//map : key로 꺼내려고 | list는 인덱스 번호를 알아야하니 귀찮
//		Map<String, Object> map = new HashMap<String, Object>();
		
		// 반환값 MemberDTO 을 사용하려 하는데 변수명을 memberDTO 로 하면
		// null값 올수 있으니 새로운 DTO를 담는  변수를 만들어야 비교가 가능하다
		MemberDTO result = memberDAO.login(memberDTO);


		
		if(result != null) {
			if(result.getMember_pwd().equals(memberDTO.getMember_pwd())) {
//				List<AccountDTO> account = accountDAO.list(memberDTO);
//				map.put("member",result);
//				map.put("accounts", account);
				return result;
			} else {
				return null;
			}
		}
		return null;
	}
	
	public int update(MemberDTO memberDTO) throws Exception{
		return memberDAO.update(memberDTO);
	}
	
	public int delete(MemberDTO memberDTO)throws Exception {
		return memberDAO.delete(memberDTO);
	}

}
