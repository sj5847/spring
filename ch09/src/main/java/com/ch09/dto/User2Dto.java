package com.ch09.dto;


import com.ch09.entity.User1;
import com.ch09.entity.User2;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User2Dto {

    private String uid;

    private String name;

    private String birth;

    private String addr;

    //엔티티 변환 메서드
    public User2 toEntity() {  //클라이언트한테 받는 데이터
        return User2.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .addr(addr)
                .build();
    }

}
