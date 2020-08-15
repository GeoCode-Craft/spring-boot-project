package com.brianpondi.app.ws.service;

import com.brianpondi.app.ws.shared.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto user);
}
