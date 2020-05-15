package com.mo.biz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mo.biz.shop.shopService;
import com.mo.biz.shop.shopVO;

@Controller
@RequestMapping(value = "shop")
public class shopController {

	@Autowired
	shopService shopService;

	@PostMapping(value = "login.do")
	public String login(shopVO vo, HttpSession session) {
		shopVO user = shopService.Login(vo);
		if (user != null) {
			System.out.println("로그인");
			session.setAttribute("businessNum", vo.getBusinessNum());
			return "../2main.jsp";
		} else {
			System.out.println("로그인 안됨");
			return "../2login.jsp";
		}

	}

	@PostMapping(value = "join.do")
	public String join(shopVO vo) {
		shopService.join(vo);
		return "login.jsp";
	}

	@GetMapping(value = "logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		session.invalidate();
		return "../2login.jsp";
	}
}
