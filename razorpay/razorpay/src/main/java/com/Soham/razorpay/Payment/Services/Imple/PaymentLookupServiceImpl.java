package com.Soham.razorpay.Payment.Services.Imple;


import com.Soham.razorpay.Common.Enums.PaymentStatus;
import com.Soham.razorpay.Payment.Api.PaymentLookupService;
import com.Soham.razorpay.Payment.Entities.Payment;
import com.Soham.razorpay.Payment.Repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentLookupServiceImpl implements PaymentLookupService {

    private final PaymentRepository paymentRepository;

    @Override
    public List<Payment> findUnsettledCapturedPayments(UUID merchantId) {
        return paymentRepository.findByMerchantIdAndStatusForUpdate(merchantId, PaymentStatus.CAPTURED);
    }
}













