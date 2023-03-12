package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Customer;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

//    public Customer createCustomer(Customer customer);
    @Query(nativeQuery = true, value= "Select * from Customer c where c.customer_id=?1")
    public Customer viewCustomerProfile(int customerId);
//    public Customer updateCustomerProfile(int customerId);

    @Query(nativeQuery = true, value = "Select * from Customer c where c.customer_id=?1")
    public Customer readCustomerByCustomerId(long customerId);
    
    @Query(nativeQuery = true, value = "Select * from Customer c where c.email=?1")
    public Customer readCustomerByEmail(String email);
    
    @Query(nativeQuery = true, value = "Select * from Customer c where c.aadhar_number=?1")
    public Customer readCustomerByAadhar(long aadharNumber);
    
    @Query(nativeQuery = true, value = "Select * from Customer c where c.mobile_number=?1")
    public Customer readCustomerByMobile(String mobileNumber);
    
    @Query(nativeQuery = true, value = "Select * from Customer c where c.first_name=?1")
    public Customer readCustomerByName(String customerName);

}
