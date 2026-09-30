package com.Soham.razorpay.Payment.Controllers;


import com.Soham.razorpay.Payment.Dtos.Req.PaymentInitRequest;
import com.Soham.razorpay.Payment.Dtos.Res.PaymentResponse;
import com.Soham.razorpay.Payment.Services.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/v1/payments")
@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    UUID merchantId = UUID.fromString("709ac22f-fc6a-4bfc-8a51-5c23bd351e9a"); //TODO: replace it with MerchantContext

    @PostMapping
    public ResponseEntity<PaymentResponse> initiate(@Valid @RequestBody PaymentInitRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(paymentService.initiate(merchantId, request));
    }

    @PostMapping("/{paymentId}/capture")
    public ResponseEntity<PaymentResponse> capture(@PathVariable UUID paymentId) {
        return ResponseEntity.ok(paymentService.capture(merchantId, paymentId));
    }

}
