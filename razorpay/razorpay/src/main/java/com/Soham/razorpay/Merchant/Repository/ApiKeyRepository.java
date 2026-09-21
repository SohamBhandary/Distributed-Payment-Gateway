package com.Soham.razorpay.Merchant.Repository;

import com.Soham.razorpay.Merchant.Dtos.Res.ApiKeyResponse;
import com.Soham.razorpay.Merchant.Entities.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ApiKeyRepository extends JpaRepository<ApiKey, UUID> {
    List<ApiKey> findByMerchant_Id(UUID merchantId);
}
