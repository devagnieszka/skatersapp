package com.agnieszkadev.skatersapp.service;

import com.agnieszkadev.skatersapp.dao.SkaterRepository;
import com.agnieszkadev.skatersapp.entity.Skater;
import com.agnieszkadev.skatersapp.enums.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SkaterServiceImpl implements SkaterService {


    private SkaterRepository skaterRepository;

    @Autowired
    public SkaterServiceImpl(SkaterRepository skaterRepository) {
        this.skaterRepository = skaterRepository;
    }

    @Override
    public List<Skater> findAll() {
        return skaterRepository.findAllByOrderBySexAscNameAsc();
    }

    @Override
    public List<Skater> findBySex(Sex sex) {
        return skaterRepository.findBySex(sex);
    }

    @Override
    public Skater findById(int id) {
        Optional<Skater> skater = skaterRepository.findById(id);

        if (skater.isPresent()) {
            return skater.get();
        } else
            return null;
    }

    @Override
    public void save(Skater skater) {
        List<String> names = skaterRepository.findAllNames();
        if(names.contains(skater.getName()) && skater.getId()==0) {
            throw new RuntimeException("SKATER EXISTS");
        }
        skaterRepository.save(skater);
    }

    @Override
    public void deleteById(int id) {
        skaterRepository.deleteById(id);
    }


}
