package com.Soham.razorpay.Payment.Repositories;

import com.Soham.razorpay.Payment.Entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}
