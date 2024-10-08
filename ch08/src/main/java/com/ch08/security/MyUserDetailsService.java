package com.ch08.security;

import com.ch08.dto.UserDto;
import com.ch08.entity.User;
import com.ch08.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService { //UserDetailsService여기로 아이디를 보냄, 서버는 엔티티로 다시보내서 user반환되어 Filter로 보내는 과정에서 비밀번호도 검증

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //실질적으로 인증 처리

            //사용자가 입력한 아이디로 사용자 조회, 비밀번호에 대한 검증은 이전 컴포넌트인 AuthenticationProvider에서 수행
            Optional<User> optUser = userRepository.findById(username);

            if(optUser.isPresent()) {
                //시큐리티 사용자 인증객체 생성 후 리턴
                MyUserDetails myUserDetails = MyUserDetails.builder()
                                                            .user(optUser.get())
                                                            .build();
               return myUserDetails;
            }
            //사용자가 입력한 아이디가 없을 경우
            return null;

    }
}
