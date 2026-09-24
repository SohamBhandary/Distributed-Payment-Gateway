package com.Soham.razorpay.Merchant.Mappers;

import com.Soham.razorpay.Common.Enums.Environment;
import com.Soham.razorpay.Merchant.Dtos.Res.ApiKeyCreateResponse;
import com.Soham.razorpay.Merchant.Dtos.Res.ApiKeyResponse;
import com.Soham.razorpay.Merchant.Entities.ApiKey;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-09-23T11:26:45+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class ApiKeyMapperImpl implements ApiKeyMapper {

    @Override
    public ApiKeyCreateResponse toCreateResponse(ApiKey apiKey) {
        if ( apiKey == null ) {
            return null;
        }

        UUID id = null;
        String keyId = null;
        Environment environment = null;

        id = apiKey.getId();
        keyId = apiKey.getKeyId();
        environment = apiKey.getEnvironment();

        String keySecret = null;

        ApiKeyCreateResponse apiKeyCreateResponse = new ApiKeyCreateResponse( id, keyId, keySecret, environment );

        return apiKeyCreateResponse;
    }

    @Override
    public List<ApiKeyResponse> toResponseList(List<ApiKey> apiKeyList) {
        if ( apiKeyList == null ) {
            return null;
        }

        List<ApiKeyResponse> list = new ArrayList<ApiKeyResponse>( apiKeyList.size() );
        for ( ApiKey apiKey : apiKeyList ) {
            list.add( apiKeyToApiKeyResponse( apiKey ) );
        }

        return list;
    }

    protected ApiKeyResponse apiKeyToApiKeyResponse(ApiKey apiKey) {
        if ( apiKey == null ) {
            return null;
        }

        UUID id = null;
        String keyId = null;
        Environment environment = null;
        boolean enabled = false;
        LocalDateTime lastUsedAt = null;
        LocalDateTime createdAt = null;

        id = apiKey.getId();
        keyId = apiKey.getKeyId();
        environment = apiKey.getEnvironment();
        enabled = apiKey.isEnabled();
        lastUsedAt = apiKey.getLastUsedAt();
        createdAt = apiKey.getCreatedAt();

        ApiKeyResponse apiKeyResponse = new ApiKeyResponse( id, keyId, environment, enabled, lastUsedAt, createdAt );

        return apiKeyResponse;
    }
}
