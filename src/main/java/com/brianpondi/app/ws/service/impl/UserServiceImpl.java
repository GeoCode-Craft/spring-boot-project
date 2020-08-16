package com.brianpondi.app.ws.service.impl;

import com.brianpondi.app.ws.repository.UserRepository;
import com.brianpondi.app.ws.io.entity.UserEntity;
import com.brianpondi.app.ws.service.UserService;
import com.brianpondi.app.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserId");

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails , returnValue);

        return returnValue;
    }
}
