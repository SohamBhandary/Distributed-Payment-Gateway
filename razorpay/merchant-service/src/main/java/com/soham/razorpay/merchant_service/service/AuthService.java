package com.soham.razorpay.merchant_service.service;


import com.soham.razorpay.merchant_service.dto.request.LoginRequest;
import com.soham.razorpay.merchant_service.dto.request.MerchantSignupRequest;
import com.soham.razorpay.merchant_service.dto.response.LoginResponse;
import com.soham.razorpay.merchant_service.dto.response.MerchantResponse;

public interface AuthService {
    MerchantResponse signup(MerchantSignupRequest request);

    LoginResponse login(LoginRequest request);
}
