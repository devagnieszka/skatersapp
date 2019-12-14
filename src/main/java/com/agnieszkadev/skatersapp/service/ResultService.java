package com.agnieszkadev.skatersapp.service;

import com.agnieszkadev.skatersapp.entity.Result;
import com.agnieszkadev.skatersapp.dto.SummaryResultDTO;
import com.agnieszkadev.skatersapp.enums.Series;
import com.agnieszkadev.skatersapp.enums.Sex;

import java.util.List;

public interface ResultService {
    List<Result> findAll();

    Result findById(int id);

    void save(Result result);

    void deleteById(int id);

    List<Result> findByCompetitionIdAndSex(int id, Sex sex);

    List<SummaryResultDTO> getSeriesResults(Integer season, Series series, Sex sex);
}
