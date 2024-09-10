package com.ch07.repository.shop;

import com.ch07.dto.CustomerDto;
import com.ch07.dto.ProductAggDto;
import com.ch07.entity.shop.*;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class ShopQueryDslTest {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    private QCustomer qCustomer = QCustomer.customer;
    private QProduct qProduct = QProduct.product;
    private QOrder qOrder = QOrder.order;

    @Test
    void test1() {
        List<Product> products = jpaQueryFactory
                .selectFrom(qProduct).fetch();

    }

    @Test
    void test2() {
        List<Product> products = jpaQueryFactory
                .select(
                        projections.fields(
                                Product.class,
                                qProduct.prodNo,
                                qProduct.prodName,
                                qProduct.price
                        )
                )
                .from(qProduct)
                .fetch();
    }

    @Test
    void test3() {
       List<Customer> customers1 =  jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.name.eq("김유신")).fetcg();
       List<Customer> customers2 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.name.eq("김유신")).fetcg();

        System.out.println(customers1);
        System.out.println(customers2);
    }

    @Test
    void test4() {
        jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.gt(30)).fetch();
        jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.goe(30)).fetch();
        jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.lt(30)).fetch();
        jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.loe(30)).fetch();
    }

    @Test
    void test5() {
        jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.addr.in("서울", "김해"))
                .fetch();

    }

    @Test
    void test6() {
        jpaQueryFactory.selectFrom(qCustomer)
                .where(qCustomer.name.like("%신"))
                .fetch();
    }

    @Test
    void test7() {
        List<Product> products = jpaQueryFactory.selectFrom(qProduct)
                .where(qProduct.stock.gt(0))
                .orderBy(qProduct.price.desc())
                .fetch();
        System.out.println(products);
    }

    @Test
    void test8() {
         jpaQueryFactory.selectFrom(qCustomer)
                .where(qProduct.stock.gt(0))
                .orderBy(qProduct.price.asc())
                .offset(0)
                .limit(3)
                .fetch();
    }

    @Test
    void test9() {
        jpaQueryFactory
                .select(
                        Projections.fields(
                                ProductAggDto.class,
                                qProduct.price.sum().as("priceSum"),
                                qProduct.price.avg().as("priceAvg"),
                                qProduct.price.max().as("priceMax"),
                                qProduct.price.min().as("priceMin")
                        )
                )
                .from(qProduct)
                .fetch();
        System.out.println();
    }

    @Test
    void test10() {
        List<CustomerDto> customerDtos = jpaQueryFactory
                .select(
                        Projections.fields(
                            CustomerDto.class,
                                qOrder.customer.custId,
                                qOrder.customer.name,
                                qOrder.customer.custId.count().as("orderCount")
                        )
                )
                .from(qOrder)
                .where(qOrder.orderStatus.eq(1))
                .groupBy(qOrder.customer.custId)
                .having(qOrder.customer.custId.count().goe(2))
                .fetch();
        System.out.println(customerDtos);
    }
    @Transactional
    @Test
    void test11() {
       List<Tuple> result =  jpaQueryFactory
                .select(qOrder, qCustomer)
                .from(qOrder)
                .join(qCustomer)
                .on(qOrder.customer.eq(qCustomer))
                .fetch();

        System.out.println(result);
    }
}
