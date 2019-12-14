package com.agnieszkadev.skatersapp.dao;

import com.agnieszkadev.skatersapp.entity.Skater;
import com.agnieszkadev.skatersapp.enums.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SkaterRepository extends JpaRepository<Skater, Integer> {

    List<Skater> findAllByOrderBySexAscNameAsc();

    @Query("SELECT s FROM Skater s WHERE s.sex =:sex ORDER BY s.name")
    List<Skater> findBySex (@Param("sex") Sex sex);

    @Query("SELECT s.name FROM Skater s")
    List<String> findAllNames ();
}

