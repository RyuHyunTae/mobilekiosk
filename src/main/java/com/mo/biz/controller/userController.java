package com.mo.biz.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mo.biz.menu.menuService;
import com.mo.biz.menu.menuVO;
import com.mo.biz.shop.shopVO;
import com.mo.biz.user.basketVO;
import com.mo.biz.user.menuhitsVO;
import com.mo.biz.user.userService;
import com.mo.biz.user.userVO;
import com.mo.biz.user.usershopVO;

@RestController
@RequestMapping(value = "user")
public class userController {
	@Autowired
	userService userService;

	@Autowired
	menuService menuService;

	@PostMapping(value = "login.do")
	userVO login(@RequestBody userVO vo) {
		System.out.println("로그인");
		return userService.login(vo);
	}

	@PostMapping(value = "shopInsert.do")
	int shopInsert(@RequestBody usershopVO vo) {
		System.out.println("매장등록");
		shopVO sVO = new shopVO();
		sVO.setQRcode(vo.getQRcode());
		sVO = userService.getBusinessNum(sVO);
		vo.setBusinessNum(sVO.getBusinessNum());
		return userService.usershopInsert(vo);
	}

	@PostMapping(value = "shopList.do")
	List<usershopVO> shopList(@RequestBody usershopVO vo) {
		System.out.println("매장리스트");
		return userService.shopList(vo);
	}

	@PostMapping(value = "menuList.do")
	List<menuVO> menuList(@RequestBody menuVO vo) {
		System.out.println("메뉴정보");
		return menuService.menuList(vo);
	}

	@PostMapping(value = "basketInsert.do")
	int basketInsert(@RequestBody basketVO vo) {
		System.out.println("장바구니등록");
		basketVO check = new basketVO();
		check = userService.basketCheck(vo);
		if (check == null) {
			return userService.basketInsert(vo);
		} else {
			vo.setBasketNum(check.getBasketNum());
			return userService.basketCountUp(vo);
		}
	}

	@PostMapping(value = "basketCountUp.do")
	int basketCountUp(@RequestBody basketVO vo) {
		System.out.println("장바구니수량증가");
		return userService.basketCountUp(vo);
	}

	@PostMapping(value = "basketCountDown.do")
	int basketCountDown(@RequestBody basketVO vo) {
		System.out.println("장바구니수량감소");
		return userService.basketCountDown(vo);
	}

	@PostMapping(value = "basketDelete.do")
	int basketDelete(@RequestBody basketVO vo) {
		System.out.println("장바구니삭제");
		return userService.basketDelete(vo);
	}

	@PostMapping(value = "basketList.do")
	List<basketVO> basketList(@RequestBody basketVO vo) {
		System.out.println("장바구니리스트");
		return userService.basketList(vo);
	}

	@PostMapping(value = "menuDetail.do")
	List<menuVO> menuDetail(@RequestBody menuVO vo) {
		System.out.println("메뉴상세");
		System.out.println(vo.toString());
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String time1 = format1.format(time);

		menuhitsVO hits = new menuhitsVO();
		hits.setMenuNum(vo.getMenuNum());
		hits.setHitsTime(time1);
		hits.setBusinessNum(vo.getBusinessNum());
		userService.menuhitsInsert(hits);
		return menuService.menuDetail2(vo);
	}

	@PostMapping(value = "menuhits.do")
	List<menuhitsVO> menuhits(@RequestBody menuhitsVO vo) {
		System.out.println("메뉴조회목록");
		return  userService.getMenuhits(vo.getBusinessNum());
	}
}
