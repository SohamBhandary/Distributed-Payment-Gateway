package com.Soham.razorpay.Merchant.Repository;

import com.Soham.razorpay.Merchant.Entities.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApiKeyRepository extends JpaRepository<ApiKey, UUID> {
}
