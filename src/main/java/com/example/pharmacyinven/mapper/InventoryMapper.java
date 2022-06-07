package com.example.pharmacyinven.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.pharmacyinven.model.InventoryVO;

@Mapper
public interface InventoryMapper {
	/*
	void addInventory(@Param("drugId") String drugId, 
			@Param("quantity") int quantity);
	void minusInventory(@Param("drugId") String drugId, 
			@Param("quantity") String quantity);
	*/
	InventoryVO getInventoryByDrug(@Param("drugId") String drugId);
}