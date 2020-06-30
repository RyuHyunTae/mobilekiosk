package com.mo.biz.shop;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class shopVO {
	String businessNum;
	String password;
	String name;
	String shopName;
	String shopAddress;
	String shopTime;
	String QRcode;
	String QRpicture;
	int approval;
	int shopOpen;
}
