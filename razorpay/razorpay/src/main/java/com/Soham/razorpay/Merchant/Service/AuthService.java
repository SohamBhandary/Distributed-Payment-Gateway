package com.Soham.razorpay.Merchant.Service;

import com.Soham.razorpay.Merchant.Dtos.Req.MerchantSignupRequest;
import com.Soham.razorpay.Merchant.Dtos.Res.MerchantResponse;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

public interface AuthService {
   MerchantResponse signup(@Valid MerchantSignupRequest request);
}
