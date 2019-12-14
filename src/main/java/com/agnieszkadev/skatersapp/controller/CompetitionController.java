package com.agnieszkadev.skatersapp.controller;

import com.agnieszkadev.skatersapp.service.CompetitionService;
import com.agnieszkadev.skatersapp.entity.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/competitions")
public class CompetitionController {
    
    @Autowired
    private CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }


    // add mapping for "/list"
    @GetMapping("/list")
    public String listCompetitions(Model model) {
        List<Competition> competitions = competitionService.findAll();
        model.addAttribute("competitions", competitions);
        return "competitions-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Competition competition = new Competition();
        model.addAttribute("competition", competition);
        return "competition-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("competitionId") int competitionId, Model model) {
        Competition competition = competitionService.findById(competitionId);
        model.addAttribute("competition", competition);

        return "competition-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("competition") Competition competition) {
        competitionService.save(competition);
        return "redirect:/competitions/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("competitionId") int competitionId) {
        competitionService.deleteById(competitionId);
        return "redirect:/competitions/list";
    }
}
