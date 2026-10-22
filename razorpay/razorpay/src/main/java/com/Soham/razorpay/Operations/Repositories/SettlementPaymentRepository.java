package com.Soham.razorpay.Operations.Repositories;


import com.Soham.razorpay.Operations.Entities.SettlementPayment;
import com.Soham.razorpay.Operations.Entities.SettlementPaymentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettlementPaymentRepository extends JpaRepository<SettlementPayment, SettlementPaymentId> {
}
