package com.Soham.razorpay.Payment.Mapper;


import com.Soham.razorpay.Payment.Dtos.Res.PaymentResponse;
import com.Soham.razorpay.Payment.Entities.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {

    @Mapping(target = "orderId", source = "order.id")
    PaymentResponse toResponse(Payment payment);

    List<PaymentResponse> toResponseList(List<Payment> paymentList);
}
