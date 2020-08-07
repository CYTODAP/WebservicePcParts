package com.ceewhy.PcParts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping(value = "")
	private String index() {
		return "index";
	}
}
