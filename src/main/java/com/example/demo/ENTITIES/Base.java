package com.example.demo.ENTITIES;

import java.sql.Timestamp;

class Base {
    long id;
    Timestamp created_at = new Timestamp(System.currentTimeMillis());
    Timestamp created_by = new Timestamp(System.currentTimeMillis());

    public Base(){
    }

    public Base(long id, Timestamp created_at, Timestamp created_by) {
        this.id = id;
        this.created_at = created_at;
        this.created_by = created_by;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Timestamp created_by) {
        this.created_by = created_by;
    }
}
