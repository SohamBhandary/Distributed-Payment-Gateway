package com.Soham.razorpay.Operations.Repositories;


import com.Soham.razorpay.Operations.Entities.DlqEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DlqEventRepository extends JpaRepository<DlqEvent, UUID> {
}
