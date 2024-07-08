package com.jang.app.products;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jang.app.DefaultTest;
import com.jang.app.product.ProductDAO;
import com.jang.app.product.ProductDTO;

public class ProductDAOTest extends DefaultTest {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void getDetailTest() throws Exception{
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setProduct_id(1);
		productDTO.setProduct_rate(3.2);
		productDTO.setProduct_type("주택");
		productDTO.setProduct_detail(null);
		
		productDTO = productDAO.detail(productDTO);
		
		
		
		//단정문
//		assertNotNull(productDTO);
		
		//희망하는값 , 실제값
//		assertEquals(4, 3);
		assertNotNull(productDTO);
	}

}
