package com.example.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reading {

    @Id
    public long readingId;
    public int unitsConsumed;
    public String readingPhoto;
    public LocalDate readingDate;
    public int pricePerUnits;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billId")
    private Bill bill;

    @OneToOne
    private Connection connection;

    public Reading() {
    }

    public Reading(long readingId, int unitsConsumed, String readingPhoto, LocalDate readingDate, int pricePerUnits, Bill bill, Connection connection) {
        this.readingId = readingId;
        this.unitsConsumed = unitsConsumed;
        this.readingPhoto = readingPhoto;
        this.readingDate = readingDate;
        this.pricePerUnits = pricePerUnits;
        this.bill = bill;
        this.connection = connection;
    }

    public long getReadingId() {
        return readingId;
    }

    public void setReadingId(long readingId) {
        this.readingId = readingId;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(int unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }

    public String getReadingPhoto() {
        return readingPhoto;
    }

    public void setReadingPhoto(String readingPhoto) {
        this.readingPhoto = readingPhoto;
    }

    public LocalDate getReadingDate() {
        return readingDate;
    }

    public void setReadingDate(LocalDate readingDate) {
        this.readingDate = readingDate;
    }

    public int getPricePerUnits() {
        return pricePerUnits;
    }

    public void setPricePerUnits(int pricePerUnits) {
        this.pricePerUnits = pricePerUnits;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
