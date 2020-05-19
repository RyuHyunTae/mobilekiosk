package com.mo.biz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mo.biz.menu.menuService;
import com.mo.biz.menu.menuVO;
import com.mo.biz.shop.shopVO;
import com.mo.biz.user.userService;
import com.mo.biz.user.userVO;
import com.mo.biz.user.usershopVO;

@RestController
@RequestMapping(value="user")
public class userController {
	@Autowired
	userService userService;
	
	@Autowired
	menuService menuService;
	
	@PostMapping(value="login.do")
	userVO login(@RequestBody userVO vo) {
		System.out.println("로그인");
		return userService.login(vo); 
	}
	
	@PostMapping(value="shopInsert.do")
	int shopInsert(@RequestBody usershopVO vo) {
		System.out.println("매장등록");
		shopVO sVO = new shopVO();
		sVO.setQRcode(vo.getQRcode());
		sVO = userService.getBusinessNum(sVO);
		vo.setBusinessNum(sVO.getBusinessNum());
		return userService.usershopInsert(vo); 
	}
	
	@PostMapping(value="shopList.do")
	List<usershopVO> shopList(@RequestBody usershopVO vo) {
		System.out.println("매장리스트");
		return userService.shopList(vo); 
	}
	
	@PostMapping(value="menuList.do")
	List<menuVO> menuList(@RequestBody menuVO vo){
		System.out.println("메뉴정보");
		System.out.println(menuService.menuList(vo).toString());
		return menuService.menuList(vo);
	}
}
