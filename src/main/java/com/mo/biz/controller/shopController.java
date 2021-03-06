package com.mo.biz.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mo.biz.order.orderListVO;
import com.mo.biz.order.orderService;
import com.mo.biz.order.orderVO;
import com.mo.biz.shop.calculateVO;
import com.mo.biz.shop.shopService;
import com.mo.biz.shop.shopVO;

@Controller
@RequestMapping(value = "shop")
public class shopController {

	@Autowired
	shopService shopService;
	
	@Autowired
	orderService orderService;

	@PostMapping(value = "login.do")
	public String login(shopVO vo, HttpSession session) {
		shopVO user = shopService.Login(vo);
		if (user != null) {
			if (user.getApproval() == 2) {
				System.out.println("로그인 안됨");
				return "../2login.jsp";
			} else {
				System.out.println("로그인");
				session.setAttribute("businessNum", vo.getBusinessNum());
				return "/shop/main.do";
			}
		} else {
			System.out.println("로그인 안됨");
			return "../2login.jsp";
		}

	}

	@PostMapping(value = "join.do")
	public String join(shopVO vo) {
		shopService.join(vo);
		return "../2login.jsp";
	}

	@GetMapping(value = "logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		session.invalidate();
		return "../2login.jsp";
	}

	@GetMapping(value = "todayCalculate.do")
	public ModelAndView todayCalculate(ModelAndView mav, calculateVO vo) {
		System.out.println("당일정산화면");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		String time1 = format1.format(time);
		vo.setOrderTime(time1);
		mav.addObject("todayCalculate", shopService.todayCalculateList(vo));
		mav.setViewName("../2calculatePage.jsp");
		return mav;
	}

	@GetMapping(value = "preCalculate.do")
	public ModelAndView preCalculate(ModelAndView mav, calculateVO vo) {
		System.out.println("이전정산화면");
		mav.addObject("preCalculate", shopService.preCalculateList(vo));
		mav.setViewName("../2preCalculatePage.jsp");
		return mav;
	}

	@PostMapping(value = "main.do")
	public ModelAndView main(ModelAndView mav, orderListVO vo) {
		System.out.println("메인화면");
		shopVO state = new shopVO();
		state = shopService.shopState(vo.getBusinessNum());
		mav.addObject("data", shopService.orderList(vo));
		if (state.getShopOpen() == 2) {
			mav.setViewName("../2main.jsp");
		} else {
			mav.setViewName("../2mainStart.jsp");
		}
		return mav;
	}

	@PostMapping(value = "mainClose.do")
	public ModelAndView mainClose(ModelAndView mav, orderListVO vo) {
		System.out.println("종료");
		shopService.shopClose(vo.getBusinessNum());
		mav.addObject("data", shopService.orderList(vo));
		mav.setViewName("../2main.jsp");
		return mav;
	}

	@PostMapping(value = "mainStart.do")
	public ModelAndView mainStart(ModelAndView mav, orderListVO vo) {
		System.out.println("시작");
		shopService.shopOpen(vo.getBusinessNum());
		mav.addObject("data", shopService.orderList(vo));
		mav.setViewName("../2mainStart.jsp");
		return mav;
	}
	
	@PostMapping(value="orderApproval.do")
	public String orderApproval(orderVO vo) {
		System.out.println("완료");
		orderService.orderApproval(vo.getOrderNum());
		return "main.do";
	}
	
	@PostMapping(value="orderCancel.do")
	public String orderCancel(orderVO vo) {
		System.out.println("취소");
		orderService.orderDetailCancel(vo.getOrderNum());
		orderService.orderCancel(vo.getOrderNum());
		return "main.do";
	}
	
	

}
