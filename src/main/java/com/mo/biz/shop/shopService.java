package com.mo.biz.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mo.biz.order.orderListVO;

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
	
	public List<calculateVO> todayCalculateList(calculateVO vo) {
		return shopDAO.todayCalculateList(vo);
	}
	
	public List<calculateVO> preCalculateList(calculateVO vo){
		return shopDAO.preCalculateList(vo);
	}
	
	public List<orderListVO> orderList(orderListVO vo){
		return shopDAO.orderList(vo);
	}
	
	public List<shopVO> approvalList(shopVO vo){
		return shopDAO.approvalList(vo);
	}
	
	public shopVO approvalDetail(shopVO vo) {
		return shopDAO.approvalDetail(vo);
	}
	
	public int qrcodeInsert(shopVO vo) {
		return shopDAO.qrcodeInsert(vo);
	}
	
	public shopVO getQRcode(String businessNum) {
		return shopDAO.getQRcode(businessNum);
	}
	
	public int shopOpen(String businessNum) {
		return shopDAO.shopOpen(businessNum);
	}
	
	public int shopClose(String businessNum) {
		return shopDAO.shopClose(businessNum);
	}
	
	public shopVO shopState(String businessNum) {
		return shopDAO.shopState(businessNum);
	}
	
	
}
