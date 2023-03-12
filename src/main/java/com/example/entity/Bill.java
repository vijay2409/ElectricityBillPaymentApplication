package com.example.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Bill {

    @Id
    private long billId;
    private LocalDate billDate;
    private LocalDate billDueDate;
    private int unitsConsumerId;
    private double billAmount;

    @OneToOne(mappedBy = "bill")
    private Reading reading;

    public Bill() {
    }

    public Bill(long billId, LocalDate billDate, LocalDate billDueDate, int unitsConsumerId, double billAmount) {
        this.billId = billId;
        this.billDate = billDate;
        this.billDueDate = billDueDate;
        this.unitsConsumerId = unitsConsumerId;
        this.billAmount = billAmount;
    }

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public LocalDate getBillDueDate() {
        return billDueDate;
    }

    public void setBillDueDate(LocalDate billDueDate) {
        this.billDueDate = billDueDate;
    }

    public int getUnitsConsumerId() {
        return unitsConsumerId;
    }

    public void setUnitsConsumerId(int unitsConsumerId) {
        this.unitsConsumerId = unitsConsumerId;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

}
