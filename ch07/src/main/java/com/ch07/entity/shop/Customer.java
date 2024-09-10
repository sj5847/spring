package com.ch07.entity.shop;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
@Table(name = "shop_customer")
public class Customer {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String custId;
    private String name;
    private String hp;
    private String addr;
    private int age;
    private LocalDateTime rdate;

}
