package com.ch05.dao;

import com.ch05.dto.User3DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User3Mapper {

    public void insertUser3(User3DTO user3DTO);
    public void selectUser3(String uid);
    public List<User3DTO> selectUse3s();
    public void updateUse3(User3DTO user3DTO);
    public void deleteUse3(String uid);

}
