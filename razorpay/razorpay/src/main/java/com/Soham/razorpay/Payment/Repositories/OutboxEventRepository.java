package com.Soham.razorpay.Payment.Repositories;

import com.Soham.razorpay.Common.Enums.OutboxStatus;
import com.Soham.razorpay.Payment.Entities.OutboxEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OutboxEventRepository extends JpaRepository<OutboxEvent, UUID> {

    List<OutboxEvent> findByStatusOrderByCreatedAtAsc(OutboxStatus status);
}
