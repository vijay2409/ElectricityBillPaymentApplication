package com.example.service;

import com.example.entity.Bill;
import com.example.entity.ConnectionType;

import java.time.LocalDate;
import java.util.List;

public interface BillService {

    public Bill viewBillByConsumerNumber(long consumerNumber);
    public Bill viewBillByMobileNumber(String mobileNumber);
    public Bill viewBillByEmail(String email);
    public List<Bill> viewBillForDateRange(LocalDate from, LocalDate to);
    public double energyBillCalculator(ConnectionType type, double uintsConsumed);
    public void emailBillToCustomer(long consumerNumber, String email);
}
