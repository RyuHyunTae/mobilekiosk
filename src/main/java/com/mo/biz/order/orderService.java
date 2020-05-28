package com.mo.biz.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderService {

	@Autowired
	orderDAO orderDAO;
	
	public int orderInsert(orderVO vo) {
		return orderDAO.orderInsert(vo);
	}
	
	public int orderDetailInsert(orderVO vo) {
		return orderDAO.orderDetailInsert(vo);
	}
	
	public orderVO getOrderNum (orderVO vo) {
		return orderDAO.getOrderNum(vo);
	}
	
	public List<orderVO> userOrderList(orderListVO vo){
		return orderDAO.userOrderList(vo);
	}
}
