package com.Soham.razorpay.Payment.Processor;


import com.Soham.razorpay.Payment.Processor.Dtos.PaymentProcessorRequest;
import com.Soham.razorpay.Payment.Processor.Dtos.PaymentProcessorResponse;

public interface PaymentProcessor {

    PaymentProcessorResponse charge(PaymentProcessorRequest request);

}
