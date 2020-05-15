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
@RequestMapping(value="menu")
public class menuController {
	
	@Autowired
	menuService menuService;
	
	
	@PostMapping(value="insert.do")
	public String menuInsert(menuVO vo) {
		System.out.println("메뉴등록");
		System.out.println(vo.toString());
		menuService.menuInsert(vo);
		return "list.do";
	}
	
	@GetMapping(value="update.do")
	public ModelAndView menuUpdate(ModelAndView mav,menuVO vo) {
		System.out.println("메뉴수정화면");
		mav.addObject("menuDetail",menuService.menuDetail(vo));
		mav.setViewName("../2menuUpdatePage.jsp");
		return mav;
	}
	
	@PostMapping(value="update.do")
	public String menuUpdate(menuVO vo) {
		System.out.println("메뉴수정");
		menuService.menuUpdate(vo);
		return "list.do";
	}
	
	@RequestMapping(value="list.do")
	public ModelAndView menuList(ModelAndView mav,menuVO vo) {
		System.out.println("메뉴리스트화면");
		mav.addObject("menuList",menuService.menuList(vo));
		mav.setViewName("../2menuList.jsp");
		return mav;
	}
	
	@GetMapping(value="detail.do")
	public ModelAndView menuDetail(ModelAndView mav,menuVO vo) {
		System.out.println("메뉴상세화면");
		mav.addObject("menuDetail",menuService.menuDetail(vo));
		mav.setViewName("../2menuDetail.jsp");
		return mav;
	}
	
	
	@GetMapping(value="delete.do")
	public String menuDelete(menuVO vo) {
		System.out.println("메뉴삭제");
		menuService.menuDelete(vo);
		return "list.do";
	}
	
}
