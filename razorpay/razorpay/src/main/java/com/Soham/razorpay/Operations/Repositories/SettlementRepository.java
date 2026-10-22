package com.Soham.razorpay.Operations.Repositories;


import com.Soham.razorpay.Common.Enums.SettlementStatus;
import com.Soham.razorpay.Operations.Entities.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SettlementRepository extends JpaRepository<Settlement, UUID> {
    List<Settlement> findByStatus(SettlementStatus settlementStatus);
}
