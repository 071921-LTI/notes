package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping(method=RequestMethod.GET, value="/home")
	@ResponseBody
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/home2")
	public String hello2() {
		return "hello";
	}
}
