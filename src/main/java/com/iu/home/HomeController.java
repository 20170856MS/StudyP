package com.iu.home;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.iu.home.List.ListMapper;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@Autowired
	private ListMapper listMapper;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/")
	public String home() throws Exception {
		log.info("======index========");
		return "index";
	}
}
