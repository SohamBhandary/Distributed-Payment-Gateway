package com.Soham.razorpay.Payment.Mapper;


import com.Soham.razorpay.Payment.Dtos.Res.OrderResponse;
import com.Soham.razorpay.Payment.Entities.OrderRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    OrderResponse toResponse(OrderRecord orderRecord);
}
