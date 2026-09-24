package com.Soham.razorpay.Payment.Mapper;

import com.Soham.razorpay.Common.Entities.Money;
import com.Soham.razorpay.Common.Enums.PaymentMethod;
import com.Soham.razorpay.Common.Enums.PaymentStatus;
import com.Soham.razorpay.Payment.Dtos.Res.PaymentResponse;
import com.Soham.razorpay.Payment.Entities.OrderRecord;
import com.Soham.razorpay.Payment.Entities.Payment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentResponse toResponse(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        UUID orderId = null;
        UUID id = null;
        UUID merchantId = null;
        Money amount = null;
        PaymentStatus status = null;
        PaymentMethod method = null;
        Map<String, Object> methodDetails = null;
        String errorCode = null;
        String errorDescription = null;
        LocalDateTime capturedAt = null;
        LocalDateTime createdAt = null;

        orderId = paymentOrderId( payment );
        id = payment.getId();
        merchantId = payment.getMerchantId();
        amount = payment.getAmount();
        status = payment.getStatus();
        method = payment.getMethod();
        Map<String, Object> map = payment.getMethodDetails();
        if ( map != null ) {
            methodDetails = new LinkedHashMap<String, Object>( map );
        }
        errorCode = payment.getErrorCode();
        errorDescription = payment.getErrorDescription();
        capturedAt = payment.getCapturedAt();
        createdAt = payment.getCreatedAt();

        PaymentResponse paymentResponse = new PaymentResponse( id, orderId, merchantId, amount, status, method, methodDetails, errorCode, errorDescription, capturedAt, createdAt );

        return paymentResponse;
    }

    @Override
    public List<PaymentResponse> toResponseList(List<Payment> paymentList) {
        if ( paymentList == null ) {
            return null;
        }

        List<PaymentResponse> list = new ArrayList<PaymentResponse>( paymentList.size() );
        for ( Payment payment : paymentList ) {
            list.add( toResponse( payment ) );
        }

        return list;
    }

    private UUID paymentOrderId(Payment payment) {
        OrderRecord order = payment.getOrder();
        if ( order == null ) {
            return null;
        }
        return order.getId();
    }
}
