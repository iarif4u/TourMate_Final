package com.example.mdarifur.tourmate.Model;

/**
 * Created by hp on 8/11/2016.
 */
public class Contact {
    private int id;
    private String name;
    private String password;
    private String photo;
    private String phoneNub;
    private String emailId;


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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoneNub() {
        return phoneNub;
    }

    public void setPhoneNub(String phoneNub) {
        this.phoneNub = phoneNub;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }


    public Contact(int id, String name, String password, String photo, String phoneNub, String emailId) {
        this.id=id;
        this.name = name;
        this.password = password;
        this.photo = photo;
        this.phoneNub = phoneNub;
        this.emailId = emailId;
    }

    public Contact(int id, String phoneNub, String photo, String password, String name) {
        this.id=id;
        this.phoneNub = phoneNub;
        this.photo = photo;
        this.password = password;
        this.name = name;
    }

    public Contact() {

    }

}
