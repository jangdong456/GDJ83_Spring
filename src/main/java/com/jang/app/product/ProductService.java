package com.jang.app.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jang.app.files.FileManager;
import com.jang.app.members.MemberDAO;
import com.jang.app.members.MemberDTO;
import com.jang.app.util.Pager;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private FileManager fileManager;
	
	public List<ProductDTO> wishList(MemberDTO memberDTO)throws Exception {
		return productDAO.wishList(memberDTO);
	}
	
	public int addWish(Integer product_id, Integer m_id) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product_id", product_id);
		map.put("m_id", m_id);

		int result = productDAO.addWish(map);
		return result;
	}
	
		
	public List<ProductDTO> getList(Pager pager) throws Exception {
		System.out.println("======= Service ========");

		pager.makerow();
		
		long totalCount = productDAO.getTotalCount(pager);
		
		pager.makeNum(totalCount);
		
		return productDAO.getList(pager);

	}
	
	public ProductDTO detail(ProductDTO productDTO) throws Exception {
		System.out.println("detail 서비스");
	  	return  productDAO.detail(productDTO);
	}
	
	public int add(ProductDTO productDTO, MultipartFile [] files, HttpSession session) throws Exception {
		
		Integer num = productDAO.getNum();
		
		productDTO.setProduct_id(num);
		
		int result = productDAO.add(productDTO);
		
		if(files == null) {
			return result; 
		}
		
		//1. 어디에 저장
		ServletContext ServletContext = session.getServletContext();
		String path = ServletContext.getRealPath("resources/upload/products/");
		System.out.println(path);
		
		
		//2. 저장할 파일명 만드는 방법
		for(MultipartFile f : files) {
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(path, f);
			

			//4.파일정보를 DB에 저장
			ProductFileDTO productFileDTO = new ProductFileDTO();
		
			productFileDTO.setFilename(fileName);
			productFileDTO.setOriname(f.getOriginalFilename());
			productFileDTO.setProduct_id(num);
			
			result = productDAO.addFile(productFileDTO);
		};
		
		return result;
	}
	
	public int delete(ProductDTO productDTO) throws Exception {
		return productDAO.delete(productDTO);
	}
	
	public int update(ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
	}

	
}
