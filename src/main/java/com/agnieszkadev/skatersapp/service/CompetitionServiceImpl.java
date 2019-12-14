package com.agnieszkadev.skatersapp.service;

import com.agnieszkadev.skatersapp.dao.CompetitionRepository;
import com.agnieszkadev.skatersapp.entity.Competition;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitionServiceImpl implements CompetitionService {


    private CompetitionRepository competitionRepository;

    public CompetitionServiceImpl(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public List<Competition> findAll() {
        return competitionRepository.findAll();
    }


    @Override
    public Competition findById(int id) {
        Optional<Competition> competition = competitionRepository.findById(id);

        if (competition.isPresent()) {
            return competition.get();
        } else
            return null;
    }

    @Override
    public void save(Competition competition) {
        competitionRepository.save(competition);
    }

    @Override
    public void deleteById(int id) {
        competitionRepository.deleteById(id);
    }
}