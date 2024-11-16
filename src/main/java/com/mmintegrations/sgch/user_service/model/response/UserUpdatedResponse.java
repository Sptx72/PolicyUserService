package com.mmintegrations.sgch.user_service.model.response;

public record UserUpdatedResponse(
        String name,
        String lastname,
        String phone,
        String address
) {
}
