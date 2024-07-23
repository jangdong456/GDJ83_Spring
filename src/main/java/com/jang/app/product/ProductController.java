package com.jang.app.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.jang.app.members.MemberDTO;
import com.jang.app.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("wishList")
	public void wishList(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		List<ProductDTO> ar = productService.wishList(memberDTO);
		
		model.addAttribute("list", ar);
	}
	
	@GetMapping("addWish")
	public String addWish(ProductDTO productDTO ,Integer product_id,HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");

		int result = productService.addWish(product_id, memberDTO.getM_id());

		model.addAttribute("msg",result);
		
		return "commons/result";
	}
	
	@RequestMapping("list")
	public void getList(Pager pager, Model model) throws Exception {
		System.out.println("====== Controller =======");
		
		List<ProductDTO> list = productService.getList(pager);
		
		
		model.addAttribute("pager", pager);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "detail", method= RequestMethod.GET)
	public String detail(Model model, ProductDTO productDTO) throws Exception {

		ProductDTO dto = productService.detail(productDTO);

		model.addAttribute("detail",dto);
		String path = "product/detail";

		return path;
	}	
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {
		
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add2(Model model,ProductDTO productDTO, MultipartFile [] files, HttpSession session) throws Exception {
		
		int result = productService.add(productDTO, files, session);
		
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
		
		int result = productService.delete(productDTO);
		
		String url = "commons/message";
		if (result > 0 ) {
			url = "redirect:./list";
		} else {
			model.addAttribute("resutl", "삭제 실패");
			model.addAttribute("url", "list");
		}
		return url;
	}
	
	@RequestMapping("update")
	public String update(ProductDTO productDTO, Model model) throws Exception {

		ProductDTO dto = productService.detail(productDTO);
			
		String url = "commons/message";
		
		if(dto != null) {
			model.addAttribute("dto", dto);
			url = "product/update";
		} else {
			model.addAttribute("result", "없는 부서");
			model.addAttribute("url", "list");
		}
		return url;
	}
	
	@RequestMapping(value = "update", method= RequestMethod.POST)
	public String update2(ProductDTO productDTO) throws Exception {
		int result = productService.update(productDTO);
		
		String url = "redirect:./list";

		return url;
	}
}

