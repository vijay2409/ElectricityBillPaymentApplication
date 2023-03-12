package com.example.service;

import com.example.entity.Connection;

import java.util.List;

public interface ConnectionService {

    public Connection newConnectionRequest(Connection connection);
    public Connection searchCustomerByConsumerNumber(long consumerNumber);
    public Connection modifyConnectionAddress(Connection connection);
    public List<Connection> findActiveConnectionsByVillage(String village);
    public List<Connection> findActiveConnectionsByTaluka(String taluka);
    public List<Connection> findActiveConnectionsByDistrict(String district);
    public List<Connection> findActiveConnectionsByPincode(String pincode);
    public List<Connection> findInActiveConnectionsByVillage(String village);
    public List<Connection> findInActiveConnectionsByTaluka(String taluka);
    public List<Connection> findInActiveConnectionsByDistrict(String district);
    public List<Connection> findInActiveConnectionsByPincode(String pincode);

}
