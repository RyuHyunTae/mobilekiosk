package com.mo.biz.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class shopService {

	@Autowired
	shopDAO shopDAO;
	
	public int join(shopVO vo) {
		return shopDAO.join(vo);
	}
	
	public shopVO Login(shopVO vo) {
		return shopDAO.login(vo);
	}
	
	
	
}
