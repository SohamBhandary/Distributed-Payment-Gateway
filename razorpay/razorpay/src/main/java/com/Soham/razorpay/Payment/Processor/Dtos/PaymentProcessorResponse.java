package com.Soham.razorpay.Payment.Processor.Dtos;

public sealed interface PaymentProcessorResponse permits
        PaymentProcessorResponse.Pending,
        PaymentProcessorResponse.Success,
        PaymentProcessorResponse.Failure {

    record Pending(String processorReference) implements PaymentProcessorResponse {}

    record Success(String processorReference, String bankReference) implements PaymentProcessorResponse{}

    record Failure(String errorCode, String errorDescription) implements PaymentProcessorResponse{}
}
