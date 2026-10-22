package com.Soham.razorpay.Operations.Entities;

import com.Soham.razorpay.Common.Entities.BaseEntity;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SettlementPaymentId  {

    private UUID settlementId;

    private UUID paymentId;
}