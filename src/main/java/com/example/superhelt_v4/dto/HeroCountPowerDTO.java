package com.example.superhelt_v4.dto;

public class HeroCountPowerDTO {
    private String heroName;
    private String realName;
    private String superpower;

    public HeroCountPowerDTO(String heroName, String realName, String superpower) {
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

    public String getSuperpower() {
        return superpower;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    @Override
    public String toString() {
        return "HeroCountPowerDTO{" +
                "heroName='" + heroName + '\'' +
                ", realName='" + realName + '\'' +
                ", superpower='" + superpower + '\'' +
                '}';
    }
}
