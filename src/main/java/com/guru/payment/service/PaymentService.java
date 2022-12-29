package com.guru.payment.service;

import com.guru.payment.entity.Payment;
import com.guru.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment){
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setPaymentStatus(new Random().nextBoolean()?"success":"failed");
        payment.setPaymentDate(new Date());

        return paymentRepository.save(payment);
    }

}
