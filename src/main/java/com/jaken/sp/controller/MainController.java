package com.jaken.sp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/a/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
}
