package com.ceewhy.PcParts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ceewhy.PcParts.entity.Mainboard;
import com.ceewhy.PcParts.entity.Response;
import com.ceewhy.PcParts.service.MainboardService;

@RestController
@RequestMapping(value = "/mainboard")
public class MainboardController {
	
	@Autowired
	private MainboardService mainboardService;
	
	@RequestMapping(method = RequestMethod.PUT, value = "/put")
	public Response putMainboard(@RequestBody Mainboard mb) throws Exception {
		return mainboardService.putMainboard(mb);
	}

}