package com.Soham.razorpay.vault.Repositories;

import com.Soham.razorpay.vault.entities.VaultCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VaultCardRepository extends JpaRepository<VaultCard, UUID> {
}