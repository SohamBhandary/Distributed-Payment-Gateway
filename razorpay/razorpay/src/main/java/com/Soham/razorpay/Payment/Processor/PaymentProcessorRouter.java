package com.Soham.razorpay.Payment.Processor;


import com.Soham.razorpay.Common.Enums.PaymentMethod;
import com.Soham.razorpay.Payment.Processor.Dtos.PaymentProcessorRequest;
import com.Soham.razorpay.Payment.Processor.Dtos.PaymentProcessorResponse;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PaymentProcessorRouter {

    private Map<PaymentMethod, PaymentProcessor> paymentProcessors;

    public PaymentProcessorResponse charge(PaymentProcessorRequest request) {
        PaymentProcessor processor = paymentProcessors.get(request.method());
        if (processor == null) {
            throw new IllegalArgumentException("No payment processor registered for method: "+request.method());
        }
        return processor.charge(request);
    }
}
