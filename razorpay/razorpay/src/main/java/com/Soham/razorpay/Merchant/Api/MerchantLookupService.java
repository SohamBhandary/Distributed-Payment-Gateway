package com.Soham.razorpay.Merchant.Api;



import com.Soham.razorpay.Common.Dto.SettlementBankDetails;
import com.Soham.razorpay.Common.Dto.WebhookTarget;

import java.util.List;
import java.util.UUID;

public interface MerchantLookupService {

    List<WebhookTarget> getActiveConfigsForEvent(UUID merchantId, String eventType);

    List<UUID> listActiveMerchantIds();

    SettlementBankDetails getSettlementBankDetails(UUID merchantId);

}
