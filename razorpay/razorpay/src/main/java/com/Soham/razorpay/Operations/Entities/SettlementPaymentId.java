package com.Soham.razorpay.Operations.Entities;

import com.Soham.razorpay.Common.Entities.BaseEntity;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class SettlementPaymentId extends BaseEntity {

    private UUID settlementId;

    private UUID paymentId;
}