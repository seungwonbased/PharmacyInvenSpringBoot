package com.example.pharmacyinven.model;

public class PharmacyVO {

    private int pharmaId;
    private String name;
    private String address;
    private String phone;

    public PharmacyVO(int pharmaId, String name, String address, String phone) {
        this.pharmaId = pharmaId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getPharmaId() {
        return pharmaId;
    }

    public void setPharmaId(int pharmaId) {
        this.pharmaId = pharmaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
