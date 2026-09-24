package com.Soham.razorpay.Payment.Config;


import com.Soham.razorpay.Common.Enums.PaymentMethod;
import com.Soham.razorpay.Payment.Processor.PaymentProcessor;
import com.Soham.razorpay.Payment.Processor.Strategy.CardPaymentProcessor;
import com.Soham.razorpay.Payment.Processor.Strategy.NetBankingPaymentProcessor;
import com.Soham.razorpay.Payment.Processor.Strategy.UpiPaymentProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class PaymentProcessorConfig {

    @Bean
    public Map<PaymentMethod, PaymentProcessor> paymentProcessorMap() {
        return Map.of(
                PaymentMethod.CARD, new CardPaymentProcessor(),
                PaymentMethod.NETBANKING, new NetBankingPaymentProcessor(),
                PaymentMethod.UPI, new UpiPaymentProcessor()
        );
    }
}
