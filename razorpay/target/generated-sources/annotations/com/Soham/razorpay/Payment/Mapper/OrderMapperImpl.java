package com.Soham.razorpay.Payment.Mapper;

import com.Soham.razorpay.Common.Entities.Money;
import com.Soham.razorpay.Common.Enums.OrderStatus;
import com.Soham.razorpay.Payment.Dtos.Res.OrderResponse;
import com.Soham.razorpay.Payment.Entities.OrderRecord;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-09-23T11:26:45+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderResponse toResponse(OrderRecord orderRecord) {
        if ( orderRecord == null ) {
            return null;
        }

        UUID id = null;
        UUID merchantId = null;
        String receipt = null;
        Money amount = null;
        Integer attempts = null;
        Map<String, Object> notes = null;
        LocalDateTime expiresAt = null;
        LocalDateTime createdAt = null;

        id = orderRecord.getId();
        merchantId = orderRecord.getMerchantId();
        receipt = orderRecord.getReceipt();
        amount = orderRecord.getAmount();
        attempts = orderRecord.getAttempts();
        Map<String, Object> map = orderRecord.getNotes();
        if ( map != null ) {
            notes = new LinkedHashMap<String, Object>( map );
        }
        expiresAt = orderRecord.getExpiresAt();
        createdAt = orderRecord.getCreatedAt();

        OrderStatus status = null;

        OrderResponse orderResponse = new OrderResponse( id, merchantId, receipt, amount, status, attempts, notes, expiresAt, createdAt );

        return orderResponse;
    }
}
