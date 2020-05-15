package com.mo.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mo.biz.menu.menuService;
import com.mo.biz.menu.menuVO;

@Controller
@RequestMapping("menu")
public class menuController {
	
	@Autowired
	menuService menuService;
	
	
	@PostMapping("insert.do")
	public String menuInsert(menuVO vo) {
		System.out.println("메뉴등록");
		menuService.menuInsert(vo);
		return "";
	}
	
	@GetMapping("update.do")
	public ModelAndView menuUpdate(ModelAndView mav,menuVO vo) {
		mav.addObject("menuDetail",menuService.menuDetail(vo));
		mav.setViewName("../2MenuUpdate.jsp");
		return mav;
	}
	
	@PostMapping("update.do")
	public String menuUpdate(menuVO vo) {
		System.out.println("메뉴수정");
		menuService.menuUpdate(vo);
		return "";
	}
	
	@GetMapping("list.do")
	public ModelAndView menuList(ModelAndView mav,menuVO vo) {
		mav.addObject("menuList",menuService.menuList(vo));
		mav.setViewName("../2menuList.jsp");
		return mav;
	}
}
