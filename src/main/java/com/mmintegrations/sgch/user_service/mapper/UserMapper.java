package com.mmintegrations.sgch.user_service.mapper;

import com.mmintegrations.sgch.user_service.model.User;
import com.mmintegrations.sgch.user_service.model.request.UpdateUserRequest;
import com.mmintegrations.sgch.user_service.model.response.GetUserResponse;
import com.mmintegrations.sgch.user_service.model.response.UserUpdatedResponse;
import com.mmintegrations.sgch.user_service.util.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public void updateFromRequest(User user, UpdateUserRequest request) {
        if (!StringUtils.isEmpty(request.name()))
            user.setName(request.name());

        if (!StringUtils.isEmpty(request.lastname()))
            user.setLastname(request.lastname());

        if (!StringUtils.isEmpty(request.phone()))
            user.setPhone(request.phone());
    }

    public GetUserResponse createGetUserResponse(User user) {
        return new GetUserResponse(
                user.getId(),
                user.getName(),
                user.getLastname(),
                user.getEmail(),
                user.getPhone(),
                user.getAddress(),
                user.getCreatedAt()
        );
    }

    public UserUpdatedResponse createUserUpdatedResponse(User user) {
        return new UserUpdatedResponse(
                user.getName(),
                user.getLastname(),
                user.getPhone(),
                user.getAddress()
        );
    }
}
