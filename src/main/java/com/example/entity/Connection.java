package com.example.entity;


import javax.persistence.*;

import java.time.LocalDate;

@Entity
public class Connection {

    @Id
    private long connectionId;

    @Column(unique = true)
    private long consumerNumber;
    private LocalDate applicationDate;
    private LocalDate connectionDate;
    private boolean connectionStatus;

    @OneToOne
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address address;


    public Connection() {
    }

    public Connection(long connectionId, long consumerNumber, LocalDate applicationDate, LocalDate connectionDate, boolean connectionStatus, Customer customer, Address address) {
        this.connectionId = connectionId;
        this.consumerNumber = consumerNumber;
        this.applicationDate = applicationDate;
        this.connectionDate = connectionDate;
        this.connectionStatus = connectionStatus;
        this.customer = customer;
        this.address = address;
    }

    public long getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(long connectionId) {
        this.connectionId = connectionId;
    }

    public long getConsumerNumber() {
        return consumerNumber;
    }

    public void setConsumerNumber(long consumerNumber) {
        this.consumerNumber = consumerNumber;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public LocalDate getConnectionDate() {
        return connectionDate;
    }

    public void setConnectionDate(LocalDate connectionDate) {
        this.connectionDate = connectionDate;
    }

    public boolean isConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(boolean connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
