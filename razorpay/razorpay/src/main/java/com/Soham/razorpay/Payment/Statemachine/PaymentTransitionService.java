package com.Soham.razorpay.Payment.Statemachine;

import com.Soham.razorpay.Common.Enums.PaymentActor;
import com.Soham.razorpay.Common.Enums.PaymentEvent;
import com.Soham.razorpay.Common.Enums.PaymentStatus;
import com.Soham.razorpay.Payment.Entities.Payment;
import com.Soham.razorpay.Payment.Entities.PaymentTransitionLog;
import com.Soham.razorpay.Payment.Repositories.PaymentTransitionLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentTransitionService {

    private final PaymentTransitionLogRepository paymentTransitionLogRepository;
    private final PaymentStateMachine paymentStateMachine;

    public PaymentStatus apply(Payment payment, PaymentEvent event) {
        PaymentStatus next = paymentStateMachine.transition(payment.getStatus(), event);
        payment.setStatus(next);
        PaymentTransitionLog log = PaymentTransitionLog.builder()
                .payment(payment)
                .fromStatus(payment.getStatus())
                .event(event)
                .toStatus(next)
                .actor(PaymentActor.SYSTEM) //TODO: fetch merchant context to identify actor
                .occurredAt(LocalDateTime.now())
                .build();

        paymentTransitionLogRepository.save(log);
        return next;
    }
}
