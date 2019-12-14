package com.agnieszkadev.skatersapp.controller;

import com.agnieszkadev.skatersapp.entity.Competition;
import com.agnieszkadev.skatersapp.entity.Result;
import com.agnieszkadev.skatersapp.entity.Skater;
import com.agnieszkadev.skatersapp.dto.SummaryResultDTO;
import com.agnieszkadev.skatersapp.enums.Series;
import com.agnieszkadev.skatersapp.enums.Sex;
import com.agnieszkadev.skatersapp.service.CompetitionService;
import com.agnieszkadev.skatersapp.service.ResultService;
import com.agnieszkadev.skatersapp.service.SkaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private SkaterService skaterService;

    public ResultController(ResultService resultService, CompetitionService competitionService, SkaterService skaterService) {
        this.resultService = resultService;
        this.competitionService = competitionService;
        this.skaterService = skaterService;
    }

    @GetMapping("/updateResults")
    public String updateResults(@RequestParam("competitionId") int competitionId, @RequestParam("sex") Sex sex, Model model) {
        Competition competition = competitionService.findById(competitionId);
        Result newResult = new Result();
        Skater skater = new Skater();
        newResult.setCompetition(competition);
        newResult.setSkater(skater);
        model.addAttribute("newResult", newResult);

        List<Result> results= resultService.findByCompetitionIdAndSex(competitionId, sex);
        model.addAttribute("results", results);

        List<Skater> skaters = skaterService.findBySex(sex);
        model.addAttribute("skaters", skaters);
        return "results-for-competition";
    }

    @PostMapping("/save")
    public RedirectView save(@ModelAttribute("newResult") Result result, Model model) {
        Skater skater = skaterService.findById(result.getSkater().getId());
        Competition competition = competitionService.findById(result.getCompetition().getId());
        result.setSkater(skater);
        result.setCompetition(competition);
        resultService.save(result);
        RedirectView rv = new RedirectView();
        String sex = result.getSkater().getSex().name();
        String competitionId = Integer.toString(result.getCompetition().getId());
        rv.setUrl("/results/updateResults");
        rv.addStaticAttribute("competitionId", competitionId);
        rv.addStaticAttribute("sex",sex);
        return rv;
    }

    @GetMapping("/delete")
    public RedirectView delete(@RequestParam("resultId") int resultId) {
        Result result = resultService.findById(resultId);
        RedirectView rv = new RedirectView();
        String sex = result.getSkater().getSex().name();
        String competitionId = Integer.toString(result.getCompetition().getId());
        rv.setUrl("/results/updateResults");
        rv.addStaticAttribute("competitionId", competitionId);
        rv.addStaticAttribute("sex",sex);
        resultService.deleteById(resultId);
        return rv;
    }

    @GetMapping("/seriesResults")
    public String getSeriesResults(@RequestParam("season") Integer season, @RequestParam("series") Series series, @RequestParam("sex") Sex sex, Model model) {
        List<SummaryResultDTO> seriesResults = resultService.getSeriesResults(season, series, sex);
        model.addAttribute("results", seriesResults);
        return "series-results";
    }


}
