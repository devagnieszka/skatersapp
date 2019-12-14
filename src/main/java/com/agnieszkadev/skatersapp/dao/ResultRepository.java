package com.agnieszkadev.skatersapp.dao;

import com.agnieszkadev.skatersapp.entity.Result;
import com.agnieszkadev.skatersapp.enums.Series;
import com.agnieszkadev.skatersapp.enums.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Integer> {

    @Query("SELECT r FROM Result r WHERE r.competition.id =:competitionId AND r.skater.sex =:sex ORDER BY r.points DESC")
    List<Result> findByIdAndSex (@Param("competitionId") int competitionId, @Param("sex") Sex sex);

    @Query("SELECT r FROM Result r WHERE r.competition.season =:season AND r.competition.series =:series AND r.skater.sex =:sex")
    List<Result> findBySeasonAndSeriesAndSex (@Param("season") Integer season, @Param("series") Series series, @Param("sex") Sex sex);
}
