package com.example.pharmacyinven.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.pharmacyinven.model.CartVO;

@Mapper
public interface CartMapper {
    void insertItem(@Param("cartId") String cartId,
                    @Param("id") String id,
                    @Param("drugId") String drugId);

    void deleteItem(@Param("cartId") String cartId);

    List<CartVO> getItemList(@Param("id") String id);
}
