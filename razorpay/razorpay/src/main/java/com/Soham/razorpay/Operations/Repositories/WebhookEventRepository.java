package com.Soham.razorpay.Operations.Repositories;


import com.Soham.razorpay.Common.Enums.WebhookEventStatus;
import com.Soham.razorpay.Operations.Entities.WebhookEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface WebhookEventRepository extends JpaRepository<WebhookEvent, UUID> {
    List<WebhookEvent> findByStatusAndNextRetryAtBefore(WebhookEventStatus webhookEventStatus, LocalDateTime now);
}
