package com.agnieszkadev.skatersapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "skater_id")
    private Skater skater;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @Column(name="points")
    private BigDecimal points;



}
