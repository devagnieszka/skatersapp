package com.agnieszkadev.skatersapp.service;

import com.agnieszkadev.skatersapp.dao.ResultRepository;
import com.agnieszkadev.skatersapp.entity.Result;
import com.agnieszkadev.skatersapp.entity.Skater;
import com.agnieszkadev.skatersapp.dto.SummaryResultDTO;
import com.agnieszkadev.skatersapp.enums.Series;
import com.agnieszkadev.skatersapp.enums.Sex;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ResultServiceImpl implements ResultService {

    private ResultRepository resultRepository;

    public ResultServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public List<Result> findAll() {
        return resultRepository.findAll();
    }

    @Override
    public Result findById(int id) {
        Optional<Result> result = resultRepository.findById(id);

        if (result.isPresent()) {
            return result.get();
        } else
            return null;
    }

    @Override
    public void save(Result result) {
        resultRepository.save(result);
    }

    @Override
    public void deleteById(int id) {
        resultRepository.deleteById(id);
    }

    @Override
    public List<Result> findByCompetitionIdAndSex(int id, Sex sex) {
        return resultRepository.findByIdAndSex(id, sex);
    }

    @Override
    public List<SummaryResultDTO> getSeriesResults(Integer season, Series series, Sex sex) {
        List<Result> seriesResults = resultRepository.findBySeasonAndSeriesAndSex(season, series, sex);
        List<SummaryResultDTO> seriesResultsBySkaters = new ArrayList<>();
        List<Skater> skaters = seriesResults.stream().map(Result::getSkater).distinct().collect(Collectors.toList());
        for (Skater skater : skaters) {
            List<Result> skaterResults = seriesResults.stream().filter(result -> result.getSkater().equals(skater)).collect(Collectors.toList());
            SummaryResultDTO summaryResultDTO = new SummaryResultDTO();
            summaryResultDTO.setSkater(skater);
            summaryResultDTO.setCompetitionCount(skaterResults.size());
            if (series.equals(Series.CS)) {
                while (skaterResults.size() > 2) {
                    Result result = skaterResults.stream().min(Comparator.comparing(Result::getPoints)).get();
                    skaterResults.remove(result);
                }
            }
            BigDecimal sumPoints = skaterResults.stream().map(Result::getPoints).reduce(BigDecimal.ZERO, BigDecimal::add);
            summaryResultDTO.setPoints(sumPoints);
            seriesResultsBySkaters.add(summaryResultDTO);

        }
        seriesResultsBySkaters = seriesResultsBySkaters.stream().sorted(Comparator.comparing(SummaryResultDTO::getPoints).reversed()).collect(Collectors.toList());

        if (series.equals(Series.GP) && seriesResultsBySkaters.size() >= 6) {
            BigDecimal minResult = seriesResultsBySkaters.get(5).getPoints();
            for (SummaryResultDTO summaryResultBySkater : seriesResultsBySkaters) {
                if((summaryResultBySkater.getCompetitionCount()==1 && summaryResultBySkater.getPoints().add(BigDecimal.valueOf(15L)).compareTo(minResult) == -1)
                    || (summaryResultBySkater.getCompetitionCount()==2 && summaryResultBySkater.getPoints().compareTo(minResult) == -1))
                    summaryResultBySkater.setLoser(true);
                }

        }


        return seriesResultsBySkaters.stream().sorted(Comparator.comparing(SummaryResultDTO::getPoints).reversed()).collect(Collectors.toList());
    }


}
