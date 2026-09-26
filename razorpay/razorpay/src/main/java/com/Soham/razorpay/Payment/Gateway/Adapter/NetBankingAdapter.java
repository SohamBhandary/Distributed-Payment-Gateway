package com.Soham.razorpay.Payment.Gateway.Adapter;

import com.Soham.razorpay.Common.Enums.PaymentMethod;
import com.Soham.razorpay.Payment.Dtos.Res.PaymentResponse;
import com.Soham.razorpay.Payment.Gateway.Dto.PaymentRequest;
import com.Soham.razorpay.Payment.Gateway.Dto.PaymentResult;
import com.Soham.razorpay.Payment.Gateway.PaymentAdapter;
import com.Soham.razorpay.Payment.Processor.Dtos.PaymentProcessorRequest;
import com.Soham.razorpay.Payment.Processor.Dtos.PaymentProcessorResponse;
import com.Soham.razorpay.Payment.Processor.PaymentProcessorRouter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component("NETBANKING")
@Slf4j
@RequiredArgsConstructor
public class NetBankingAdapter implements PaymentAdapter {

    private final PaymentProcessorRouter paymentProcessorRouter;


    @Override
    public PaymentResult initiate(PaymentRequest request) {

        log.info("Initiate Payment with NetBankingAdapter, paymentId: {}", request.paymentId());

        try {
            PaymentProcessorRequest paymentProcessorRequest = PaymentProcessorRequest.nonCard(
                    request.paymentId(),
                    PaymentMethod.NETBANKING,
                    request.amount(),
                    request.methodDetails()
            );

            PaymentProcessorResponse paymentProcessorResponse =
                    paymentProcessorRouter.charge(paymentProcessorRequest);

            return switch (paymentProcessorResponse) {
                case PaymentProcessorResponse.Failure failure ->
                        new PaymentResult.Failure(failure.errorCode(), failure.errorDescription());

                case PaymentProcessorResponse.Pending pending ->
                        new PaymentResult.Pending(pending.processorReference());

                case PaymentProcessorResponse.Success success -> new PaymentResult.Success(success.bankReference());

            };
        } catch(Exception e) {
            log.warn("NetBanking failed, paymentId: {}", request.paymentId());
            return new PaymentResult.Failure("NBK_FAILED", e.getMessage());
        }




    }

    @Override
    public PaymentResult capture(UUID paymentId) {
        return new PaymentResult.Success("NBK_REF");
    }
}
