package com.jang.app.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductDTO> getList(Long page) throws Exception {
		System.out.println("======= Service ========");
		
		if(page == null) {
			page = 1L;
		}
		
		// page가   1이면  2     3
		// 첫번째 숫자 1    6     11
		// 두번째 숫자 5    10     15
		
		//한페이지에 5개씩 할때
//		long perPage =5L;
//		long startRow = (page-1) * perPage+1;
//		long lastRow = page * perPage;
		
		// page가   1이면  2     3
		// 첫번째 숫자 1    11    21
		// 두번째 숫자 10   20    30
		
		//한페이지에 10개씩 할때
		long perPage = 10L;
		long startRow = page * 10-9;
		long lastRow = page * 10;
		
		List<Long> ar = new ArrayList<Long>();
		ar.add(startRow);
		ar.add(lastRow);

		long totalCount = productDAO.getTotalCount();
		long totalPage = totalCount/perPage;
		
		if(totalCount % perPage != 0) {
			totalPage++;
		}
		System.out.println(totalCount);
		return productDAO.getList(ar);

	}
	
	public ProductDTO detail(ProductDTO product_id) throws Exception {
		System.out.println("detail 서비스");
	  	return  productDAO.detail(product_id);
	}
	
	public int add(ProductDTO productDTO) throws Exception {
		return productDAO.add(productDTO);
	}
	
	public int delete(ProductDTO productDTO) throws Exception {
		return productDAO.delete(productDTO);
	}
	
	public int update(ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
	}

	
}
