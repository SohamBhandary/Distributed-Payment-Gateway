package com.soham.razorpay.merchant_service.dto.response;




import com.soham.razorpay.common_lib.enums.BusinessType;
import com.soham.razorpay.common_lib.enums.MerchantStatus;

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
