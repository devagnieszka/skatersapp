package com.agnieszkadev.skatersapp.entity;

import com.agnieszkadev.skatersapp.enums.Sex;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="skater")
public class Skater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;

    @Column(name="sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;


}
