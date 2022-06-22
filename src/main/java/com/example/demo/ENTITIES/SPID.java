package com.example.demo.ENTITIES;

import java.sql.Timestamp;
public class SPID extends Base {
        public long id;
        public USER user;
        public status status;
        public String description;

        public SPID(){
            super();
        }

    public SPID(long id, Timestamp created_at, Timestamp created_by, long spidId, USER user, String description) {
        super(id, created_at, created_by);
        this.id = spidId;
        this.user = user;
        this.description = description;
        this.status = com.example.demo.ENTITIES.status.PENDING;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public USER getUser() {
        return user;
    }
    public void setUser(USER user) {
        this.user = user;
    }
    public com.example.demo.ENTITIES.status getStatus() {
        return status;
    }
    public void setStatus(com.example.demo.ENTITIES.status status) {
        this.status = status;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SPID{" +
                "id=" + id +
                ", user=" + user +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}
