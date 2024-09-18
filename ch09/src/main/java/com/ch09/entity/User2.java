package com.ch09.entity;

import com.ch09.dto.User2Dto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "user2")
public class User2 {
    @Id
    private String uid;

    private String name;

    private String birth;

    private String addr;


    public User2Dto toDto() {
        return User2Dto.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .addr(addr)
                .build();
    }

}
