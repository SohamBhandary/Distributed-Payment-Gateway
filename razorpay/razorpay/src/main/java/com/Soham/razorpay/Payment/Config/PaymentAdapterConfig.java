package com.Soham.razorpay.Payment.Config;


import com.Soham.razorpay.Common.Enums.PaymentMethod;
import com.Soham.razorpay.Payment.Gateway.Adapter.CardPaymentAdapter;
import com.Soham.razorpay.Payment.Gateway.Adapter.NetBankingAdapter;
import com.Soham.razorpay.Payment.Gateway.Adapter.UpiAdapter;
import com.Soham.razorpay.Payment.Gateway.PaymentAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class PaymentAdapterConfig {

    private final NetBankingAdapter netBankingAdapter;
    private final CardPaymentAdapter cardPaymentAdapter;
    private final UpiAdapter upiPaymentAdapter;

    @Bean
    public Map<PaymentMethod, PaymentAdapter> paymentAdapterMap() {
        return Map.of(
                PaymentMethod.CARD, cardPaymentAdapter,
                PaymentMethod.NETBANKING, netBankingAdapter,
                PaymentMethod.UPI, upiPaymentAdapter
        );
    }
}
