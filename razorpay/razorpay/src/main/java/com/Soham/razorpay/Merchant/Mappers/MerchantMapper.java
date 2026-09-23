package com.Soham.razorpay.Merchant.Mappers;


import com.Soham.razorpay.Merchant.Dtos.Req.MerchantSignupRequest;
import com.Soham.razorpay.Merchant.Dtos.Res.MerchantResponse;
import com.Soham.razorpay.Merchant.Entities.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MerchantMapper {

    Merchant toEntityFromSignUpRequest(MerchantSignupRequest request);

    MerchantResponse toResponse(Merchant merchant);
}
