package com.Soham.razorpay.Payment.Repositories;

import com.Soham.razorpay.Common.Enums.PaymentStatus;
import com.Soham.razorpay.Payment.Entities.OrderRecord;
import com.Soham.razorpay.Payment.Entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    List<Payment> findByOrder_Id(OrderRecord order);

    Optional<Payment> findByIdAndMerchantId(UUID paymentId, UUID merchantId);

    List<Payment> findByStatusAndCreatedAtBefore(PaymentStatus paymentStatus, LocalDateTime globalWindow);
}
