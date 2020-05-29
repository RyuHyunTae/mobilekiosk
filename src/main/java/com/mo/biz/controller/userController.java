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
		System.out.println("�α���");
		return userService.login(vo);
	}

	@PostMapping(value = "shopInsert.do")
	int shopInsert(@RequestBody usershopVO vo) {
		System.out.println("������");
		shopVO sVO = new shopVO();
		sVO.setQRcode(vo.getQRcode());
		sVO = userService.getBusinessNum(sVO);
		vo.setBusinessNum(sVO.getBusinessNum());
		return userService.usershopInsert(vo);
	}

	@PostMapping(value = "shopList.do")
	List<usershopVO> shopList(@RequestBody usershopVO vo) {
		System.out.println("���帮��Ʈ");
		return userService.shopList(vo);
	}

	@PostMapping(value = "menuList.do")
	List<menuVO> menuList(@RequestBody menuVO vo) {
		System.out.println("�޴�����");
		return menuService.menuList(vo);
	}

	@PostMapping(value = "basketInsert.do")
	int basketInsert(@RequestBody basketVO vo) {
		System.out.println("��ٱ��ϵ��");
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
		System.out.println("��ٱ��ϼ�������");
		return userService.basketCountUp(vo);
	}

	@PostMapping(value = "basketCountDown.do")
	int basketCountDown(@RequestBody basketVO vo) {
		System.out.println("��ٱ��ϼ�������");
		return userService.basketCountDown(vo);
	}

	@PostMapping(value = "basketDelete.do")
	int basketDelete(@RequestBody basketVO vo) {
		System.out.println("��ٱ��ϻ���");
		return userService.basketDelete(vo);
	}

	@PostMapping(value = "basketList.do")
	List<basketVO> basketList(@RequestBody basketVO vo) {
		System.out.println("��ٱ��ϸ���Ʈ");
		return userService.basketList(vo);
	}

	@PostMapping(value = "menuDetail.do")
	List<menuVO> menuDetail(@RequestBody menuVO vo) {
		System.out.println("�޴���");
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
		System.out.println("�޴���ȸ���");
		return userService.getMenuhits(vo.getBusinessNum());
	}

	@PostMapping(value = "preMenuList.do")
	List<preOrderVO> preOrderList(@RequestBody preOrderVO vo) {
		System.out.println("�����ֹ����");
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
					// �ֹ�Ƚ������
					empty = orderCount[j];
					orderCount[j] = orderCount[j + 1];
					orderCount[j + 1] = empty;

					// �޴���ȣ����
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