package com.test.aop.model;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public class AddressDAO {

	public void list() {
		// TODO Auto-generated method stub
		System.out.println("DAO.list");
	}
	//주업무 구현 > 주소록 관리 

	public void add() {
		// TODO Auto-generated method stub
		System.out.println("DAO.add");
	}

	public void view() {
		// TODO Auto-generated method stub
		System.out.println("DAO.view");
	}

	
	
	
}
