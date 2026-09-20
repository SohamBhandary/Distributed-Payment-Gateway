package com.Soham.razorpay.Merchant.Dtos.Res;

import com.Soham.razorpay.Common.Enums.BusinessType;
import com.Soham.razorpay.Common.Enums.MerchantStatus;

import java.util.UUID;

public record MerchantResponse(
        UUID id,
        String name,
        String email,
        String businessName,
        BusinessType businessType,
        MerchantStatus merchantStatus
) {
}