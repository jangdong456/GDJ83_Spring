package com.jang.app.proudct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("list")
	public void getList(Model model)throws Exception {
		System.out.println("123");
		
		List<ProductDTO> ar =  productService.getList();
		
		model.addAttribute("list", ar);
	}
	
	@RequestMapping("detail")
	public String detail(Model model, int product_id) throws Exception {
		System.out.println("detail");
		
		ProductDTO dto = productService.detail(product_id);
		
		model.addAttribute("detail", dto);
		
		String path = "department/detail";
		
		return path;
	}	
}
