package com.Soham.razorpay.vault.Services;

import com.Soham.razorpay.Common.Entities.Money;
import com.Soham.razorpay.Payment.Processor.Dtos.PaymentProcessorResponse;
import com.Soham.razorpay.vault.Dtos.request.TokenizeRequest;
import com.Soham.razorpay.vault.Dtos.response.TokenizeResponse;

import java.util.Map;
import java.util.UUID;

public interface VaultService {
    TokenizeResponse tokenize(TokenizeRequest request, UUID merchantId);

    PaymentProcessorResponse charge(UUID paymentId, String token, Money amount, Map<String, Object> methodDetails);
}
