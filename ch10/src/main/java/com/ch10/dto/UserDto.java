package com.ch10.dto;

import com.ch10.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String uid;
    @JsonIgnore
    private String pass;
    private String name;
    private String birth;
    private String role;
    private String rdate;

    public User toEntity(){
        return User.builder()
                .uid(uid)
                .pass(pass)
                .name(name)
                .birth(birth)
                .role(role)
                .build();
    }
}