package com.Soham.razorpay.Payment.Config;


import com.Soham.razorpay.Common.Enums.PaymentMethod;
import com.Soham.razorpay.Payment.Processor.PaymentProcessor;
import com.Soham.razorpay.Payment.Processor.Strategy.CardPaymentProcessor;
import com.Soham.razorpay.Payment.Processor.Strategy.NetBankingPaymentProcessor;
import com.Soham.razorpay.Payment.Processor.Strategy.UpiPaymentProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class PaymentProcessorConfig {

    private final CardPaymentProcessor cardPaymentProcessor;
    private final NetBankingPaymentProcessor netBankingPaymentProcessor;
    private final UpiPaymentProcessor upiPaymentProcessor;

    @Bean
    public Map<PaymentMethod, PaymentProcessor> paymentProcessorMap() {
        return Map.of(
                PaymentMethod.CARD, cardPaymentProcessor,
                PaymentMethod.NETBANKING, netBankingPaymentProcessor,
                PaymentMethod.UPI, upiPaymentProcessor
        );
    }
}
