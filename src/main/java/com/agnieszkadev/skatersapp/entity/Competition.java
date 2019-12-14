package com.agnieszkadev.skatersapp.entity;


import com.agnieszkadev.skatersapp.enums.Series;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="competition")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "season")
    private Integer season;

    @Column(name = "series")
    @Enumerated(EnumType.STRING)
    private Series series;


}


