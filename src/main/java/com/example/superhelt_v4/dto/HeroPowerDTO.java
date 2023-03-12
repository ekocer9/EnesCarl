package com.example.superhelt_v4.dto;

import com.example.superhelt_v4.model.Superhero;

import java.util.ArrayList;
import java.util.List;

public class HeroPowerDTO {
    private String heroName;
    private String realName;
    private String countPower;

    public HeroPowerDTO(String heroName, String realName, String countPower) {
        this.heroName = heroName;
        this.realName = realName;
        this.countPower = countPower;
    }

    List<Superhero> superheroList = new ArrayList<>();
}
