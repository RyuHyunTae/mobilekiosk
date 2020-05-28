package com.mo.biz.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class basketVO {

	int basketNum;
	int basketCount;
	String id;
	int menuNum;
	
	String menuName;
	String menuDescription;
	int menuPrice;
	String menuPicture;
	String businessNum;
	
}
