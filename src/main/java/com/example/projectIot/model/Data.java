package com.example.projectIot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private float temp;

    @Column(name = "humidity", nullable = false)
    private float humidity;

    @Column(name = "light", nullable = false)
    private float light;

    @Column(name = "time")
    private LocalDateTime time;
}
