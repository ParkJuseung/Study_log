package com.test.mybatis.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressDTO {
	
	private String seq;
	private String name;
	private String age;
	private String address;
	private String gender;
	
	//1(tblAddress):1(tblInfo)
	private InfoDTO info;
	
	//1(tblAddress):N(tblMemo)
	private List<MemoDTO> memo;
	
}







