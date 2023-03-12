package com.example.controller;

import com.example.entity.Bill;
import com.example.exception.BillNotFoundException;
import com.example.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping("/bill/byConsumerNumber/{consNumber}")
    public ResponseEntity<Bill> readBillByConsumerNumber(@PathVariable("consNumber") long consumerNumber)
    {
        Bill bill = null;
        try{
            bill = billService.viewBillByConsumerNumber(consumerNumber);
        }catch (BillNotFoundException e){
            e.getMessage();
        }
        if(consumerNumber != 0) {
            return new ResponseEntity<>(bill, HttpStatus.OK);
        }
        else
            return new ResponseEntity("bill not found for given consumerNumber "+consumerNumber, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/bill/byMobile/{mobile}")
    public ResponseEntity<Bill> readBillByMobileNumber(@PathVariable("mobile") String mobileNumber)
    {
        Bill bill = null;
        try{
            bill = billService.viewBillByMobileNumber(mobileNumber);
        }catch (BillNotFoundException e){
            e.getMessage();
        }
        if(mobileNumber != null)
            return new ResponseEntity<>(bill,HttpStatus.OK);
        else
            return new ResponseEntity("Bill Not found for Mobile Number "+mobileNumber,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/bill/byEmail/{email}")
    public ResponseEntity<Bill> readBillByEmail(@PathVariable("email") String email)
    {
        Bill bill = null;
        try{
            bill = billService.viewBillByEmail(email);
        }catch (BillNotFoundException e){
            e.getMessage();
        }
        if(email != null)
        return new ResponseEntity<>(bill ,HttpStatus.OK);
        else
            return new ResponseEntity("Bill Not found for Email "+email,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/bill/byDate")
    public ResponseEntity<List<Bill>> readBillForDateRange(@RequestParam("from") CharSequence from,
                                                           @RequestParam("to") CharSequence to)
    {
        LocalDate _from = LocalDate.parse(from);
        LocalDate _to = LocalDate.parse(to);

        List<Bill> bill = null;
        try{
            bill = billService.viewBillForDateRange(_from, _to);
        }catch (BillNotFoundException e){
            e.getMessage();
        }
        if(_from.isBefore(_to))
        return new ResponseEntity<>(bill ,HttpStatus.OK);
        else
            return new ResponseEntity("Bill Not Found ",HttpStatus.BAD_REQUEST);
    }
}
