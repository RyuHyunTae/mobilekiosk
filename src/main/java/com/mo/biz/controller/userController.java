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
import com.mo.biz.user.preOrderVO;
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
		return userService.getMenuhits(vo.getBusinessNum());
	}

	@PostMapping(value = "preMenuList.do")
	List<preOrderVO> preOrderList(@RequestBody preOrderVO vo) {
		System.out.println("전날주문목록");
		List<preOrderVO> list = new ArrayList();
		list = userService.getPreOrder(vo.getBusinessNum());

		JSONArray jArrObject = new JSONArray(list);
		int list_count = jArrObject.length();
		String[] orderTime = new String[list_count];
		String[] businessNum = new String[list_count];
		int[] menuNum = new int[list_count];
		int[] orderCountNum = new int[list_count];
		int[] orderCount = new int[list_count];

		int count = 0;
		String yesterDay;
		String getDay;

		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		Date dDate = new Date();
		dDate = new Date(dDate.getTime() + (1000 * 60 * 60 * 24 * -1));
		SimpleDateFormat dSdf = new SimpleDateFormat("yyyy-MM-dd");
		String time1 = dSdf.format(dDate);
		yesterDay = time1.substring(0, 10);
		for (int i = 0; i < list_count; i++) {
			JSONObject jsonObject = jArrObject.getJSONObject(i);
			orderTime[i] = jsonObject.getString("orderTime");
			businessNum[i] = jsonObject.getString("businessNum");
			menuNum[i] = jsonObject.getInt("menuNum");
			getDay = orderTime[i].substring(0, 10);
			if (yesterDay.equals(getDay)) {
				for (int a = 0; a < count + 1; a++) {
					if (orderCountNum[a] == menuNum[i]) {
						orderCount[a]++;
						break;
					} else {
						if (a == count) {
							orderCountNum[count] = menuNum[i];
							orderCount[count] = 1;
							count++;
							break;
						}
					}
				}
			}
		}
		int empty;

		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count - i - 1; j++) {
				if (orderCount[j] < orderCount[j + 1]) {
					// 주문횟수정렬
					empty = orderCount[j];
					orderCount[j] = orderCount[j + 1];
					orderCount[j + 1] = empty;

					// 메뉴번호정렬
					empty = orderCountNum[j];
					orderCountNum[j] = orderCountNum[j + 1];
					orderCountNum[j + 1] = empty;

				}
			}
		}
		
		
		List<preOrderVO> jsonList = new ArrayList();
		int max=3;
		if(max>count) {
			max=count;
		}
		for (int a = 0; a < max; a++) {
			preOrderVO json = new preOrderVO();
			json.setMenuNum(orderCountNum[a]);
			json.setRank(a+1);
			jsonList.add(json);
		}
		return jsonList;
	}
}