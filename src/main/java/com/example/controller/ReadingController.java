package com.example.controller;

import com.example.entity.Reading;
import com.example.exception.ReadingAlreadyExistsException;
import com.example.exception.ReadingNotFoundException;
import com.example.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ReadingController {

    @Autowired
    ReadingService readingService;


    @PostMapping("/reading")
    public ResponseEntity<Reading> selfSubmitReading(@RequestBody Reading reading){
        Reading reading1 = null;
            try{
                reading1 = readingService.selfSubmitReading(reading);
            }catch (ReadingAlreadyExistsException e){
                e.getMessage();
        }
            return new ResponseEntity<>(reading1, HttpStatus.OK);
    }

    @GetMapping("/reading/findMeter")
    public ResponseEntity<?> findMeterReadingByConsumerNumberAndBillDate(@RequestParam("consumerNumber") long consumerNumber,
                                                                         @RequestParam("billDate") CharSequence billDate) {
       LocalDate localDate = LocalDate.parse(billDate);
        Reading findMeter = readingService.findMeterReadingByConsumerNumberAndBillDate(consumerNumber, localDate);

        if(findMeter != null){
            return new ResponseEntity<>(findMeter, HttpStatus.OK);
        }else
            return new ResponseEntity("meter not found", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/reading/findMeterByConsumer/{consumerNumber}")
    public ResponseEntity<List<Reading>> findMeterByConsumerNumber(@PathVariable long consumerNumber){
        List<Reading> reading = new ArrayList<>();
        try{
            reading = readingService.findByMeterReadingByConsumerNumber(consumerNumber);
        }catch (ReadingNotFoundException e){
            e.getMessage();
        }
        if (!reading.isEmpty()){
            return new ResponseEntity<>(reading, HttpStatus.OK);
        }else
            return new ResponseEntity("Reading not found with given consumerNumber "+ consumerNumber, HttpStatus.BAD_REQUEST);
    }
}
