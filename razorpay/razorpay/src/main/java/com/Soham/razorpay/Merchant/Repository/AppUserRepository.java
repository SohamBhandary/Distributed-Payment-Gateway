package com.Soham.razorpay.Merchant.Repository;

import com.Soham.razorpay.Merchant.Entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
import java.util.UUID;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
    Optional<AppUser> findByEmail(String email);
}
