package com.ch07.repository.shop;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.Order;
import com.ch07.entity.shop.OrderItem;
import com.ch07.entity.shop.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShopRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ProductRepository productRepository;

    @Test
    void insertCustomer() {
        Customer customer = Customer.builder()
                .custId("a101")
                .name("홍길덩")
                .hp("010-1111-1111")
                .addr("개금동")
                .build();

    }

    @Test
    public void insertProduct() {
        Product product = Product.builder()
                .prodNo(1)
                .prodName("침대")
                .stock(4)
                .price(120000)
                .company("독일")
                .build();
        productRepository.save(product);
    }
}
