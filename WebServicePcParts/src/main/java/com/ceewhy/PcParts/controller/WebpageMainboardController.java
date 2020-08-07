package com.ceewhy.PcParts.controller;

import java.util.List;

import javax.xml.ws.soap.Addressing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ceewhy.PcParts.entity.Mainboard;
import com.ceewhy.PcParts.entity.Response;
import com.ceewhy.PcParts.service.MainboardService;

@Controller
@RequestMapping(value = "/mainboard")
public class WebpageMainboardController {

	@Autowired
	private MainboardService mainboardService;

	@RequestMapping(value = "/addmainboard")
	public String addMainboard(Model model){
		model.addAttribute("mainboard", new Mainboard());
		model.addAttribute("response", new Response());
		return "addMainboard";
	}
	@GetMapping(value = "/addMBoard")
	public String addMBoard(@ModelAttribute Mainboard mb,Model model) throws Exception {
		model.addAttribute("response", mainboardService.putMainboard(mb));
		return "addMainboard";
	}
	@RequestMapping(value = "/searchmainboard")
	public String searchMainboard(Model model) {
		model.addAttribute("search",new String());
		model.addAttribute("mainboards", null);
		return "search_mainboard";
	}
	@GetMapping(value = "/searchMBoard")
	public String searchMBoard(@RequestParam String search, Model model){
		model.addAttribute("search", search);
		model.addAttribute("mainboards", mainboardService.searchMBoard(search));
		return "search_mainboard";
	}
}
