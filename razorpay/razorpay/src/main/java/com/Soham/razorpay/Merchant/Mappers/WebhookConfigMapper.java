package com.Soham.razorpay.Merchant.Mappers;


import com.Soham.razorpay.Merchant.Dtos.Res.WebhookConfigResponse;
import com.Soham.razorpay.Merchant.Entities.MerchantWebhookConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface WebhookConfigMapper {

    @Mapping(target = "webhookSecret", source = "rawSecret")
    WebhookConfigResponse toResponse(MerchantWebhookConfig merchantWebhookConfig, String rawSecret);

}
