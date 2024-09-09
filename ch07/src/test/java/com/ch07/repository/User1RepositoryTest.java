package com.ch07.repository;

import com.ch07.dto.User1DTO;
import com.ch07.entity.Child;
import com.ch07.entity.Parent;
import com.ch07.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;

//

    @Test
    void findUser1bByAgeGreaterThan() {
    }
    @Test
    void findUser1ByUid() {
        User1 entity = user1Repository.findUser1ByUid("a101");
        System.out.println(entity);
    }
//
//    @Test
//    void findUser1Byname() {
//        List<User1> user = user1Repository.findUser1Byname("김춘추");
//        System.out.println(user);
//    }
//
//    @Test
//    void findUser1BynameNot() {
//        List<User1> user = user1Repository.findUser1BynameNot("김춘추");
//        System.out.println(user);
//    }
//
//
//    @Test
//    void findUser1ByUidAndName() {
//        User1 user =  user1Repository.findUser1ByUidAndName("a101", "홍두식");
//        System.out.println(user);
//    }
//
//    @Test
//    void findUser1ByUidOrName(String uid, String name) {
//        List<User1> user = user1Repository.findUser1ByUidOrName("a101", name);
//    }

//    @Test
//    void findUser1ByAgeGreaterThanEqual() {
//    }

//    @Test
//    void findUser1ByAgeLessThan() {
//    }
//
//    @Test
//    void findUser1ByAgeBetween() {
//    }
//
//    @Test
//    void findUser1ByNameLike(String name) {
//        List<User1>user = user1Repository.findUser1ByNameLike(name);
//    }
//
//    @Test
//    void findUser1BynameContains() {
//    }
//
//    @Test
//    void findUser1ByNameStartsWith() {
//    }
//
//    @Test
//    void findUser1ByNAmeEndsWith() {
//    }
//
//    @Test
//    void selectUser1WhereName() {
//    }
//
//    @Test
//    void selectUser1WhereNameParam() {
//    }

    @Test
    void selectAllFromParentJoinChild() {

        List<Object[]> list = user1Repository.selectAllFromParentJoinChild("a101");
        System.out.println(list);

        for (Object[] obj : list) {
            Parent parent = (Parent) obj[0];
            Child child = (Child) obj[1];

            System.out.println(parent);
            System.out.println(child);
        }
    }
}