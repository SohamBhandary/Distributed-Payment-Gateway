package com.Soham.razorpay.Payment.Processor.Strategy;


import com.Soham.razorpay.Common.Utils.RandomizerUtil;
import com.Soham.razorpay.Payment.Processor.Dtos.PaymentProcessorRequest;
import com.Soham.razorpay.Payment.Processor.Dtos.PaymentProcessorResponse;
import com.Soham.razorpay.Payment.Processor.PaymentProcessor;

public class NetBankingPaymentProcessor implements PaymentProcessor {

    @Override
    public PaymentProcessorResponse charge(PaymentProcessorRequest request) {
        final String BANK_CODE_FAIL = "BANK_CODE_FAIL";

        String bankCode = request.methodDetails() != null ?
                request.methodDetails().get("BANK").toString() : null;

        // simulation
        if (BANK_CODE_FAIL.equals(bankCode)) {
            return new PaymentProcessorResponse.Failure("BANK_REJECTED",
                    "Banked rejected the transaction registration"
            );
        }

        String processorRef = "NBK_PROCESSOR_"+ RandomizerUtil.randomBase64(16);

        String redirectRef = "http://REDIRECT_BANK.com/"+processorRef;

        return new PaymentProcessorResponse.Success(processorRef, redirectRef);
    }
}
