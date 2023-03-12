package com.example.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Payment {
    
    @Id
    private long paymentId;
    private LocalDate paymentDate;
    private double latePaymentCharges;
    private double totalPaid;
    private PaymentStatus status;

    @OneToOne
    private Bill bill;

    public Payment() {
    }

    public Payment(long paymentId, LocalDate paymentDate, double latePaymentCharges, double totalPaid, PaymentStatus status, Bill bill) {
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.latePaymentCharges = latePaymentCharges;
        this.totalPaid = totalPaid;
        this.status = status;
        this.bill = bill;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getLatePaymentCharges() {
        return latePaymentCharges;
    }

    public void setLatePaymentCharges(double latePaymentCharges) {
        this.latePaymentCharges = latePaymentCharges;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
