package com.Soham.razorpay.Merchant.Mappers;

import com.Soham.razorpay.Merchant.Dtos.Res.WebhookConfigResponse;
import com.Soham.razorpay.Merchant.Entities.MerchantWebhookConfig;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-16T08:53:15+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class WebhookConfigMapperImpl implements WebhookConfigMapper {

    @Override
    public WebhookConfigResponse toResponse(MerchantWebhookConfig merchantWebhookConfig, String rawSecret) {
        if ( merchantWebhookConfig == null && rawSecret == null ) {
            return null;
        }

        UUID id = null;
        String targetUrl = null;
        boolean enabled = false;
        String eventTypes = null;
        if ( merchantWebhookConfig != null ) {
            id = merchantWebhookConfig.getId();
            targetUrl = merchantWebhookConfig.getTargetUrl();
            if ( merchantWebhookConfig.getEnabled() != null ) {
                enabled = merchantWebhookConfig.getEnabled();
            }
            eventTypes = merchantWebhookConfig.getEventTypes();
        }
        String webhookSecret = null;
        webhookSecret = rawSecret;

        WebhookConfigResponse webhookConfigResponse = new WebhookConfigResponse( id, targetUrl, webhookSecret, enabled, eventTypes );

        return webhookConfigResponse;
    }
}
