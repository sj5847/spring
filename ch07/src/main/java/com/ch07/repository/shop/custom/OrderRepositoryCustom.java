package com.ch07.repository.shop.custom;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.Order;

import java.util.List;

public interface OrderRepositoryCustom {
    public List<Order> selectOrders();
    public Customer selectCustomer(String uid);
    public List<Customer> searchCustomer(String nameCondition, int ageCondition);
    public List<Customer> seachKeyword(String keyword);
}
