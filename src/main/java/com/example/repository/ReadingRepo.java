package com.example.repository;

import com.example.entity.Customer;
import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Reading;
import java.util.List;

@Repository
public interface ReadingRepo extends JpaRepository<Reading, Long> {

//    public Reading selfSubmitReading(Reading reading);


    @Query(nativeQuery = true, value = "select count(*) from Connection c where c.consumer_number=?1")
    public long existsByConsumerNumber(long consumerNumber);

    @Query(nativeQuery = true, value = "select * from reading r,Connection c where c.consumer_number=?1 AND r.connection_connection_id = c.connection_id;")
    public Reading findByConsumerNumber(long consumerNumber);

    @Query(nativeQuery = true, value = "select * from reading r,Connection c where c.consumer_number=?1 AND r.connection_connection_id = c.connection_id;")
    public List<Reading> findMeterByConsumerNumber(long consumerNumber);

//    public Reading readMeterReadingByConsumerNumberAndBillDate(long consumerNumber, LocalDate billDate);

//    public List<Reading> readMeterReadingByConsumerNumber(long consumerNumber);
}
