package com.example.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@MappedSuperclass
@Data
@NoArgsConstructor
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Timestamp createdAt;
    private String createdBy;
}
