package com.example.controller;

import com.example.entity.Connection;
import com.example.exception.AddressNotFoundException;
import com.example.exception.ConnectionAlreadyExistException;
import com.example.exception.ConnectionNotFoundException;
import com.example.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ConnectionController {

    @Autowired
    ConnectionService connectionService;

//    working
    @PostMapping("/connection")
    public ResponseEntity<Connection> newConnectionRequest(@RequestBody Connection connection){
        Connection con= null;
        try{
            con = connectionService.newConnectionRequest(connection);
        }catch (ConnectionAlreadyExistException e){
            e.getMessage();
        }
        return new ResponseEntity<>(con, HttpStatus.OK);
    }

//    working
    @PutMapping("/connection/updateConnection")
    public ResponseEntity<Connection> updateConnection(@RequestBody Connection connection){
        return new ResponseEntity<>(connectionService.modifyConnectionAddress(connection),HttpStatus.OK);
    }

//    working
    @GetMapping("/connection/byConsumerNumber/{consumerNumber}")
    public ResponseEntity<Connection> searchCustomerByConsumerNumber(@PathVariable long consumerNumber){
        Connection connection = null;
        try{
            connection = connectionService.searchCustomerByConsumerNumber(consumerNumber);
        }catch (ConnectionNotFoundException e){
            e.getMessage();
        }
        if(connection != null) {
            return new ResponseEntity<>(connection, HttpStatus.OK);
        }else{
            return new ResponseEntity("connection not found for given consumerNumber "+consumerNumber, HttpStatus.BAD_REQUEST);
        }
    }

//    working
    @GetMapping("/connection/byVillage/{village}")
    public ResponseEntity<List<Connection>> findActiveConnectionsByVillage(@PathVariable String village){
        List<Connection> connection = null;
        try{
            connection = connectionService.findActiveConnectionsByVillage(village);
        }catch (ConnectionNotFoundException e){
            e.getMessage();
        }
        if(!connection.isEmpty()) {
            return new ResponseEntity<>(connection, HttpStatus.OK);
        }else{
            return
                    new ResponseEntity("connection not found for given village "+village, HttpStatus.BAD_REQUEST);
        }
    }

//    working
    @GetMapping("/connection/byTaluka/{taluka}")
    public ResponseEntity<List<Connection>> findActiveConnectionsByTaluka(@PathVariable String taluka){
        List<Connection> connection = new ArrayList<>();
        try{
            connection = connectionService.findActiveConnectionsByTaluka(taluka);
        }catch (ConnectionNotFoundException e){
            e.getMessage();
        }
        if(!connection.isEmpty()) {
            return new ResponseEntity<>(connection, HttpStatus.OK);
        }else{
            return new ResponseEntity("connection not found for given taluka "+taluka, HttpStatus.BAD_REQUEST);
        }
    }

//    working
    @GetMapping("/connection/byDistrict/{district}")
    public ResponseEntity<List<Connection>> findActiveConnectionsByDistrict(@PathVariable String district){
        List<Connection> connection = new ArrayList<>();
        try{
            connection = connectionService.findActiveConnectionsByDistrict(district);
        }catch (ConnectionNotFoundException e){
            e.getMessage();
        }
        if(!connection.isEmpty()) {
            return new ResponseEntity<>(connection, HttpStatus.OK);
        }else{
            return new ResponseEntity("connection not found for given district "+district, HttpStatus.BAD_REQUEST);
        }
    }

//    working
    @GetMapping("/connection/byPincode/{pincode}")
    public ResponseEntity<List<Connection>> findActiveConnectionsByPincode(@PathVariable String pincode){
        List<Connection> connection = new ArrayList<>();
        try{
            connection = connectionService.findActiveConnectionsByPincode(pincode);
        }catch (ConnectionNotFoundException e){
            e.getMessage();
        }
        if(!connection.isEmpty()) {
            return new ResponseEntity<>(connection, HttpStatus.OK);
        }else
            return new ResponseEntity("connection not found for given pincode "+pincode, HttpStatus.BAD_REQUEST);
    }

//    working
    @GetMapping("/connection/inActiveByVillage/{village}")
    public ResponseEntity<List<Connection>> findInActiveConnectionsByVillage(@PathVariable String village){
        List<Connection> connection = null;
        try{
            connection = connectionService.findInActiveConnectionsByVillage(village);
        }catch (ConnectionNotFoundException e){
            e.getMessage();
        }
        if(!connection.isEmpty()) {
            return new ResponseEntity<>(connection, HttpStatus.OK);
        }else{
            return new ResponseEntity("connection not found for given village "+village, HttpStatus.BAD_REQUEST);
        }
    }

//    working
    @GetMapping("/connection/inActiveByTaluka/{taluka}")
    public ResponseEntity<List<Connection>> findInActiveConnectionsByTaluka(@PathVariable String taluka){
        List<Connection> connection = new ArrayList<>();
        try{
            connection = connectionService.findInActiveConnectionsByTaluka(taluka);
        }catch (ConnectionNotFoundException e){
            e.getMessage();
        }
        if(!connection.isEmpty()) {
            return new ResponseEntity<>(connection, HttpStatus.OK);
        }else{
            return new ResponseEntity("connection not found for given taluka "+taluka, HttpStatus.BAD_REQUEST);
        }
    }

//    working
    @GetMapping("/connection/inActiveByDistrict/{district}")
    public ResponseEntity<List<Connection>> findInActiveConnectionsByDistrict(@PathVariable String district){
        List<Connection> connection = new ArrayList<>();
        try{
            connection = connectionService.findInActiveConnectionsByDistrict(district);
        }catch (ConnectionNotFoundException e){
            e.getMessage();
        }
        if(!connection.isEmpty()) {
            return new ResponseEntity<>(connection, HttpStatus.OK);
        }else{
            return new ResponseEntity("connection not found for given district "+district, HttpStatus.BAD_REQUEST);
        }
    }

//    working
    @GetMapping("/connection/inActiveByPincode/{pincode}")
    public ResponseEntity<List<Connection>> findInActiveConnectionsByPincode(@PathVariable String pincode) throws AddressNotFoundException {
        List<Connection> connection = new ArrayList<>();
        try{
            connection = connectionService.findInActiveConnectionsByPincode(pincode);
        }catch (ConnectionNotFoundException e){
            e.getMessage();
        }
        if(!connection.isEmpty()) {
            return new ResponseEntity<>(connection, HttpStatus.OK);
        }else{
            return new ResponseEntity("connection not found for given pincode "+pincode, HttpStatus.BAD_REQUEST);
        }
    }

}
