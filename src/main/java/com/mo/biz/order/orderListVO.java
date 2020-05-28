package com.mo.biz.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class orderListVO {

	int orderNum;
	String orderTime;
	String orderRequest;
	String orderState;
	int orderTotalPrice;
	String id;
	
	int detailNum;
	int detailCount;
	int menuNum;
	
	String businessNum;
	String shopName;
	String menuName;
	int menuPrice;
}
