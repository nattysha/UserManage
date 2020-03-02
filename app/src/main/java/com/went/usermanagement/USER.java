package com.went.usermanagement;

public class USER {
    String full_name;
    String email;
    String username;
    String gender;
    String phone;
    String password;

    public USER() {
    }

    public USER(String full_name,String email,String username,String gender,String phone,String password) {
        this.full_name = full_name;
        this.email = email;
        this.username = username;
        this.gender = gender;
        this.phone = phone;
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
