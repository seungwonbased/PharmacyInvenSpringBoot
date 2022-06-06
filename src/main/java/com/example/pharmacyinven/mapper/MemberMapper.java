package com.example.pharmacyinven.mapper;

import com.example.pharmacyinven.model.MemberVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {

    //  @Insert("INSERT INTO users VALUES (#{id}, #{pw}, #{name}, #{phone})")
    int registerMember(@Param("id") String id,
                 @Param("pw") String pw,
                 @Param("name") String name,
                 @Param("phone") String phone);

    //  @Select("SELECT * FROM users WHERE id=#{id} AND pw=#{pw}")
    MemberVO login(@Param("id") String id,
                   @Param("pw") String pw);

}
