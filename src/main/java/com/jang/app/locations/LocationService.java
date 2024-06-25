package com.jang.app.locations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
	
	@Autowired
	private LocationDAO locationDAO;
	
	public List<LocationDTO> getList() throws Exception {
		System.out.println("서비스");
		List<LocationDTO> ar = locationDAO.getList();
		
		return ar;
	}
}
