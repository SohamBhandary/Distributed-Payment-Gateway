package com.Soham.razorpay.Payment.Gateway;

import com.Soham.razorpay.Payment.Dtos.Res.PaymentResponse;
import com.Soham.razorpay.Payment.Gateway.Dto.PaymentRequest;
import com.Soham.razorpay.Payment.Gateway.Dto.PaymentResult;

import java.util.UUID;

public interface PaymentAdapter {


   PaymentResult initiate(PaymentRequest request);

   PaymentResult capture(UUID paymentId);
}
