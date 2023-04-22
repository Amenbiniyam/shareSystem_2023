package com.act.sharemanagementApi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private long id;
    private String username;
    private String password;
    private String email;
    private String fullname;
    private String phone;
    private String role;

    @JsonManagedReference
    @OneToMany(mappedBy = "pk.user")

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getName() {
        return fullname;
    }

    public void setName(String name) {
        this.fullname = fullname;
    }




    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
