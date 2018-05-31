package com.jaken.sp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

	@RequestMapping("/main")
	public String main(@RequestParam(value="red",required=false) String red,RedirectAttributes ra) {
		if(red!=null &&"1".equals(red)){
			ra.addFlashAttribute("mytag","1");
//			ra.addAttribute("mytag","1");
			return "redirect:/welcome";
		}
		return "main";
	}
	
	
	
	@RequestMapping("/welcome")
	public String welcome(@ModelAttribute(value="mytag") String mytag){
		System.out.println("mytag============" +mytag);
		return "welcome";
	}
	
}
