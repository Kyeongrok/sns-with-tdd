package com.likelion.sns.service;

import com.likelion.sns.model.User;
import com.likelion.sns.model.entity.UserEntity;
import com.likelion.sns.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userEntityRepository;


    // TODO : implement
    public User join(String userName, String password) {
        // 회원 가입하려는 userName으로 회원가입된 user가 있는지
        Optional<UserEntity> userEntity = userEntityRepository.findByUserName(userName);

        // 회원가입 진행 = user를 등록

        return new User();
    }

    // TODO : implement
    // 로그인을 성공 했다면 Token을 발행
    public String login(String userName, String password) {
        return "";
    }
}
