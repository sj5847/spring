package com.ch07.entity.shop;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "shop_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private int orderPrice;
    private int orderStatus;
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "custId")
    private Customer customer;
}
