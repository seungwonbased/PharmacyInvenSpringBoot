package com.example.pharmacyinven.model;

public class InventoryVO {
	private int invenId;
	private int quantity;
	private DrugVO drugVO;

	public InventoryVO() {
		super();
	}

	public InventoryVO(int invenId, int quantity, DrugVO drugVO) {
		super();
		this.invenId = invenId;
		this.quantity = quantity;
		this.drugVO = drugVO;
	}

	public int getInvenId() {
		return invenId;
	}

	public void setInvenId(int invenId) {
		this.invenId = invenId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public DrugVO getDrugVO() {
		return drugVO;
	}

	public void setDrugVO(DrugVO drugVO) {
		this.drugVO = drugVO;
	}

	@Override
	public String toString() {
		return "InventoryVO [invenId=" + invenId + ", quantity=" + quantity + ", drugVO=" + drugVO + "]";
	}

}