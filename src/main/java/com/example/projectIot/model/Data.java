package com.example.projectIot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "data")
@Getter
@Setter
@NoArgsConstructor
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "temp", nullable = false)
    private double temp;

    @Column(name = "humidity", nullable = false)
    private double humidity;

    @Column(name = "light", nullable = false)
    private double light;

//    @Column(name = "dust", nullable = false)
//    private double dust;

    @Column(name = "time")
    private String time;
}
