package com.plus_api.central_plus.Dto;

public class UpdateUserRequest {
    private String contact;
    private String password;

    // Getters and setters
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
