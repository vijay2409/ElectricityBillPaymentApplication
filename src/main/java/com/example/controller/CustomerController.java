package com.example.controller;

import com.example.entity.Customer;
import com.example.exception.CustomerAlreadyFoundException;
import com.example.exception.CustomerNotFoundException;
import com.example.service.CustomerService;
import com.example.serviceImpl.CustomerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

//    working frontEnd done
    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws CustomerAlreadyFoundException{
        Customer cust = null;
        try{
            cust = customerService.registerCustomer(customer);
        }catch (CustomerAlreadyFoundException e){
            e.getMessage();
        }
        return new ResponseEntity<>(cust, HttpStatus.OK);
    }

//    working done frontEnd
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Customer> viewCustomerByProfile(@PathVariable int customerId) throws CustomerNotFoundException{
        Customer customer = null;
        try{
            customer = customerService.viewCustomerProfile(customerId);
        }catch (CustomerNotFoundException e){
            e.getMessage();
        }
        if(customer != null){
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }else{
            return new ResponseEntity("Customer not found for given customerId "+customerId, HttpStatus.BAD_REQUEST);
        }
    }

//    working
    @PutMapping("/customer/{customerId}")
    public ResponseEntity<Customer> editCustomer(@PathVariable int customerId, @RequestBody Customer customer) throws CustomerNotFoundException{
        return  new ResponseEntity<>(customerService.editCustomerProfile(customer, customerId),HttpStatus.OK);
    }

//    working done frontEnd
    @GetMapping("/customer/byId/{customerId}")
    public ResponseEntity<Customer> searchCustomerByCustomerId(@PathVariable long customerId) throws CustomerNotFoundException{
        Customer customer = null;
        try{
            customer = customerService.searchCustomerByCustomerId(customerId);
        }catch (CustomerNotFoundException e){
            e.getMessage();
        }
        if(customer != null){
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }else{
            return new ResponseEntity("Customer not found for given customerId "+customerId, HttpStatus.BAD_REQUEST);
        }
    }
    
//    working done frontEnd
    @GetMapping("/customer/byEmail/{email}")
    public ResponseEntity<Customer> searchCustomerByEmail(@PathVariable String email) throws CustomerNotFoundException{
        Customer customer = null;
        try{
            customer = customerService.searchCustomerByEmail(email);
        }catch (CustomerNotFoundException e){
            e.getMessage();
        }
        if(customer != null){
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }else{
            return new ResponseEntity("Customer not found for given email "+email, HttpStatus.BAD_REQUEST);
        }
    }
    
//    working done frontEnd
    @GetMapping("/customer/byAadhar/{aadharNumber}")
    public ResponseEntity<Customer> searchCustomerByAadhar(@PathVariable long aadharNumber) throws CustomerNotFoundException{
        Customer customer = null;
        try{
            customer = customerService.searchCustomerByAadhar(aadharNumber);
        }catch (CustomerNotFoundException e){
            e.getMessage();
        }
        if(customer != null){
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }else{
            return new ResponseEntity("Customer not found for given aadharNumber "+aadharNumber, HttpStatus.BAD_REQUEST);
        }
    }
    
//    working done fronEnd
    @GetMapping("/customer/byMobile/{mobile}")
    public ResponseEntity<Customer> searchCustomerByMobile(@PathVariable String mobile) throws CustomerNotFoundException{
        Customer customer = null;
        try{
            customer = customerService.searchCustomerByMobile(mobile);
        }catch (CustomerNotFoundException e){
            e.getMessage();
        }
        if(customer != null){
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }else{
            return new ResponseEntity("Customer not found for given mobile "+mobile, HttpStatus.BAD_REQUEST);
        }
    }
    
//    working done frontEnd
    @GetMapping("/customer/byName/{customerName}")
    public ResponseEntity<Customer> searchCustomerByName(@PathVariable String customerName) throws CustomerNotFoundException{
        Customer customer = null;
        try{
            customer = customerService.searchCustomerByName(customerName);
        }catch (CustomerNotFoundException e){
            e.getMessage();
        }
        if(customer != null){
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }else{
            return new ResponseEntity("Customer not found for given customerName "+customerName, HttpStatus.BAD_REQUEST);
        }
    }

}
