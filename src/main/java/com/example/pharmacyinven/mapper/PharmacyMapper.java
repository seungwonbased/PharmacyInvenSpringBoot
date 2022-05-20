package com.example.pharmacyinven.mapper;

import com.example.pharmacyinven.model.PharmacyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PharmacyMapper {

    @Select("SELECT * FROM pharmacy WHERE pharmaId=#{pharmaId}")
    PharmacyVO getPharmacy(@Param("pharmaId") String pharmaId);

    @Select("SELECT * FROM pharmacy")
    List<PharmacyVO> getPharmacyList();

    @Select("SELECT pharmaId FROM pharmacy")
    List<Integer> getPharmaId();

    @Select("SELECT name FROM pharmacy")
    List<String> getPharmaName();

}
