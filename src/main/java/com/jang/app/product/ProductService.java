package com.jang.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductDTO> getList() throws Exception {
		return productDAO.getList();

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
