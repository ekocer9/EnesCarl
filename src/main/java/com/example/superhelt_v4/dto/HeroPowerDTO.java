package com.example.superhelt_v4.dto;

import java.util.List;

public class HeroPowerDTO {
    private String heroName;
    private String realName;
    private List superpower;

    public HeroPowerDTO() {

    }

    public HeroPowerDTO(String heroName, String realName, List superpower) {
        this.heroName = heroName;
        this.realName = realName;
        this.superpower = superpower;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public List getSuperpower() {
        return superpower;
    }

    public void setSuperpower(List superpower) {
        this.superpower = superpower;
    }

    @Override
    public String toString() {
        return "HeroPowerDTO{" +
                "heroName='" + heroName + '\'' +
                ", realName='" + realName + '\'' +
                ", superpower=" + superpower +
                '}';
    }
}
