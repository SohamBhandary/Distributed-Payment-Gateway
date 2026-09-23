package com.Soham.razorpay.Payment.Services.Imple;

import com.Soham.razorpay.Common.Enums.OrderStatus;
import com.Soham.razorpay.Common.Exception.BusinessRuleViolationException;
import com.Soham.razorpay.Common.Exception.DuplicateResourceException;
import com.Soham.razorpay.Common.Exception.ResourceNotFoundException;
import com.Soham.razorpay.Payment.Dtos.Req.CreateOrderRequest;
import com.Soham.razorpay.Payment.Dtos.Res.OrderResponse;
import com.Soham.razorpay.Payment.Dtos.Res.PaymentResponse;
import com.Soham.razorpay.Payment.Entities.OrderRecord;
import com.Soham.razorpay.Payment.Entities.Payment;
import com.Soham.razorpay.Payment.Mapper.OrderMapper;
import com.Soham.razorpay.Payment.Mapper.PaymentMapper;
import com.Soham.razorpay.Payment.Repositories.OrderRepository;
import com.Soham.razorpay.Payment.Repositories.PaymentRepository;
import com.Soham.razorpay.Payment.Services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class OrderServiceImple implements OrderService {

    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final OrderMapper orderMapper;

    @Value("${payment.order.default-order-expiry-minutes:30}")
    private int defaultOrderExpiryMinutes;
    @Override
    @Transactional
    public OrderResponse create(UUID merchantId, CreateOrderRequest request) {
        if (request.receipt() != null && orderRepository.existsByMerchantIdAndReceipt(merchantId, request.receipt())) {
            throw new DuplicateResourceException("ORDER_RECEIPT_DUPLICATE", "Order with receipt already exists: " + request.receipt());
        }

        OrderRecord order = OrderRecord.builder()
                .receipt(request.receipt())
                .amount(request.amount())
                .notes(request.notes())

                .merchantId(merchantId)
                .orderStatus(OrderStatus.CREATED)
                .expiresAt(request.expiresAt() != null ? request.expiresAt() :
                        LocalDateTime.now().plusMinutes(defaultOrderExpiryMinutes))
                .build();

        order = orderRepository.save(order);

// TODO:        publish kafka event about order creation

        return orderMapper.toResponse(order);
    }

    @Override
    public OrderResponse getById(UUID merchantId, UUID orderId) {
        OrderRecord order = orderRepository.findByIdAndMerchantId(orderId, merchantId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", orderId));
        return orderMapper.toResponse(order);
    }

    @Override
    @Transactional
    public OrderResponse cancel(UUID merchantId, UUID orderId) {
        OrderRecord order = orderRepository.findByIdAndMerchantId(orderId, merchantId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", orderId));

        if(order.getOrderStatus() == OrderStatus.CANCELLED || order.getOrderStatus() == OrderStatus.PAID) {
            throw new BusinessRuleViolationException("ORDER_CANNOT_CANCEL",
                    "Cannot cancel order with status: "+order.getOrderStatus().name());
        }

        order.setOrderStatus(OrderStatus.CANCELLED);
        order = orderRepository.save(order);

        return orderMapper.toResponse(order);
    }

    @Override
    public List<PaymentResponse> listPayments(UUID merchantId, UUID orderId) {
        OrderRecord order = orderRepository.findByIdAndMerchantId(orderId, merchantId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", orderId));

        List<Payment> paymentList = paymentRepository.findByOrder_Id(order);

//        return paymentList.stream().map(
//                payment -> paymentMapper.toResponse(payment)
//        ).collect(Collectors.toList());

        return paymentMapper.toResponseList(paymentList);
    }
    }


