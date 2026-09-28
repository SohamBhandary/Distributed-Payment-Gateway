package com.Soham.razorpay.vault.Dtos.response;


import com.Soham.razorpay.Common.Enums.CardBrand;

public record TokenizeResponse(
        String token,
        String lastFour,
        CardBrand brand,
        Integer expiryMonth,
        Integer expiryYear
) {
}
