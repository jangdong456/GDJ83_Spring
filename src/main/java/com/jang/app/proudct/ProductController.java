package com.jang.app.proudct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("list")
	public void getList(Model model)throws Exception {
		
		List<ProductDTO> ar =  productService.getList();

		model.addAttribute("list", ar);
	}
	
	@RequestMapping(value = "detail", method= RequestMethod.GET)
	public String detail(Model model, int product_id) throws Exception {
		System.out.println("TEST");
		System.out.println(product_id);
		
		ProductDTO dto = productService.detail(product_id);

		model.addAttribute("detail",dto);
		String path = "product/detail";

		return path;
	}	
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {
		
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add2(Model model, ProductDTO productDTO) throws Exception {
		
		int result = productService.add(productDTO);
		
		String url = "";
		
		if (result > 0) {
			url = "redirect:./list";
		} else {
			model.addAttribute("url", "./list");
		}
		return url;
	}
	
	@RequestMapping("delete")
	public String delete(ProductDTO productDTO, Model model) throws Exception {
		
		int result = productService .delete(productDTO);
		
		String url = "commons/message";
		if (result > 0 ) {
			url = "redirect:./list";
		} else {
			model.addAttribute("resutl", "삭제 실패");
			model.addAttribute("url", "list");
		}
		return url;
	}
	
	
	
	
}

