package com.mo.biz.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class menuService {
	
	@Autowired
	menuDAO menuDAO;
	
	public int menuInsert(menuVO vo) {
		return menuDAO.menuInsert(vo);
	}
	
	public menuVO menuDetail(menuVO vo) {
		return menuDAO.menuDetail(vo);
	}
	
	public int menuUpdate(menuVO vo) {
		return menuDAO.menuUpdate(vo);
	}
	
	public List<menuVO> menuList(menuVO vo){
		return menuDAO.menuList(vo);
	}
	
	public int menuDelete(menuVO vo) {
		return menuDAO.menuDelete(vo);
	}
	
	public List<menuVO> menuDetail2(menuVO vo){
		return menuDAO.menuDetail2(vo);
	}
	
	public int menuBasketDelete(int menuNum) {
		return menuDAO.menuBasketDelete(menuNum);
	}
	
	public int menuMenuhitsDelete(int menuNum) {
		return menuDAO.menuMenuhitsDelete(menuNum);
	}
}
