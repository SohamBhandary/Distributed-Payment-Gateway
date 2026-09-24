package com.Soham.razorpay.Merchant.Mappers;

import com.Soham.razorpay.Common.Enums.BusinessType;
import com.Soham.razorpay.Common.Enums.MerchantStatus;
import com.Soham.razorpay.Merchant.Dtos.Req.MerchantSignupRequest;
import com.Soham.razorpay.Merchant.Dtos.Res.MerchantResponse;
import com.Soham.razorpay.Merchant.Entities.Merchant;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-09-23T11:26:45+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class MerchantMapperImpl implements MerchantMapper {

    @Override
    public Merchant toEntityFromSignUpRequest(MerchantSignupRequest request) {
        if ( request == null ) {
            return null;
        }

        Merchant.MerchantBuilder merchant = Merchant.builder();

        merchant.name( request.name() );
        merchant.email( request.email() );
        merchant.businessType( request.businessType() );
        merchant.businessName( request.businessName() );

        return merchant.build();
    }

    @Override
    public MerchantResponse toResponse(Merchant merchant) {
        if ( merchant == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        String email = null;
        String businessName = null;
        BusinessType businessType = null;

        id = merchant.getId();
        name = merchant.getName();
        email = merchant.getEmail();
        businessName = merchant.getBusinessName();
        businessType = merchant.getBusinessType();

        MerchantStatus merchantStatus = null;

        MerchantResponse merchantResponse = new MerchantResponse( id, name, email, businessName, businessType, merchantStatus );

        return merchantResponse;
    }
}
