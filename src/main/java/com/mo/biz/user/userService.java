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
	
	public int basketInsert(basketVO vo) {
		return userDAO.basketInsert(vo);
	}
	
	public int basketCountUp(basketVO vo) {
		return userDAO.basketCountUp(vo);
	}
	
	public int basketCountDown(basketVO vo) {
		return userDAO.basketCountDown(vo);
	}
	
	public int basketDelete(basketVO vo) {
		return userDAO.basketDelete(vo);
	}
	
	public basketVO basketCheck(basketVO vo) {
		return userDAO.basketCheck(vo);
	}
	
	public List<basketVO> basketList(basketVO vo) {
		return userDAO.basketList(vo);
	}
	
	public int basketAllDelete(String id) {
		return userDAO.basketAllDelete(id);
	}
	
	public int menuhitsInsert(menuhitsVO vo) {
		return userDAO.menuhitsInsert(vo);
	}
	
	public List<menuhitsVO> getMenuhits(String businessNum){
		return userDAO.getMenuhits(businessNum);
	}
}
