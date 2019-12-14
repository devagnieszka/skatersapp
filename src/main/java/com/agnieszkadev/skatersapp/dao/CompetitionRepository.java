package com.agnieszkadev.skatersapp.dao;

import com.agnieszkadev.skatersapp.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompetitionRepository extends JpaRepository<Competition, Integer> {

}
