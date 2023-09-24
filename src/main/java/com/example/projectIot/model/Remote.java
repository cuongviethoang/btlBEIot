package com.example.projectIot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "remote")
@Getter
@Setter
@NoArgsConstructor
public class Remote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bulb", nullable = false)
    private String bulb;

    @Column(name = "fan", nullable = false)
    private String fan;

    @Column(name = "time")
    private String time;
}
