package com.example.pharmacyinven.model;

public class CartVO {
    private int cartId;
    private MemberVO memberVO;
    private DrugVO drugVO;

    public CartVO() {
        super();
    }

    public CartVO(int cartId, DrugVO drugVO) {
        super();
        this.cartId = cartId;
        this.drugVO = drugVO;
    }

    public CartVO(int cartId, MemberVO memberVO, DrugVO drugVO) {
        super();
        this.cartId = cartId;
        this.memberVO = memberVO;
        this.drugVO = drugVO;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public MemberVO getMemberVO() {
        return memberVO;
    }

    public void setMemberVO(MemberVO memberVO) {
        this.memberVO = memberVO;
    }

    public DrugVO getDrugVO() {
        return drugVO;
    }

    public void setDrugVO(DrugVO drugVO) {
        this.drugVO = drugVO;
    }

    @Override
    public String toString() {
        return "CartVO [cartId=" + cartId + ", memberVO=" + memberVO + ", drugVO=" + drugVO + "]";
    }

}