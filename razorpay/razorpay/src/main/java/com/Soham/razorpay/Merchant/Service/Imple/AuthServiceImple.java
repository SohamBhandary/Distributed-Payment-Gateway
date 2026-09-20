package com.Soham.razorpay.Merchant.Service.Imple;

import com.Soham.razorpay.Common.Enums.MerchantStatus;
import com.Soham.razorpay.Common.Enums.UserRole;
import com.Soham.razorpay.Common.Exception.DuplicateResourceException;
import com.Soham.razorpay.Merchant.Dtos.Req.MerchantSignupRequest;
import com.Soham.razorpay.Merchant.Dtos.Res.MerchantResponse;
import com.Soham.razorpay.Merchant.Entities.AppUser;
import com.Soham.razorpay.Merchant.Entities.Merchant;
import com.Soham.razorpay.Merchant.Repository.AppUserRepository;
import com.Soham.razorpay.Merchant.Repository.MerchantRepository;
import com.Soham.razorpay.Merchant.Service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImple implements AuthService {

    private final AppUserRepository appUserRepository;
    private final MerchantRepository merchantRepository;
    @Override
    @Transactional
    public MerchantResponse signup(MerchantSignupRequest request) {

        if (merchantRepository.existsByEmail(request.email())) {
            throw new DuplicateResourceException("DUPLICATE_MERCHANT_EMAIL",
                    "Merchant with email already exists: " + request.email());
        }

        Merchant merchant = Merchant.builder()
                .businessName(request.businessName())
                .businessType(request.businessType())
                .name(request.name())
                .email(request.email())
                .status(MerchantStatus.PENDING_KYC)
                .build();
        merchant = merchantRepository.save(merchant);

        AppUser appUser = AppUser.builder()
                .email(request.email())
                .merchant(merchant)
                .passwordHash(request.password()) // TODO: encrypt using Bcrypt
                .role(UserRole.OWNER)
                .build();
        appUserRepository.save(appUser);

        return new MerchantResponse(merchant.getId(), merchant.getName(),
                merchant.getEmail(), merchant.getBusinessName(),
                merchant.getBusinessType(), merchant.getStatus());
    }
    }

