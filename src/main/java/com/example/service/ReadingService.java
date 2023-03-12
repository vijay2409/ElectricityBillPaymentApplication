package com.example.service;

import com.example.entity.Reading;

import java.time.LocalDate;
import java.util.List;

public interface ReadingService {

    public Reading selfSubmitReading(Reading reading);
    public Reading findMeterReadingByConsumerNumberAndBillDate(long consumerNumber, LocalDate billDate);
    public List<Reading> findByMeterReadingByConsumerNumber(Long consumerNumber);

}
