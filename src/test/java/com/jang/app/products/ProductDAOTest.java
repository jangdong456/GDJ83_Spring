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
	public void pageTest() {
		
		// 소수점이 나오면 -> +1 시켜준다
		// totalPage =(15.6/10)+1 = 16
		
		
		
		long perPage = 10L;
		long totalCount = 154;
		long totalPage = totalCount/perPage;
		
		

		if(totalCount % perPage != 0) {
			totalPage++;
		}
	
		System.out.println(totalPage);
	}
	
	
//	@Test
	public void addTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		for(int i=0; i<100; i++) {
			productDTO.setProduct_type("주택" + i);
			double r = ((int)(Math.random()*1000))/100.0;
			productDTO.setProduct_rate(r);
			productDTO.setProduct_detail("상세설명" + i);
			productDAO.add(productDTO);
			Thread.sleep(500);
		}
		System.out.println("Fisnish");
	}
	
//	@Test
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
