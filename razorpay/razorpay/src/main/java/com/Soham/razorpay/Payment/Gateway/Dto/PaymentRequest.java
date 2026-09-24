package com.Soham.razorpay.Payment.Gateway.Dto;



import com.Soham.razorpay.Common.Entities.Money;
import com.Soham.razorpay.Common.Enums.PaymentMethod;

import java.util.Map;
import java.util.UUID;

public record PaymentRequest(
        UUID paymentId,
        UUID orderId,
        UUID merchantId,
        Money amount,
        PaymentMethod method,
        Map<String, Object> methodDetails
) {
}
