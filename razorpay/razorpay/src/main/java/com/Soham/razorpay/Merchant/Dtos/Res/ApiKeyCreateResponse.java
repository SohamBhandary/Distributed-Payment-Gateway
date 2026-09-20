package com.Soham.razorpay.Merchant.Dtos.Res;



import com.Soham.razorpay.Common.Enums.Environment;

import java.util.UUID;

public record ApiKeyCreateResponse(
        UUID id,
        String keyId,
        String keySecret,
        Environment environment
) {
}
