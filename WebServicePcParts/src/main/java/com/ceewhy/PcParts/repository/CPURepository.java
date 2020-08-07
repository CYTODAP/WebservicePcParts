package com.ceewhy.PcParts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ceewhy.PcParts.entity.Cpu;
import com.ceewhy.PcParts.entity.Mainboard;

public interface CPURepository extends JpaRepository<Cpu, Long>{
	@Query(value = "SELECT * FROM cpu m WHERE m.brand=?1 and m.model=?2 and m.socket=?3 and m.core_thread=?4 and m.freq=?5 and m.turbo=?6 and m.price=?7", nativeQuery = true)
	Cpu checkExistValue(String brand, String model, String socket, String coreThread, double freq, double turbo, int price);
	
	@Query(value = "SELECT * FROM cpu m WHERE (m.brand LIKE %?1% or m.model LIKE %?1%) and (m.price > ?2 and m.price < ?3) ", nativeQuery = true)
	List<Cpu> searchCPU(String search, String searchmin, String searchmax);
}
