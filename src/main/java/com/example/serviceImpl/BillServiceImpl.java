package com.example.serviceImpl;

import com.example.entity.Bill;
import com.example.entity.ConnectionType;
import com.example.exception.BillNotFoundException;
import com.example.repository.BillRepo;
import com.example.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepo billRepo;


    @Override
    public Bill viewBillByConsumerNumber(long consumerNumber) {
        if(consumerNumber != 0){
            return billRepo.readBillByConsumerNumber(consumerNumber);
        }else
            throw new BillNotFoundException("bill nor found for the given consumeNumber");
    }

    @Override
    public Bill viewBillByMobileNumber(String mobileNumber) {
        if(mobileNumber != null){
            return billRepo.readBillByMobileNumber(mobileNumber);
        }else
            throw new BillNotFoundException("bill nor found for the given mobileNumber");
    }

    @Override
    public Bill viewBillByEmail(String email) {
        if(email != null){
            return billRepo.readBillByEmail(email);
        }else
            throw new BillNotFoundException("bill nor found for the given email");
    }

    @Override
    public List<Bill> viewBillForDateRange(LocalDate from, LocalDate to) {
        if(billRepo.readBillForDateRange(from, to) != null){
            return billRepo.readBillForDateRange(from, to);
        }
        else
            throw new BillNotFoundException("Bill Not Found");
    }

    @Override
    public double energyBillCalculator(ConnectionType type, double uintsConsumed) {

        return 0;
    }

    @Override
    public void emailBillToCustomer(long consumerNumber, String email) {

    }
}
