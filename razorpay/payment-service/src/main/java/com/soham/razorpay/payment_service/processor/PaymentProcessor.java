package com.soham.razorpay.payment_service.processor;


import com.soham.razorpay.common_lib.dto.PaymentProcessorRequest;
import com.soham.razorpay.common_lib.dto.PaymentProcessorResponse;

public interface PaymentProcessor {

    PaymentProcessorResponse charge(PaymentProcessorRequest request);

}
