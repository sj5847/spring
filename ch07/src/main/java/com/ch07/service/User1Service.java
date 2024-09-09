package com.ch07.service;

import com.ch07.dto.User1DTO;
import com.ch07.entity.User1;
import com.ch07.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

@RequiredArgsConstructor  //생성자 주입
@Service
public class User1Service {

    private final User1Repository user1Repository;

    public void insertUser1(User1DTO user1DTO) {
        User1 entity = user1DTO.toEntity();
        user1Repository.save(entity);

    }
    public User1DTO selectUser1(String uid){
        //Optional :
        // -null 체크 검증을 손쉽고 안전하게 처리하기위한 클래스
        //Spring JPA find_ 메서드의 결과 타입
        Optional<User1>opt =  user1Repository.findById(uid);

        //Entity 존재 확인 후 Optional 타입으로 정의된 Entity 가져오기
        if(opt.isPresent()){
            User1 user1 = opt.get();  //Optional 타입으로 정의된 Entity를 가져오기

            //Entity를 DTO로 변환해서 반환
            return user1.toDTO();
        }
        return null;
    }

    public List<User1DTO> selectUser1s(){
        List<User1> user1s = user1Repository.findAll();

        //for문(외부 반복자)를 이용한 Entity 리스트를 DTO 리스트로 변환

        //List stream(내부 반복자)를 이용한 Entity 리스트를 dto 리스트로 변환
        List<User1DTO> users = user1s
                            .stream()
                            .map(entity->entity.toDTO())
                            .collect(Collectors.toList());
        return users;
    }

    public void updateUser1(User1DTO user1DTO) {

        boolean result = user1Repository.existsById(user1DTO.getUid());

        if(result) {
            //DTO를 Entity로 변환
            User1 entity = user1DTO.toEntity();

            //Entity  수정(데이터베이스 Update)
            user1Repository.save(entity);
        }

    }
    public void deleteUser1(String uid){
        //Entity  삭제(데이터베이스 delete)
        user1Repository.deleteById(uid);
    }
}
