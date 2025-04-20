package com.example.user.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "users")
public class User {


        @Id
        private String id;
        private String name;
        private int age;
        private LocalDateTime birthday;
        private String email;
        private String phone;
        private String address;
        private String gender;


    public User(String gender, String address, String phone, String email, LocalDateTime birthday, int age, String name, String id) {
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public User(String id) {
        this.id = id;
    }


    public User() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
