package com.agnieszkadev.skatersapp.service;

import com.agnieszkadev.skatersapp.entity.Competition;

import java.util.List;

public interface CompetitionService {
     List<Competition> findAll();

     Competition findById(int id);

     void save(Competition competition);

     void deleteById(int id);

}
