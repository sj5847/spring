package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.QCustomer;
import com.ch07.repository.shop.custom.CustomerRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

//CustomerRepository 확장 인터페이스 정의
@RequiredArgsConstructor
@Repository
public class CustomerRepositoryimpl implements CustomerRepositoryCustom {


    private final JPAQueryFactory jpaQueryFactory;

    // Q도메인 클래스 선언
    private QCustomer qCustomer = QCustomer.customer;

    @Override
    public List<Customer> selectCustomers() {

        return jpaQueryFactory
                .select(qCustomer)
                .from(qCustomer)
                .fetch();
    }

    @Override
    public Customer selectCustomer(String custId) {
        return jpaQueryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.custId.eq(custId))
                .fetchOne();
    }

    @Override
    public List<Customer> searchCustomer(String nameCondition, int ageCondition) {

        BooleanBuilder builder = new BooleanBuilder();

        if (nameCondition != null) {
            builder.and(qCustomer.name.eq(nameCondition));
        }

//        if(ageCondition > 0) {
//            builder.and(qCustomer.age.goe(ageCondition));  //goe: Greater Than or Equal
//        }

        return jpaQueryFactory
                .selectFrom(qCustomer)
                .where(builder)
                .fetch();
    }

    @Override
    public List<Customer> seachKeyword(String keyword) {
        BooleanExpression express = qCustomer
                .name.containsIgnoreCase(keyword)
                .or(qCustomer.addr.containsIgnoreCase(keyword));

        return jpaQueryFactory
                .selectFrom(qCustomer)
                .where(express)
                .fetch();
    }



}