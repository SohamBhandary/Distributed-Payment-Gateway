package com.Soham.razorpay.Payment.Dtos.Res;



import com.Soham.razorpay.Common.Entities.Money;
import com.Soham.razorpay.Common.Enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public record OrderResponse(
        UUID id,
        UUID merchantId,
        String receipt,
        Money amount,
        OrderStatus status,
        Integer attempts,
        Map<String, Object> notes,
        LocalDateTime expiresAt,
        LocalDateTime createdAt
) {
}
