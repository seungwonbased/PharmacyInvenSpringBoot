package com.example.pharmacyinven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pharmacyinven.mapper.CartMapper;
import com.example.pharmacyinven.model.CartVO;

@RestController
public class CartController {
    @Autowired
    private CartMapper cartmapper;

    public CartController(CartMapper cartmapper) {
        this.cartmapper = cartmapper;
    }

    @PutMapping("/cart/insert")
    public void insertItem(@RequestParam("cartId") String cartId,
                           @RequestParam("id") String id,
                           @RequestParam("drugId") String drugId) {
        cartmapper.insertItem(cartId, id, drugId);
    }

    @DeleteMapping("/cart/delete/{cartId}")
    public void deleteItem(@PathVariable("cartId") String cartId) {
        cartmapper.deleteItem(cartId);
    }

    @GetMapping("/cart/{id}")
    public List<CartVO> getItemList(@PathVariable("id") String id) {
        return cartmapper.getItemList(id);
    }
}
