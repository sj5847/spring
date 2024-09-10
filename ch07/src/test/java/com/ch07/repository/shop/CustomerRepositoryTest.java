package com.ch07.repository.shop;

import com.ch07.entity.shop.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//CustomerRepository 확장 인터페이스 정의
@Repository
public class CustomerRepositoryTest{

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void selectCustomers() {
        List<Customer> customers = customerRepository.selectCustomers();
        System.out.println(customers);
    }

//    @Test
//    public void selectProjectionCustomers() {
//        List<Customer> customers = customerRepository.selectProjectionCustomer();
//        System.out.println(customers);
//    }
    @Test
    public void selectCustomer() {
        Customer customer = customerRepository.selectCustomer("a101");
        System.out.println(customer);
    }


    public List<Customer> searchCustomer() {
        customerRepository.searchCustomer("김유신", 23);
        customerRepository.searchCustomer("김유신", 23);
        customerRepository.searchCustomer(null, 23);
        customerRepository.searchCustomer(null, 0);
        return List.of();
    }

    public void seachKeyword() {

        List<Customer> customers1 = customerRepository.seachKeyword("유신");

        System.out.println(customers1);

    }
}