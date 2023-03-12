package com.example.repository;

import com.example.entity.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Payment;

import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, String> {

//    public PaymentStatus createBill(Payment payment);

//    public List<Payment> readHistoricalPayment(Long consumerNumber);
}
