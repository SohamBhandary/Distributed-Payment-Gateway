package com.Soham.razorpay.Payment.Config;


import com.Soham.razorpay.Common.Enums.PaymentMethod;
import com.Soham.razorpay.Payment.Gateway.Adapter.CardPaymentAdapter;
import com.Soham.razorpay.Payment.Gateway.Adapter.NetBankingAdapter;
import com.Soham.razorpay.Payment.Gateway.Adapter.UpiAdapter;
import com.Soham.razorpay.Payment.Gateway.PaymentAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class PaymentAdapterConfig {

    @Bean
    public Map<PaymentMethod, PaymentAdapter> paymentAdapterMap() {
        return Map.of(
                PaymentMethod.CARD, new CardPaymentAdapter(),
                PaymentMethod.NETBANKING, new NetBankingAdapter(),
                PaymentMethod.UPI, new UpiAdapter()
        );
    }
}
