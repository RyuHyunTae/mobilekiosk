package com.mo.biz.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class usershopVO {

	int usershopNum;
	String id;
	
	String businessNum;
	String password;
	String name;
	String shopName;
	String shopAddress;
	String shopTime;
	String QRcode;
	int approval;
	int shopOpen;
}
