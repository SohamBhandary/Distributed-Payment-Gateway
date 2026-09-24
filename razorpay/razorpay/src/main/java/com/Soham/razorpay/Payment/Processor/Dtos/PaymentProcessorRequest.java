package com.Soham.razorpay.Payment.Processor.Dtos;



import com.Soham.razorpay.Common.Entities.Money;
import com.Soham.razorpay.Common.Enums.PaymentMethod;

import java.util.Map;

public record PaymentProcessorRequest(
        PaymentMethod method,
        Money amount,
        Map<String, Object> methodDetails
) {
}
