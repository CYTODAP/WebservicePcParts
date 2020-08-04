package com.ceewhy.PcParts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ceewhy.PcParts.entity.Mainboard;

public interface MainboardRepository extends JpaRepository<Mainboard, Long> {
	
	@Query(value = "SELECT * FROM mainboard mb WHERE mb.id=?1", nativeQuery = true)
	Mainboard getById(Long id);
	
	@Query(value = "SELECT * FROM mainboard mb WHERE mb.brand=?1", nativeQuery = true)
	List<Mainboard> getByBrand(String brand);
	
	@Query(value = "SELECT * FROM mainboard m WHERE m.brand=?1 and m.model=?2 and m.type=?3 and m.ram_slot=?4 and m.price=?5", nativeQuery = true)
	Mainboard checkExistValue(String brand, String model, String type, int ramSlot, int price);
	
	@Query(value = "SELECT * FROM mainboard m WHERE m.brand LIKE %?1% or m.model LIKE %?1% or m.type LIKE %?1% or m.ram_slot LIKE %?1% or m.price LIKE %?1%", nativeQuery = true)
	List<Mainboard> searchMBoard(String search);
}
