package com.ceewhy.PcParts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceewhy.PcParts.entity.Mainboard;
import com.ceewhy.PcParts.entity.Response;
import com.ceewhy.PcParts.repository.MainboardRepository;

@Service
public class MainboardService {
	@Autowired
	private MainboardRepository mainboardRepository;
	public Response putMainboard(Mainboard mb) throws Exception{
		Response res = new Response();
		try {
			Mainboard chk = mainboardRepository.checkExistValue(mb.getBrand(), mb.getModel(), mb.getType(),mb.getRamSlot(),mb.getPrice());
			if(chk!=null) {
				res.setReturnCd("Failed!");
				res.setReturnMsg("Object already exists.");
			}else {
				mainboardRepository.save(mb);
				res.setReturnCd("Yes");
				res.setReturnMsg("Success!");
			}
		} catch (Exception e) {
			res.setReturnCd("No");
			res.setReturnMsg(e.getMessage());
		}
		return res;
	}
	
	public Mainboard getMainboardById(Long id) {
		Mainboard mb = new Mainboard();
		try {
			mb = mainboardRepository.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mb;
	}
	public List<Mainboard> getMainboardByBrand(String brand){
		List<Mainboard> mbbb = new ArrayList<Mainboard>();
		try {
			mbbb = mainboardRepository.getByBrand(brand);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mbbb;
	}
	
	public List<Mainboard> searchMBoard(String search){
		List<Mainboard> smb = null;
		try {
			smb = mainboardRepository.searchMBoard(search);
			if(smb.size()==0) {
				smb = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return smb;
	}
}
