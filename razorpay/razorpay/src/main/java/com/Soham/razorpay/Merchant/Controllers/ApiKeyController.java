package com.Soham.razorpay.Merchant.Controllers;


import com.Soham.razorpay.Merchant.Dtos.Req.CreateApiKeyRequest;
import com.Soham.razorpay.Merchant.Dtos.Res.ApiKeyCreateResponse;
import com.Soham.razorpay.Merchant.Dtos.Res.ApiKeyResponse;
import com.Soham.razorpay.Merchant.Security.MerchantContext;
import com.Soham.razorpay.Merchant.Service.ApiKeyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/merchants/api-keys")
@RequiredArgsConstructor
public class ApiKeyController {

    private final ApiKeyService apiKeyService;
    private final MerchantContext merchantContext;

    @PostMapping
    public ResponseEntity<ApiKeyCreateResponse> create(
                                                       @Valid @RequestBody CreateApiKeyRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apiKeyService.create(merchantContext.getMerchantId(), request));
    }

    @GetMapping
    public ResponseEntity<List<ApiKeyResponse>> listAllApiKeysByMerchant() {
        return ResponseEntity.ok(
                apiKeyService.listAllApiKeys(merchantContext.getMerchantId())
        );
    }
    @DeleteMapping("/keyId")
    public ResponseEntity<Void> revoke( @PathVariable UUID keyId) {
        apiKeyService.revoke(merchantContext.getMerchantId(), keyId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{keyId}/rotate")
    public ResponseEntity<ApiKeyCreateResponse> rotateKey( @PathVariable UUID keyId) {
        return ResponseEntity.ok(apiKeyService.rotate(merchantContext.getMerchantId(), keyId));
    }

}
