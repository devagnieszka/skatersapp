package com.agnieszkadev.skatersapp.dto;

import com.agnieszkadev.skatersapp.entity.Skater;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SummaryResultDTO {

    private Skater skater;
    private BigDecimal points;
    private int competitionCount;
    private boolean loser;
}
