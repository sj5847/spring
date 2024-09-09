package com.ch07.service;

import com.ch07.dto.User2DTO;
import com.ch07.entity.User2;
import com.ch07.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class User2Service {

    private final User2Repository user2Repository;

    public void insertUser2(User2DTO user2DTO) {
        User2 user = user2DTO.toEntity();
        user2Repository.save(user);

    }

    public User2DTO selectUser2(String uid) {
        Optional<User2> user2 = user2Repository.findById(uid);
        if(user2.isPresent()) {
            User2 user = user2.get();
            return user.toDto();
        }
        return null;
    }

    public List<User2DTO> selectUser2s() {
        List<User2> user2s = user2Repository.findAll();

        List<User2DTO> users = user2s
                            .stream()
                            .map(entity ->entity.toDto())
                            .collect(Collectors.toList());
        return users;
    }

    public void updateUser2(User2DTO user2DTO) {
        Optional<User2> user = user2Repository.findById(user2DTO.getUid());

        if(user.isPresent()) {
            User2 user2 = user2DTO.toEntity();
            user2Repository.save(user2);
        }

    }

    public void deleteUser2(String uid) {
        user2Repository.deleteById(uid);
    }

}
