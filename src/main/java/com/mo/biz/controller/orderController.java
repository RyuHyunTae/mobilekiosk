package com.mo.biz.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mo.biz.order.orderListVO;
import com.mo.biz.order.orderService;
import com.mo.biz.order.orderVO;
import com.mo.biz.user.basketVO;
import com.mo.biz.user.userService;

@RestController
@RequestMapping(value="order")
public class orderController {

	@Autowired
	orderService orderService;
	
	@Autowired
	userService userService;
	
	@PostMapping(value="insert.do")
	public void orderInsert(@RequestBody orderVO vo) {
		System.out.println("주문등록");
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String time1 = format1.format(time);
		vo.setOrderTime(time1);
		
		orderService.orderInsert(vo);
		orderVO num = new orderVO();
		num=orderService.getOrderNum(vo);
		vo.setOrderNum(num.getOrderNum());
		
		basketVO id = new basketVO();
		id.setId(vo.getId());
		List<basketVO> list = new ArrayList();
		list=userService.basketList(id);
		
		for(basketVO one : list) {
			vo.setDetailCount(one.getBasketCount());
			vo.setMenuNum(one.getMenuNum());
			orderService.orderDetailInsert(vo);
		}
		userService.basketAllDelete(vo.getId());
		
	}
	
	@PostMapping(value="list.do")
	public List<orderVO> userOrderList(@RequestBody orderListVO vo) {
		System.out.println("유저메뉴리스트");
		System.out.println(orderService.userOrderList(vo).toString());
		return orderService.userOrderList(vo);
		
	}
	
}
