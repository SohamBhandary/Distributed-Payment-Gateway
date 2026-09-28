package com.Soham.razorpay.Payment.Gateway.Adapter;

import com.Soham.razorpay.Payment.Dtos.Res.PaymentResponse;
import com.Soham.razorpay.Payment.Gateway.Dto.PaymentRequest;
import com.Soham.razorpay.Payment.Gateway.Dto.PaymentResult;
import com.Soham.razorpay.Payment.Gateway.PaymentAdapter;
import com.Soham.razorpay.vault.Services.VaultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CardPaymentAdapter implements PaymentAdapter {

    private final VaultService vaultService;
    @Override
    public PaymentResult initiate(PaymentRequest request) {
        return null;
    }

    @Override
    public PaymentResult capture(UUID paymentId) {
        return null;
    }
}
