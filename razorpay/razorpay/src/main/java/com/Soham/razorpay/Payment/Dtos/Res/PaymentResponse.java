package com.Soham.razorpay.Payment.Dtos.Res;


import com.Soham.razorpay.Common.Entities.Money;
import com.Soham.razorpay.Common.Enums.PaymentMethod;
import com.Soham.razorpay.Common.Enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PaymentResponse(
        UUID id,
        UUID orderId,
        UUID merchantId,
        Money amount,
        PaymentStatus status,
        PaymentMethod method,
        Map<String, Object> methodDetails,
        String errorCode,
        String errorDescription,
        LocalDateTime capturedAt,
        LocalDateTime createdAt
) {

}
