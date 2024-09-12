package com.ch08.entity;

import com.ch08.dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    private String uid;
    private String name;
    private String pass;
    private String birth;
    private String role;

    @CreationTimestamp
    private String rdate;

    public UserDto toDto() {
        return UserDto.builder()
                .uid(uid)
                .pass(pass)
                .name(name)
                .birth(birth)
                .role(role)
                .build();
    }
}
