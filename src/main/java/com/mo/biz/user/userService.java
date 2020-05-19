package com.mo.biz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mo.biz.shop.shopVO;


@Service
public class userService {

	@Autowired
	userDAO userDAO;
	
	public int join(userVO vo) {
		return userDAO.join(vo);
	}
	
	public userVO login(userVO vo) {
		return userDAO.login(vo);
	}
	
	public int usershopInsert(usershopVO vo) {
		return userDAO.usershopInsert(vo);
	}
	
	public shopVO getBusinessNum(shopVO vo) {
		return userDAO.getBusinessNum(vo);
	}
	
	public List<usershopVO> shopList(usershopVO vo){
		return userDAO.shopList(vo);
	}
}
