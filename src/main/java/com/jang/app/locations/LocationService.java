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
	
	
	public LocationDTO getDetail(int location_id) throws Exception {
		System.out.println("서비스");
		LocationDTO ar = locationDAO.getDetail(location_id);
		return ar;
	}
	
	public int add(LocationDTO locationDTO) throws Exception {
		return locationDAO.add(locationDTO);
	}  
}
