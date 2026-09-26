package com.Soham.razorpay.Payment.Services;



import com.Soham.razorpay.Payment.Dtos.Req.PaymentInitRequest;
import com.Soham.razorpay.Payment.Dtos.Res.PaymentResponse;
import org.jspecify.annotations.Nullable;

import java.util.UUID;

public interface PaymentService {

    PaymentResponse initiate(UUID merchantId, PaymentInitRequest request);

        PaymentResponse capture(UUID merchantId, UUID paymentId);
}
