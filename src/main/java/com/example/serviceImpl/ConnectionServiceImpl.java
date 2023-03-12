package com.example.serviceImpl;

import com.example.entity.Connection;
import com.example.exception.AddressNotFoundException;
import com.example.exception.ConnectionAlreadyExistException;
import com.example.exception.ConnectionNotFoundException;
import com.example.repository.ConnectionRepo;
import com.example.repository.CustomerRepo;
import com.example.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    @Autowired
    ConnectionRepo connectionRepo;

    @Autowired
    CustomerRepo customerRepo;


    @Override
    public Connection newConnectionRequest(Connection connection) throws ConnectionAlreadyExistException{
        if(connection != null){
            return connectionRepo.save(connection);
        }else
            throw  new ConnectionAlreadyExistException("Connection already exists");
    }

    @Override
    public Connection searchCustomerByConsumerNumber(long consumerNumber) throws ConnectionNotFoundException{
        if(consumerNumber != 0){
            return connectionRepo.readCustomerByConsumerNumber(consumerNumber);
        }else{
            throw new ConnectionNotFoundException("connection not found with consumerNumber");
        }
    }

    @Override
    public Connection modifyConnectionAddress(Connection connection) throws ConnectionNotFoundException{
        return connectionRepo.save(connection);
    }

    @Override
    public List<Connection> findActiveConnectionsByVillage(String village) throws AddressNotFoundException {
        if(village != null){
            return connectionRepo.readActiveConnectionByVillage(village);
        }else
            throw new ConnectionNotFoundException("connection not found with given village name");
    }

    @Override
    public List<Connection> findActiveConnectionsByTaluka(String taluka) throws AddressNotFoundException{
        if(taluka != null){
            return connectionRepo.readActiveConnectionByTaluka(taluka);
        }else
            throw new ConnectionNotFoundException("connection not found with given taluka name");
    }

    @Override
    public List<Connection> findActiveConnectionsByDistrict(String district) throws AddressNotFoundException{
        if(district != null){
            return connectionRepo.readActiveConnectionByDistrict(district);
        }else
            throw new ConnectionNotFoundException("connection not found with given district name");
    }

    @Override
    public List<Connection> findActiveConnectionsByPincode(String pincode) throws AddressNotFoundException{
        if(pincode != null){
            return connectionRepo.readActiveConnectionByPincode(pincode);
        }else
            throw new ConnectionNotFoundException("connection not found with given pincode name");
    }

    @Override
    public List<Connection> findInActiveConnectionsByVillage(String village) throws AddressNotFoundException{
        if(village != null){
            return connectionRepo.readInActiveConnectionByVillage(village);
        }else
            throw new ConnectionNotFoundException("connection not found with given village name");
    }

    @Override
    public List<Connection> findInActiveConnectionsByTaluka(String taluka) throws AddressNotFoundException{
        if(taluka != null){
            return connectionRepo.readInActiveConnectionByTaluka(taluka);
        }else
            throw new ConnectionNotFoundException("connection not found with given taluka name");
    }

    @Override
    public List<Connection> findInActiveConnectionsByDistrict(String district) throws AddressNotFoundException{
        if(district != null){
            return connectionRepo.readInActiveConnectionByDistrict(district);
        }else
            throw new ConnectionNotFoundException("connection not found with given district name");
    }

    @Override
    public List<Connection> findInActiveConnectionsByPincode(String pincode) throws AddressNotFoundException{
        if(pincode != null){
            return connectionRepo.readInActiveConnectionByPincode(pincode);
        }else
            throw new ConnectionNotFoundException("connection not found with given pincode name");
    }
}
