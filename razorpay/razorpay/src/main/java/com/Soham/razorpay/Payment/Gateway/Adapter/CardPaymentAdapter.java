package com.Soham.razorpay.Payment.Gateway.Adapter;

import com.Soham.razorpay.Payment.Dtos.Res.PaymentResponse;
import com.Soham.razorpay.Payment.Gateway.Dto.PaymentRequest;
import com.Soham.razorpay.Payment.Gateway.Dto.PaymentResult;
import com.Soham.razorpay.Payment.Gateway.PaymentAdapter;

import java.util.UUID;

public class CardPaymentAdapter implements PaymentAdapter {
    @Override
    public PaymentResult initiate(PaymentRequest request) {
        return null;
    }

    @Override
    public PaymentResult capture(UUID paymentId) {
        return null;
    }
}
