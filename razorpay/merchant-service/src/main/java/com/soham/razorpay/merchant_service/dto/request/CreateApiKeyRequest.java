package com.soham.razorpay.merchant_service.dto.request;


import com.soham.razorpay.common_lib.enums.Environment;

public record CreateApiKeyRequest(
        Environment environment
) {
}
