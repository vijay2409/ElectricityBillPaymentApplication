package com.example.service;

import com.example.entity.Customer;
import com.example.exception.CustomerAlreadyFoundException;
import com.example.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {

    public Customer registerCustomer(Customer customer) throws CustomerAlreadyFoundException;
    public Customer viewCustomerProfile(int customerId) throws CustomerNotFoundException;
    public Customer editCustomerProfile(Customer customer, long customerId) throws CustomerNotFoundException;
    public Customer searchCustomerByCustomerId(long customerId) throws CustomerNotFoundException;
    public Customer searchCustomerByEmail(String email) throws CustomerNotFoundException;
    public Customer searchCustomerByAadhar(long aadharNumber) throws CustomerNotFoundException;
    public Customer searchCustomerByMobile(String mobile) throws CustomerNotFoundException;
    public Customer searchCustomerByName(String customerName) throws CustomerNotFoundException;
}
