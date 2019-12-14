package com.agnieszkadev.skatersapp.service;

import com.agnieszkadev.skatersapp.entity.Skater;
import com.agnieszkadev.skatersapp.enums.Sex;

import java.util.List;

public interface SkaterService {
     List<Skater> findAll();

     List<Skater> findBySex(Sex sex);

     Skater findById(int id);

     void save(Skater skater);

     void deleteById(int id);


}
