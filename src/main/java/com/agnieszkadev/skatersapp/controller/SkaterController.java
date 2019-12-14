package com.agnieszkadev.skatersapp.controller;

import com.agnieszkadev.skatersapp.entity.Skater;
import com.agnieszkadev.skatersapp.service.CompetitionService;
import com.agnieszkadev.skatersapp.service.SkaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/skaters")
public class SkaterController {
    private SkaterService skaterService;

    @Autowired
    public SkaterController(SkaterService skaterService) {
        this.skaterService = skaterService;
    }


    // add mapping for "/list"
    @GetMapping("/list")
    public String listSkaters(Model model) {
        List<Skater> skaters = skaterService.findAll();
        model.addAttribute("skaters", skaters);

        return "skaters-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Skater skater = new Skater();
        model.addAttribute("skater", skater);

        return "skater-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("skaterId") int skaterId,  Model model) {
        Skater skater = skaterService.findById(skaterId);
        model.addAttribute("skater", skater);
        return "skater-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("skater") Skater skater) {
        skaterService.save(skater);
        return "redirect:/skaters/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("skaterId") int skaterId) {
        skaterService.deleteById(skaterId);
        return "redirect:/skaters/list";
    }
}
