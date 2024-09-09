package com.ch07.dto;


import com.ch07.entity.User2;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

//Entity는 세터 안씀
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User2DTO {
    private String uid;

    private String name;

    private String birth;

    private String addr;
    //엔티티 변환 메서드
    public User2 toEntity() {
        return User2.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .addr(addr)
                .build();
    }
}


