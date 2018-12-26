package com.williansmartins.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@RequestMapping(value = { "/", "/public**" }, method = RequestMethod.GET)
	public String welcomePage() {
		return "public";
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping(value = "/dba**", method = RequestMethod.GET)
	public String dbaPage() {
		return "dba";
	}
	
	@RequestMapping("/extra")
	@ResponseBody
	public String getUsers() {
		return "{\"users\":[{\"name\":\"Lucas\", \"country\":\"Brazil\"}," +
		           "{\"name\":\"Jackie\",\"country\":\"China\"}]}";
	}

}