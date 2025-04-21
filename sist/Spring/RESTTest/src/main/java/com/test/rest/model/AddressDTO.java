package com.test.rest.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AddressDTO {
	private String seq;
	private String name;
	private String age;
	private String address;
	private String gender;

	private List<MemoDTO> memo;
}






