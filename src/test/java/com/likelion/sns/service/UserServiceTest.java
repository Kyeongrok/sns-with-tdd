package com.likelion.sns.service;

import com.likelion.sns.exception.SnsApplicationException;
import com.likelion.sns.model.entity.UserEntity;
import com.likelion.sns.repository.UserEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserEntityRepository userEntityRepository;

    @Test
    void 회원가입이_정상적으로_동작하는경우() {
        String userName = "kyeongrok";
        String password = "1q2w3e4r";
        when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.empty());
        when(userEntityRepository.save(any())).thenReturn(Optional.of(mock(UserEntity.class)));

        Assertions.assertDoesNotThrow(() -> userService.join(userName, password));
    }

    @Test
    @DisplayName("회원가입시 userName으로 가입한 유저가 이미 있는 경우")
    void join_fail1() {
        String userName = "kyeongrok";
        String password = "1q2w3e4r";

        Assertions.assertThrows(SnsApplicationException.class, () -> userService.join(userName, password));

    }
}