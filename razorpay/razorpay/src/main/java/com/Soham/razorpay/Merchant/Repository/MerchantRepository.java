package com.Soham.razorpay.Merchant.Repository;

import com.Soham.razorpay.Common.Enums.MerchantStatus;
import com.Soham.razorpay.Merchant.Entities.Merchant;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, UUID> {
    boolean existsByEmail( String email);

    List<Merchant> findByStatus(MerchantStatus merchantStatus);
}
