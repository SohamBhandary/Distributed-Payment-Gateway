package com.Soham.razorpay.Payment.Services;



import com.Soham.razorpay.Payment.Dtos.Req.PaymentInitRequest;
import com.Soham.razorpay.Payment.Dtos.Res.PaymentResponse;

import java.util.UUID;

public interface PaymentService {

    PaymentResponse initiate(UUID merchantId, PaymentInitRequest request);
}
