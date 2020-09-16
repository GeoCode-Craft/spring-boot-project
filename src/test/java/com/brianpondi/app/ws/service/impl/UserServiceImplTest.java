package com.brianpondi.app.ws.service.impl;

import com.brianpondi.app.ws.io.entity.UserEntity;
import com.brianpondi.app.ws.repository.UserRepository;
import com.brianpondi.app.ws.shared.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setFirstName("Brian");
        userEntity.setUserId("fgsjs123");
        userEntity.setEncryptedPassword("7rasdsh123");
        when(userRepository.findByEmail(anyString())).thenReturn(null);
        UserDto userDto = userService.getUser("test@test.com");

        assertNotNull(userDto);
        assertEquals("Brian", userDto.getFirstName());
    }

    @Test
    final void testGetUser_UsernameNotFoundException(){
        when(userRepository.findByEmail(anyString())).thenReturn(null);

        assertThrows(UsernameNotFoundException.class,
                ()->{
                    userService.getUser("test@test.com");
                });
    }
}