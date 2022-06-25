package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "spids")
public class Spid extends Base{
    public Spid(User userId) {
        this.userId = userId;
    }

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id")
    private User userId;
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;
    @Enumerated(EnumType.STRING)
    private Type type = Type.LEVEL_1;


}
