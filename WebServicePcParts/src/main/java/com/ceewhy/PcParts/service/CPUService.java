package com.ceewhy.PcParts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceewhy.PcParts.entity.Cpu;
import com.ceewhy.PcParts.entity.Response;
import com.ceewhy.PcParts.repository.CPURepository;

@Service
public class CPUService {
	@Autowired
	private CPURepository cpuRepository;
	public Response putCPU(Cpu cpu) {
		Response res = new Response();
		try {
			Cpu chk = cpuRepository.checkExistValue(cpu.getBrand(), cpu.getModel(), cpu.getSocket(),cpu.getCoreThread(),cpu.getFreq(),cpu.getTurbo(),cpu.getPrice());
			if(chk!=null) {
				res.setReturnCd("Failed!");
				res.setReturnMsg("Object already exists.");
			}else {
				cpuRepository.save(cpu);
				res.setReturnCd("Yes");
				res.setReturnMsg("Success!");
			}
		} catch (Exception e) {
			res.setReturnCd("No");
			res.setReturnMsg(e.getMessage());
		}
		return res;
	}
}
