package com.Soham.razorpay.Merchant.Api;



import com.Soham.razorpay.Common.Dto.WebhookTarget;

import java.util.List;
import java.util.UUID;

public interface MerchantWebhookApi {

    List<WebhookTarget> getActiveConfigsForEvent(UUID merchantId, String eventType);

}
