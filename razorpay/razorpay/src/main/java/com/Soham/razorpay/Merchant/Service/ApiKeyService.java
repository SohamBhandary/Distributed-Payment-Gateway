package com.Soham.razorpay.Merchant.Service;

import com.Soham.razorpay.Merchant.Dtos.Req.CreateApiKeyRequest;
import com.Soham.razorpay.Merchant.Dtos.Res.ApiKeyCreateResponse;
import com.Soham.razorpay.Merchant.Dtos.Res.ApiKeyResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public interface ApiKeyService {

    ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request);

  List<ApiKeyResponse> listAllApiKeys(UUID merchantId);

    void revoke(UUID merchantId, UUID keyId);

    ApiKeyCreateResponse rotate(UUID merchantId, UUID keyId);
}
