package com.example.projectIot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "remote")
@Getter
@Setter
@NoArgsConstructor
public class Remote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "device", nullable = false)
    private String device;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "time")
    private String time;
}
