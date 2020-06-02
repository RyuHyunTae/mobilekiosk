package com.mo.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mo.biz.shop.shopService;
import com.mo.biz.shop.shopVO;

@Controller
@RequestMapping(value="admin")
public class adminController {

	@Autowired
	shopService shopService;
	
	@RequestMapping(value="approvalList.do")
	public ModelAndView approvalList(ModelAndView mav,shopVO vo) {
		System.out.println("가게신청목록");
		mav.addObject("approvalList",shopService.approvalList(vo));
		mav.setViewName("../1joinApplicationList.jsp");
		return mav;
	}
	
	@RequestMapping(value="approvalDetail.do")
	public ModelAndView approvalDetail(ModelAndView mav,shopVO vo) {
		System.out.println("가게신청상세정보");
		mav.addObject("approvalDetail",shopService.approvalDetail(vo));
		mav.setViewName("../1approvalDetail.jsp");
		return mav;
	}
	
	@PostMapping(value="qrcodeInsert.do")
	public String qrcodeInsert(shopVO vo) {
		System.out.println("qrcode저장");
		shopService.qrcodeInsert(vo);
		return "approvalList.do";
	}
	
}
