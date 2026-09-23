package com.Soham.razorpay.Operations.Entities;

import com.Soham.razorpay.Common.Entities.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "settlement_payment")
public class SettlementPayment   {

    @EmbeddedId
    private SettlementPaymentId id;

    @MapsId("settlementId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "settlement_id", nullable = false)
    private Settlement settlement;
}
