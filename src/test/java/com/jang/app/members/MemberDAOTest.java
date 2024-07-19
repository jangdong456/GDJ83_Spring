package com.jang.app.members;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jang.app.DefaultTest;

//실행환경 설정 : SpringJUnit4ClassRunner.class
//@RunWith(SpringJUnit4ClassRunner.class)

//설정파일 위치 알려달라는 어노테이션
 // ** : 폴더가 있어도되고 없어도 되고
public class MemberDAOTest  extends DefaultTest {
	
	@Autowired
	private MemberDAO memberDAO;
	
//	@Test
	public void loginTest() throws Exception {
		MemberDTO memberdto = new MemberDTO();
		
		memberdto.setMember_id("66");
		
//		 List<Map<String, Object>> list = memberDAO.login(memberdto);
		MemberDTO list = memberDAO.login(memberdto);
		
		 
		assertEquals(2, memberdto.getDtos().size());
		assertNotNull(list);
	}
	
	@Test
	public void addFile() throws Exception {
		String name = "asd.jsp";
		
		MemberFileDTO file = new MemberFileDTO();
		file.setFilename(name);
		file.setFilenum(1L);
		file.setOriname(name);
		

		
		memberDAO.addFile(file);
		
	}

}
