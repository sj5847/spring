package com.ch07.repository;

import com.ch07.dto.User1DTO;
import com.ch07.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User1Repository extends JpaRepository<User1, String> {
    //User1Repository<T,ID>:사용하는 엔티티 타입과 해당 엔티티의 @Id컬럼 속성 타입 선언

    //사용자 정의 쿼리 메서드
    public User1 findUser1ByUid(String uid);
    public List<User1> findUser1Byname(String name);
    public List<User1> findUser1BynameNot(String name);
    //select*from user1 where uid!='';

    public User1 findUser1ByUidAndName(String uid, String name);
    public List<User1> findUser1ByUidOrName(String uid, String name);

    public List<User1> findUser1bByAgeGreaterThan(int age);
    public List<User1> findUser1ByAgeGreaterThanEqual(int age);
    public List<User1> findUser1ByAgeLessThan(int age);
    public List<User1> findUser1ByAgeBetween(int low, int high);

    public List<User1> findUser1ByNameLike(String name);
    public List<User1> findUser1BynameContains(String name);
    public List<User1> findUser1ByNameStartsWith(String name);
    public List<User1> findUser1ByNameEndsWith(String name);



    //jPQL : jpa native sql
    @Query("select u1 from User1 as u1 where u1.age < 30") //테이블명이 아닌 엔티티 이름이므로 별칭으로 작성
    public List<User1> selectUser1UnderAge30();

    @Query("select u1 from User1 as u1 where u1.name = ?1") //테이블명이 아닌 엔티티 이름이므로 별칭으로 작성
    public List<User1> selectUser1WhereName(String name);

    @Query("select u1 from User1 as u1 where u1.name=:name") //테이블명이 아닌 엔티티 이름이므로 별칭으로 작성
    public List<User1> selectUser1WhereNameParam(@Param("name") String name);

    @Query("select p, c from Parent as p " +
            "join Child as c on p.pid=c.parent " +
            " where p.pid = :pid")
    public List<Object[]> selectAllFromParentJoinChild(@Param("pid") String pid);

}
