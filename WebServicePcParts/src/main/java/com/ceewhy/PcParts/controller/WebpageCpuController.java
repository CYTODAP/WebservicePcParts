package com.ceewhy.PcParts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ceewhy.PcParts.entity.Cpu;
import com.ceewhy.PcParts.entity.Response;
import com.ceewhy.PcParts.service.CPUService;

@Controller
@RequestMapping(value = "/cpu")
public class WebpageCpuController {
	
	@Autowired
	private CPUService cpuService;
	
	@RequestMapping(value = "/addcpu")
	public String addCPU(Model model){
		model.addAttribute("cpu", new Cpu());
		model.addAttribute("response", new Response());
		return "addCPU";
	}
	@GetMapping(value = "/addCpu")
	public String addCpu(@ModelAttribute Cpu cpu, Model model) {
		model.addAttribute("response", cpuService.putCPU(cpu));
		return "addCPU";
	}
	@GetMapping(value = "/searchCPU")
	public String searchCPU(Model model) {
		return "search_cpu";
	}
	@GetMapping(value = "/searchcpu")
	public String searchCpu(@RequestParam String search, @RequestParam String searchmin,@RequestParam String searchmax, Model model) {
		model.addAttribute("search", search);
		model.addAttribute("searchmin", searchmin);
		model.addAttribute("searchmax", searchmax);
		model.addAttribute("cpus", cpuService.searchCPU(search,searchmin,searchmax));
		return "search_cpu";
	}
	
}
