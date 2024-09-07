package com.ch06.dto;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor  //매개변수가 없는 생성자
@AllArgsConstructor //모든 매개변수가 있는 생성자
@Builder

public class User1DTO {
    private String uid;
    private String name;
    private String birth;
    private String hp;
    private int age;


}
