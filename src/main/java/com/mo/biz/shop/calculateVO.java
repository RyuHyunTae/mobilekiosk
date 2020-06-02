package com.mo.biz.shop;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class calculateVO {

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
	
	
}
