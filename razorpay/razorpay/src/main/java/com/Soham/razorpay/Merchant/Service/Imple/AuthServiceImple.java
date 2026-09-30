package com.Soham.razorpay.Merchant.Service.Imple;

import com.Soham.razorpay.Common.Enums.MerchantStatus;
import com.Soham.razorpay.Common.Enums.UserRole;
import com.Soham.razorpay.Common.Exception.DuplicateResourceException;
import com.Soham.razorpay.Common.Exception.ResourceNotFoundException;
import com.Soham.razorpay.Merchant.Dtos.Req.LoginRequest;
import com.Soham.razorpay.Merchant.Dtos.Req.MerchantSignupRequest;
import com.Soham.razorpay.Merchant.Dtos.Res.LoginResponse;
import com.Soham.razorpay.Merchant.Dtos.Res.MerchantResponse;
import com.Soham.razorpay.Merchant.Entities.AppUser;
import com.Soham.razorpay.Merchant.Entities.Merchant;
import com.Soham.razorpay.Merchant.Mappers.MerchantMapper;
import com.Soham.razorpay.Merchant.Repository.AppUserRepository;
import com.Soham.razorpay.Merchant.Repository.MerchantRepository;
import com.Soham.razorpay.Merchant.Security.JwtUtil;
import com.Soham.razorpay.Merchant.Service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImple implements AuthService {

    private final AppUserRepository appUserRepository;
    private final MerchantRepository merchantRepository;
    private final MerchantMapper merchantMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    @Override
    @Transactional
    public MerchantResponse signup(MerchantSignupRequest request) {

        if (merchantRepository.existsByEmail(request.email())) {
            throw new DuplicateResourceException("DUPLICATE_MERCHANT_EMAIL",
                    "Merchant with email already exists: " + request.email());
        }

        Merchant merchant = merchantMapper.toEntityFromSignUpRequest(request);
        merchant.setStatus(MerchantStatus.PENDING_KYC);
        merchant = merchantRepository.save(merchant);

        AppUser appUser = AppUser.builder()
                .email(request.email())
                .merchant(merchant)
                .passwordHash(passwordEncoder.encode(request.password())) // TODO: encrypt using Bcrypt
                .role(UserRole.OWNER)
                .build();
        appUserRepository.save(appUser);

        return merchantMapper.toResponse(merchant);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );

        AppUser appUser = appUserRepository.findByEmail(request.email())
                .orElseThrow(() -> new ResourceNotFoundException("User", request.email()));

        String token = jwtUtil.generateAccessToken(request.email(), appUser.getMerchant().getId(), appUser.getRole().toString());

        return new LoginResponse(token);
    }
}

