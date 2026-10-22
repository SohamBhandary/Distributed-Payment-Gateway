package com.Soham.razorpay.Payment.Api;



import com.Soham.razorpay.Payment.Entities.Payment;

import java.util.List;
import java.util.UUID;

public interface PaymentLookupService {

    List<Payment> findUnsettledCapturedPayments(UUID merchantId);
}
