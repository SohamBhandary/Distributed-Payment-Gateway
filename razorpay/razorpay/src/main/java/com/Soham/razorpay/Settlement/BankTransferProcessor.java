package com.Soham.razorpay.Settlement;



import com.Soham.razorpay.Common.Entities.Money;
import com.Soham.razorpay.Settlement.Dto.BankTransferResult;

import java.util.UUID;

public interface BankTransferProcessor {

    BankTransferResult initiate(UUID settlementId, UUID merchantId, Money amount,
                                String bankAccount, String ifsc);
}
