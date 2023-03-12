package com.example.service;

import com.example.entity.Payment;
import com.example.entity.PaymentStatus;

import java.util.List;

public interface PaymentService {
    public PaymentStatus payBill(Payment payment);
    public void sendEmailOnPaymentCompletion(Long consumerId, String email);
    public List<Payment> viewHistoricalPayment(long consumerNumber);

}
