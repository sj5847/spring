package com.ch09.service;
import com.ch09.dto.User2Dto;
import com.ch09.entity.User2;
import com.ch09.repository.User2Repository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class User2Service {
    private final User2Repository user2Repository;

    public User2 insertUser2(User2Dto user2DTO) {
        User2 entity = user2DTO.toEntity();
        return user2Repository.save(entity);
    }

    public User2Dto selectUser2(String uid){

        Optional<User2> opt = user2Repository.findById(uid);

        if(opt.isPresent()){
            User2 user2 = opt.get();
            return user2.toDto();
        }
        return null;
    }

    public List<User2Dto> selectUser2s(){

        List<User2> user2s = user2Repository.findAll();

        List<User2Dto> users = user2s
                .stream()
                .map(entity -> entity.toDto())
                .collect(Collectors.toList());
        return users;
    }

    public User2 updateUser2(User2Dto user2DTO) {
        Optional<User2> user = user2Repository.findById(user2DTO.getUid());

        if(user.isPresent()){
            return user2Repository.save(user2DTO.toEntity());

        }
        return null;
    }

    public void deleteUser2(String uid){
        Optional<User2> opt = user2Repository.findById(uid);
        if(opt.isPresent()){
            user2Repository.delete(opt.get());
        }
    }

}
