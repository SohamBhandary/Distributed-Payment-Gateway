package com.Soham.razorpay.Payment.Services;

import com.Soham.razorpay.Payment.Dtos.Req.CreateOrderRequest;
import com.Soham.razorpay.Payment.Dtos.Res.OrderResponse;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

import java.util.UUID;

public interface OrderService {
    OrderResponse create(UUID merchantId, @Valid CreateOrderRequest request);
}
