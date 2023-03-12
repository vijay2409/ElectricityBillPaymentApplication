package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Connection;

import java.util.List;

@Repository
public interface ConnectionRepo extends JpaRepository<Connection, Long> {

//    public Connection createConnection(Connection connection);

    @Query(nativeQuery = true, value = "Select * from Connection c where c.consumer_number=?1")
    public Connection readCustomerByConsumerNumber(long consumerNumber);

//    public Connection updateConnectionAddress(Connection connection);


    @Query(nativeQuery = true, value = "select * from connection c,address a where c.connection_status=true AND a.village=?1 AND a.address_id = c.address_id")
    public List<Connection> readActiveConnectionByVillage(String village);

    @Query(nativeQuery = true, value = "select * from connection c,address a where c.connection_status=true AND a.district=?1 AND a.address_id = c.address_id")
    public List<Connection> readActiveConnectionByDistrict(String district);

    @Query(nativeQuery = true, value = "select * from connection c,address a where c.connection_status=true AND a.taluka=?1 AND a.address_id = c.address_id")
    public List<Connection> readActiveConnectionByTaluka(String taluka);

    @Query(nativeQuery = true, value = "select * from connection c,address a where c.connection_status=true AND a.pincode=?1 AND a.address_id = c.address_id")
    public List<Connection> readActiveConnectionByPincode(String pincode);

    @Query(nativeQuery = true, value = "select * from connection c,address a where c.connection_status=false AND a.village=?1 AND a.address_id = c.address_id")
    public List<Connection> readInActiveConnectionByVillage(String village);

    @Query(nativeQuery = true, value = "select * from connection c,address a where c.connection_status=false AND a.district=?1 AND a.address_id = c.address_id")
    public List<Connection> readInActiveConnectionByDistrict(String district);

    @Query(nativeQuery = true, value = "select * from connection c,address a where c.connection_status=false AND a.taluka=?1 AND a.address_id = c.address_id")
    public List<Connection> readInActiveConnectionByTaluka(String taluka);

    @Query(nativeQuery = true, value = "select * from connection c,address a where c.connection_status=false AND a.pincode=?1 AND a.address_id = c.address_id")
    public List<Connection> readInActiveConnectionByPincode(String pincode);
}
