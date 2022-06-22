package com.example.demo.ENTITIES;


import java.sql.Timestamp;


public class USER extends Base {
    String name;
    String surname;
    String username;

    public USER(){
        super();
    }
    public USER(long id, Timestamp created_at, Timestamp created_by, String name, String surname, String username) {
        super(id, created_at, created_by);
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "USER{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", id=" + id +
                ", created_at=" + created_at +
                ", created_by=" + created_by +
                '}';
    }
}
