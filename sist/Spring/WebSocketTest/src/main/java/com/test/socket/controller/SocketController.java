package com.test.socket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SocketController {

	@GetMapping("/test.do")
	public String test() {
		
		return "test";
	}
	
}











