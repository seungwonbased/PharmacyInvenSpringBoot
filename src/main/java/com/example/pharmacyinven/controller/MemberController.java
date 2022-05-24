package com.example.pharmacyinven.controller;

import com.example.pharmacyinven.exception.UsernameNotFoundException;
import com.example.pharmacyinven.mapper.MemberMapper;
import com.example.pharmacyinven.model.MemberVO;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    private MemberMapper mapper;
    private MemberVO vo;

    public MemberController(MemberMapper mapper) {
        this.mapper = mapper;
    }

    @PutMapping("/member/register")
    public void registerMember(@RequestParam("id") String id,
                               @RequestParam("pw") String pw,
                               @RequestParam("name") String name,
                               @RequestParam("phone") String phone) {
        mapper.register(id, pw, name, phone);
    }

    @GetMapping("/member/loginform")
    public void login(@RequestParam("id") String id,
                      @RequestParam("pw") String pw) throws UsernameNotFoundException {
        vo = mapper.login(id, pw);
        if (!vo.equals(null)) {
            System.out.println(vo);
        } else {
            throw new UsernameNotFoundException("User not found with id: " + id);
        }

        // 추후 구현 -> 홈화면 또눈 더움 화면으로
    }

}
