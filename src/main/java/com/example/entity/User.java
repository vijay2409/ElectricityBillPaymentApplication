package com.example.entity;


import javax.persistence.*;

@Entity
@Table(name = "userTable")
public class User {

    @Id
    private long userId;

    @Column(unique = true)
    private String userName;
    private String Password;

    @OneToOne(mappedBy = "user")
    private Customer customer;


    public User() {
    }

    public User(long userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.Password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

}
