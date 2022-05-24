package com.example.pharmacyinven.model;

public class DrugVO {
    private String drugId;
    private String drugName;
    private String ingredient;
    private String dosage;
    private String company;
    private PharmacyVO pharmacyVO;

    public DrugVO(String drugId, String drugName, String ingredient, String dosage, String company, PharmacyVO pharmacyVO) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.ingredient = ingredient;
        this.dosage = dosage;
        this.company = company;
        this.pharmacyVO = pharmacyVO;
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public PharmacyVO getPharmacyVO() {
        return pharmacyVO;
    }

    public void setPharmacyVO(PharmacyVO pharmacyVO) {
        this.pharmacyVO = pharmacyVO;
    }

    @Override
    public String toString() {
        return "DrugVO{" +
                "drugId='" + drugId + '\'' +
                ", drugName='" + drugName + '\'' +
                ", ingredient='" + ingredient + '\'' +
                ", dosage='" + dosage + '\'' +
                ", company='" + company + '\'' +
                ", pharmacyVO=" + pharmacyVO +
                '}';
    }
}
