package com.example.serviceImpl;

import com.example.entity.Payment;
import com.example.entity.PaymentStatus;
import com.example.repository.PaymentRepo;
import com.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;


    @Override
    public PaymentStatus payBill(Payment payment) {
        return null;
    }

    @Override
    public void sendEmailOnPaymentCompletion(Long consumerId, String email) {

    }

    @Override
    public List<Payment> viewHistoricalPayment(long consumerNumber) {
        return null;
    }
}
