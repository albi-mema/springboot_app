package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Base{
    private String name;
    private String surname;
    private String CardNo;
    private String username;
    private String password;
    private String email;
}








