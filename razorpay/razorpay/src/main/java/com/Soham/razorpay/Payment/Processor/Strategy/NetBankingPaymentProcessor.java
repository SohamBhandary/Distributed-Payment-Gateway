package com.Soham.razorpay.Payment.Processor.Strategy;


import com.Soham.razorpay.Payment.Processor.Dtos.PaymentProcessorRequest;
import com.Soham.razorpay.Payment.Processor.Dtos.PaymentProcessorResponse;
import com.Soham.razorpay.Payment.Processor.PaymentProcessor;

public class NetBankingPaymentProcessor implements PaymentProcessor {

    @Override
    public PaymentProcessorResponse charge(PaymentProcessorRequest request) {

        // Call the third party
        return null;
    }
}
