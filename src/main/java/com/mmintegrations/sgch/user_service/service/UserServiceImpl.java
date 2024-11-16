package com.mmintegrations.sgch.user_service.service;

import com.mmintegrations.sgch.user_service.mapper.UserMapper;
import com.mmintegrations.sgch.user_service.model.User;
import com.mmintegrations.sgch.user_service.model.exception.UserNotFoundException;
import com.mmintegrations.sgch.user_service.model.request.UpdateUserRequest;
import com.mmintegrations.sgch.user_service.model.response.GetUserResponse;
import com.mmintegrations.sgch.user_service.model.response.UserUpdatedResponse;
import com.mmintegrations.sgch.user_service.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(
            UserRepository userRepository,
            UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public GetUserResponse getUserById(UUID id) {
        User user = findUserById(id);
        return userMapper.createGetUserResponse(user);
    }

    @Override
    @Transactional
    public UserUpdatedResponse updateUser(UpdateUserRequest request) {
        User user = findUserById(request.id());

        //Change user data for not null request params
        userMapper.updateFromRequest(user, request);

        userRepository.save(user);

        return new UserUpdatedResponse(
                user.getName(),
                user.getLastname(),
                user.getPhone()
        );
    }

    @Override
    @Transactional
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    private User findUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found found for ID: " + id));
    }

}
