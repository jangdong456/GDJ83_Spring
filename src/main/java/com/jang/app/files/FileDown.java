package com.jang.app.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class FileDown extends AbstractView{
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
//		Iterator<String> keys = model.keySet().iterator();
//		
//		while(keys.hasNext()) {
//			String k = keys.next();
//			System.out.println(k);
//		}
		
		 FileDTO fileDTO = (FileDTO)model.get("file");
		 String directory = (String)model.get("board");
		 
		 //1. 폴더 경로 준비
		 String path = request.getSession().getServletContext().getRealPath("/resources/upload/"+directory);
		 
		 //2. 파일 준비
		 File file = new File(path, fileDTO.getFilename());
		 
		 //3. 응답시 인코딩처리(파일명이 한글일 수도 있어서) --> 해도되고 안해도됨 왜? -> filter에서 인코딩 utf-8 이미 해놔서
		 response.setCharacterEncoding("UTF-8");
		 
		 //4. 파일의 크기 지정 -> 파일 크기 알려주기
		 response.setContentLength((int)file.length());
		 
		 //5. 다운로드시 파일이름을 지정, 인코딩 작업 셋팅 / 파일명이 한글일 수도 있어서
		 String name = fileDTO.getOriname();
		 name = URLEncoder.encode(name, "UTF-8");
		 
		 //6. Header 정보 설정 
		 response.setHeader("Content-Disposition", "attachment;fileName=\""+name+"\"");
		 response.setHeader("Content-Transfer-Encoding", "binary");
		 
		 //7-1 Cliendt 전송
		 // HDD 에서 파일을 읽어와서 Client로 output -> 내보내야 해서
		 // fi 를 읽어와서 os로 내보낸다
		 FileInputStream fi = new FileInputStream(file);
		 OutputStream os = response.getOutputStream();		 
		 
		 //7-2 파일을 HDD에 저장 
		 FileCopyUtils.copy(fi, os);
		 
		 //8. 해제
		 os.close();
		 fi.close();
		 
		 
		System.out.println("===== File Down View ===== ");
	}
	
}
