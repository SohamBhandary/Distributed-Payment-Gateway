package com.Soham.razorpay.Payment.Simulator;


import com.Soham.razorpay.Common.Enums.PaymentStatus;
import com.Soham.razorpay.Payment.Entities.Payment;
import com.Soham.razorpay.Payment.Repositories.PaymentRepository;
import com.Soham.razorpay.Payment.Services.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class BankCallbackSimulator {

    private final PaymentRepository paymentRepository;
    private final PaymentService paymentService;
    private final SimulatorConfig simulatorConfig;

    @Scheduled(fixedDelayString = "${payment.simulator.poll-interval-ms:5000}")
    public void processCallbacks() {

        LocalDateTime globalWindow = LocalDateTime.now().minusSeconds(1);

        List<Payment> candidates = paymentRepository
                .findByStatusAndCreatedAtBefore(PaymentStatus.AUTHORIZING, globalWindow);

        if (candidates.isEmpty()) return;

        for (Payment payment: candidates) {
            simulateCallback(payment); // iretate through each payment and simulate
        }

    }

    private void simulateCallback(Payment payment) {

    }

}
