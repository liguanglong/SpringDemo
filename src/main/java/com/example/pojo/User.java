package com.example.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class User {
    @JsonSerialize(include= JsonSerialize.Inclusion.NON_EMPTY)
    private int id;
    @JsonSerialize(include= JsonSerialize.Inclusion.NON_EMPTY)
    private String name;
    @JsonSerialize(include= JsonSerialize.Inclusion.NON_EMPTY)
    private String password;
    @JsonSerialize(include= JsonSerialize.Inclusion.NON_EMPTY)
    private String email;
    @JsonSerialize(include= JsonSerialize.Inclusion.NON_EMPTY)
    private Date lastLogin;

//    public User() {
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                '}';
    }
}
