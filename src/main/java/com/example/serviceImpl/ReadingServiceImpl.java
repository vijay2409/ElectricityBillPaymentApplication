package com.example.serviceImpl;

import com.example.entity.Reading;
import com.example.exception.ReadingAlreadyExistsException;
import com.example.exception.ReadingNotFoundException;
import com.example.repository.ReadingRepo;
import com.example.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepo readingRepo;


    @Override
    public Reading selfSubmitReading(Reading reading) {
        if(reading != null){
            return readingRepo.save(reading);
        }else
            throw new ReadingAlreadyExistsException("reading already present with reading id");
    }

    @Override
    public Reading findMeterReadingByConsumerNumberAndBillDate(long consumerNumber, LocalDate billDate) {
        if (readingRepo.existsByConsumerNumber(consumerNumber) != 0){
            Reading reading = readingRepo.findByConsumerNumber(consumerNumber);
            if(reading.getReadingDate().equals(billDate)){
                return reading;
            }else {
                System.out.println("consumerNumber or billDate incorrect");
                return null;
            }
        }else
            return null;
    }

    @Override
    public List<Reading> findByMeterReadingByConsumerNumber(Long consumerNumber) {
        if (consumerNumber != 0){
            return readingRepo.findMeterByConsumerNumber(consumerNumber);
        }else
            throw new ReadingNotFoundException("Reading not found fot the given consumerNumber");
    }
}
