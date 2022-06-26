package com.example.demo.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    private String createdBy = "Admin";
}
