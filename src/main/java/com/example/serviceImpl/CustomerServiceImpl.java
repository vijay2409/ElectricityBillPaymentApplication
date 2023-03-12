package com.example.serviceImpl;

import com.example.entity.Customer;
import com.example.exception.CustomerAlreadyFoundException;
import com.example.exception.CustomerNotFoundException;
import com.example.repository.CustomerRepo;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

//    @Override
//    public Customer registerCustomer(Customer customer) throws CustomerAlreadyFoundException {
//        return customerRepo.save(customer);
//    }

        @Override
    public Customer registerCustomer(Customer customer) throws CustomerAlreadyFoundException{
        if(customer != null){
            return customerRepo.save(customer);
        }else
            throw new CustomerAlreadyFoundException("customer already present with email");
    }

    @Override
    public Customer viewCustomerProfile(int customerId) throws CustomerNotFoundException{
    	if(customerId != 0) {
        return customerRepo.viewCustomerProfile(customerId);
    	}else {
    		throw new CustomerNotFoundException("Customer not found for given customerId");
    	}
    }

    @Override
    public Customer editCustomerProfile(Customer customer, long customerId) throws CustomerNotFoundException{
        return customerRepo.save(customer);
    }

    @Override
    public Customer searchCustomerByCustomerId(long customerId) throws CustomerNotFoundException{
    	if(customerId != 0) {
            return customerRepo.readCustomerByCustomerId(customerId);
        	}else {
        		throw new CustomerNotFoundException("Customer not found for given customerId");
        	}
    }

    @Override
    public Customer searchCustomerByEmail(String email) throws CustomerNotFoundException{
    	if(email != null) {
            return customerRepo.readCustomerByEmail(email);
        	}else {
        		throw new CustomerNotFoundException("Customer not found for given email");
        	}
    }

    @Override
    public Customer searchCustomerByAadhar(long aadharNumber) throws CustomerNotFoundException{
    	if(aadharNumber != 0) {
            return customerRepo.readCustomerByAadhar(aadharNumber);
        	}else {
        		throw new CustomerNotFoundException("Customer not found for given aadharNumber");
        	}
    }

    @Override
    public Customer searchCustomerByMobile(String mobile) throws CustomerNotFoundException{
    	if(mobile != null) {
            return customerRepo.readCustomerByMobile(mobile);
        	}else {
        		throw new CustomerNotFoundException("Customer not found for given mobile");
        	}
    }

    @Override
    public Customer searchCustomerByName(String customerName) throws CustomerNotFoundException{
    	if(customerName != null) {
            return customerRepo.readCustomerByName(customerName);
        	}else {
        		throw new CustomerNotFoundException("Customer not found for given customerName");
        	}
    }
}
