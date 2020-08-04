package com.ceewhy.PcParts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping(value = "/addCpu")
	public String addCpu(@ModelAttribute Cpu cpu, Model model) {
		model.addAttribute("response", cpuService.putCPU(cpu));
		return "addCPU";
	}
}
