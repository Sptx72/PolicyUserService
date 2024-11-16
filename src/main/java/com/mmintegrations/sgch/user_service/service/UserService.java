package com.mmintegrations.sgch.user_service.service;

import com.mmintegrations.sgch.user_service.model.request.UpdateUserRequest;
import com.mmintegrations.sgch.user_service.model.response.GetUserResponse;
import com.mmintegrations.sgch.user_service.model.response.UserUpdatedResponse;

import java.util.UUID;

public interface UserService {
    UserUpdatedResponse updateUser(UpdateUserRequest request);

    void deleteUser(UUID id);

    GetUserResponse getUserById(UUID id);
}
