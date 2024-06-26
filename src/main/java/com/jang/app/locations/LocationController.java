package com.jang.app.locations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/location/*")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		System.out.println("location list");
		 List<LocationDTO> ar = locationService.getList();
		 
		 model.addAttribute("list", ar);
	}
	
	@RequestMapping("detail")
	public String getDetail(Model model, int location_id)throws Exception {
		System.out.println("디테일");
		LocationDTO dto = locationService.getDetail(location_id);
		
		String path = "commons/message";
		
		if(dto != null) {
			model.addAttribute("detail", dto);
			path = "location/detail";
		} else {
			model.addAttribute("result", "지역을 찾을 수 없다");
			model.addAttribute("url", "./list");
		} return path;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {
		System.out.println("getgegget");
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add2(LocationDTO locationDTO, Model model) throws Exception {
		System.out.println("from post add");
		int result = locationService.add(locationDTO);
		
		String path = "";
		
		if(result > 0) {
			path = "redirect:./list";
		} else {
			model.addAttribute("result", "지역정보 입력 실패");
			model.addAttribute("url", "./list");
		}
		return path;
	}
} 
