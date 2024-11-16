package com.mmintegrations.sgch.user_service.model.response;

import java.sql.Date;
import java.util.UUID;

public record GetUserResponse(
        UUID id,
        String name,
        String lastname,
        String email,
        String phone,
        Date createdAt
) {
}
