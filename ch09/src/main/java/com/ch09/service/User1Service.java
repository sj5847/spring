package com.ch09.service;

import com.ch09.dto.User1Dto;
import com.ch09.entity.User1;
import com.ch09.repository.User1Repository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class User1Service {
    private final User1Repository user1Repository;



    public User1 insertUser1(User1Dto user1DTO) {
        User1 entity = user1DTO.toEntity();
        return user1Repository.save(entity);
    }

    public User1Dto selectUser1(String uid){

        Optional<User1> opt = user1Repository.findById(uid);

        if(opt.isPresent()){
            User1 user1 = opt.get();
            return user1.toDto();
        }
        return null;
    }

    public List<User1Dto> selectUser1s(){

        List<User1> user1s = user1Repository.findAll();

        List<User1Dto> users = user1s
                .stream()
                .map(entity -> entity.toDto())
                .collect(Collectors.toList());
        return users;
    }

    public User1 updateUser1(User1Dto user1DTO, String uid) {

        User1 updatedUser1 = user1Repository.findById(uid).orElseThrow(()->new IllegalArgumentException("id must be null"));

        updatedUser1.setName(user1DTO.getName());
        updatedUser1.setHp(user1DTO.getHp());
        updatedUser1.setBirth(user1DTO.getBirth());
        updatedUser1.setAge(user1DTO.getAge());

        return user1Repository.save(updatedUser1);
    }

    public void deleteUser1(String uid){
        if (!user1Repository.existsById(uid)){
            throw new EntityNotFoundException("user not found");
        }
        user1Repository.deleteById(uid);
    }
}


