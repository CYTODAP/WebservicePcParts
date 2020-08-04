package com.ceewhy.PcParts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mainboard")

public class Mainboard {
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@Column(name="brand")
	private String brand;
	@Column(name="model")
	private String model;
	@Column(name="type")
	private String type;
	@Column(name="ram_slot")
	private int ramSlot;
	@Column(name="price")
	private int price;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRamSlot() {
		return ramSlot;
	}
	public void setRamSlot(int ramSlot) {
		this.ramSlot = ramSlot;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
