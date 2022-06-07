package com.example.pharmacyinven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.pharmacyinven.mapper.InventoryMapper;
import com.example.pharmacyinven.model.InventoryVO;

@RestController
public class InventoryController {
	@Autowired
	private InventoryMapper inventoryMapper;

	public InventoryController(InventoryMapper inventoryMapper) {
		super();
		this.inventoryMapper = inventoryMapper;
	}
	/*
	@PutMapping("/inventory/add")
	public void addInventory(@RequestParam("drugId") String drugId,
			@RequestParam("quantity") int quantity) {
		inventoryMapper.addInventory(drugId, quantity);
	}
	@PutMapping("/inventory/minus")
	public void minusInventory(@RequestParam("drugId") String drugId,
			@RequestParam("quantity") String quantity) {
		inventoryMapper.minusInventory(drugId, quantity);
	}
	*/

	@GetMapping("/inventory/{drugId}")
	public InventoryVO getInventoryByDrug(@PathVariable("drugId") String drugId) {
		return inventoryMapper.getInventoryByDrug(drugId);
	}
}