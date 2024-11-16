package com.mmintegrations.sgch.user_service.model.request;

import java.util.UUID;

public record UpdateUserRequest(
        UUID id,
        String name,
        String lastname,
        String phone,
        String address
) {

}
