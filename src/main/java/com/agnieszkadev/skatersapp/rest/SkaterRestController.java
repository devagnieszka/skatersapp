package com.agnieszkadev.skatersapp.rest;

import com.agnieszkadev.skatersapp.entity.Skater;
import com.agnieszkadev.skatersapp.service.SkaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skaters")
public class SkaterRestController {

    //te metody w rest gdyby nie bylo pom
    //rest działa z /api bo w pom dodana (bez rest i service)


   // private SkaterService skaterService;

   // @Autowired
   // public SkaterRestController(SkaterService theSkaterService) {
    //    skaterService = theSkaterService;
   // }

    /*// expose "/skaters" and return list of skaters
    @GetMapping("/skaters")
    public List<Skater> findAll() {
        return skaterService.findAll();
    }

    // add mapping for GET /skaters/{skaterId}

    @Override
    @GetMapping("/skaters/{skaterId}")
    public Skater getSkater(@PathVariable int skaterId) {

        Skater theSkater = skaterService.findById(skaterId);

        if (theSkater == null) {
            throw new RuntimeException("Skater id not found - " + skaterId);
        }

        return theSkater;
    }

    // add mapping for POST /skaters - add new skater

    @PostMapping("/skaters")
    public Skater addSkater(@RequestBody Skater theSkater) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theSkater.setId(0);

        skaterService.save(theSkater);

        return theSkater;
    }

    // add mapping for PUT /skaters - update existing skater

    @PutMapping("/skaters")
    public Skater updateSkater(@RequestBody Skater theSkater) {

        skaterService.save(theSkater);

        return theSkater;
    }

    // add mapping for DELETE /skaters/{skaterId} - delete skater

    @DeleteMapping("/skaters/{skaterId}")
    public String deleteSkater(@PathVariable int skaterId) {

        Skater tempSkater = skaterService.findById(skaterId);

        // throw exception if null

        if (tempSkater == null) {
            throw new RuntimeException("Skater id not found - " + skaterId);
        }

        skaterService.deleteById(skaterId);

        return "Deleted skater id - " + skaterId;
    }*/



}
