package com.example.pharmacyinven.mapper;

import com.example.pharmacyinven.model.DrugVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DrugMapper {

    //  @Select("SELECT d.drugId, d.drugName, d.ingredient, d.dosage, d.company FROM
    //  drug d, pharmacy p WHERE d.pharmaId=p.pharmaId AND d.pharmaId=#{pharmaId}")
    List<DrugVO> getDrugByPharmacy(@Param("pharmaId") String pharmaId);

}
