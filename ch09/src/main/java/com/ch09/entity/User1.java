package com.ch09.entity;

import com.ch09.dto.User1Dto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "user1")
public class User1 {
    @Id
    private String uid;

    private String name;

    private String birth;

    private String hp;

    private int age;

    public User1Dto toDto() {
        return User1Dto.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .age(age)
                .build();
    }

    public void setName(String name) {
    }

    public void setHp(String hp) {
    }

    public void setBirth(String birth) {
    }

    public void setAge(int age) {
    }
}
