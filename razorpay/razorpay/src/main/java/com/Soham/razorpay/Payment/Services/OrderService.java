package com.Soham.razorpay.Payment.Services;

import com.Soham.razorpay.Payment.Dtos.Req.CreateOrderRequest;
import com.Soham.razorpay.Payment.Dtos.Res.OrderResponse;
import com.Soham.razorpay.Payment.Dtos.Res.PaymentResponse;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    OrderResponse create(UUID merchantId, @Valid CreateOrderRequest request);

    OrderResponse getById(UUID merchantId, UUID orderId);

    OrderResponse cancel(UUID merchantId, UUID orderId);

    List<PaymentResponse> listPayments(UUID merchantId, UUID orderId);
}
