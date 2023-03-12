package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Bill;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BillRepo extends JpaRepository<Bill, Long> {

    @Query(value = "select * from bill b, reading r, connection c where b.bill_id = r.bill_id AND r.connection_connection_id = c.connection_id AND consumer_number=?1", nativeQuery = true)
    public Bill readBillByConsumerNumber(long consumerNumber);

    @Query(value = "select * from bill b, reading r, connection c, customer cs where b.bill_id = r.bill_id AND r.connection_connection_id = c.connection_id AND c.customer_customer_id = cs.customer_id AND cs.mobile_number=?1", nativeQuery = true)
    public Bill readBillByMobileNumber(String mobileNumber);

    @Query(value = "select * from bill b, reading r, connection c, customer cs where b.bill_id = r.bill_id AND r.connection_connection_id = c.connection_id AND c.customer_customer_id = cs.customer_id AND cs.email=?1", nativeQuery = true)
    public Bill readBillByEmail(String email);

    @Query(value= "select * from bill b where b.bill_date >= ?1 AND b.bill_date <= ?2", nativeQuery = true)
    public List<Bill> readBillForDateRange(LocalDate from, LocalDate to);

}
