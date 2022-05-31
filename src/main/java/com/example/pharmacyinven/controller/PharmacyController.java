package com.example.pharmacyinven.controller;

import com.example.pharmacyinven.mapper.PharmacyMapper;
import com.example.pharmacyinven.model.PharmacyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PharmacyController {

    @Autowired
    private PharmacyMapper mapper;

    public PharmacyController(PharmacyMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/pharmacy/{pharmaId}")
    public PharmacyVO getPharmacy(@PathVariable("pharmaId") String pharmaId){
        return mapper.getPharmacy(pharmaId);
    }

    @GetMapping("/pharmacy/all")
    public List<PharmacyVO> getPharmacy(){
        return mapper.getPharmacyList();
    }

}
