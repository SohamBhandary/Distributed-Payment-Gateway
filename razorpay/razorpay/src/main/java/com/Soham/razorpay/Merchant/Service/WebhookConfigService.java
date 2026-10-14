package com.Soham.razorpay.Merchant.Service;


import com.Soham.razorpay.Merchant.Dtos.Req.UpdateWebhookConfigRequest;
import com.Soham.razorpay.Merchant.Dtos.Res.WebhookConfigResponse;

import java.util.List;
import java.util.UUID;

public interface WebhookConfigService {

    WebhookConfigResponse create(UUID merchantId, UpdateWebhookConfigRequest request);

    List<WebhookConfigResponse> list(UUID merchantId);

    WebhookConfigResponse getById(UUID merchantId, UUID configId);

    WebhookConfigResponse update(UUID merchantId, UUID configId, UpdateWebhookConfigRequest request);

    void delete(UUID merchantId, UUID configId);

}
