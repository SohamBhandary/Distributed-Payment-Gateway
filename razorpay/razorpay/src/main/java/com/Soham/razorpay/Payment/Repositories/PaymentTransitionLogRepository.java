package com.Soham.razorpay.Payment.Repositories;


import com.Soham.razorpay.Payment.Entities.PaymentTransitionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentTransitionLogRepository extends JpaRepository<PaymentTransitionLog, UUID> {
}
