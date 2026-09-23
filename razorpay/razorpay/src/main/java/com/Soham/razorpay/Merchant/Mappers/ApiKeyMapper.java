package com.Soham.razorpay.Merchant.Mappers;


import com.Soham.razorpay.Merchant.Dtos.Res.ApiKeyCreateResponse;
import com.Soham.razorpay.Merchant.Dtos.Res.ApiKeyResponse;
import com.Soham.razorpay.Merchant.Entities.ApiKey;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApiKeyMapper {

    ApiKeyCreateResponse toCreateResponse(ApiKey apiKey);

    List<ApiKeyResponse> toResponseList(List<ApiKey> apiKeyList);
}
