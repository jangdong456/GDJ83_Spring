package com.jang.app.proudct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductDTO> getList() throws Exception {
		System.out.println("서비스");
		return productDAO.getList();

	}
	
	public ProductDTO detail(int product_id) throws Exception {
		System.out.println("detail 서비스");
	  	return  productDAO.detail(product_id);
	}
}
