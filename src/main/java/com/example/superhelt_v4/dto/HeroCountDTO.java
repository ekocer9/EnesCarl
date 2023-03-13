package com.example.superhelt_v4.dto;

public class HeroCountDTO {
    private int hero_ID;
    private String heroname;
    private String realname;
    private int creationyear;

    public HeroCountDTO(int hero_ID, String heroname, String realname, int creationyear) {
        this.hero_ID = hero_ID;
        this.heroname = heroname;
        this.realname = realname;
        this.creationyear = creationyear;
    }

    public int getHero_ID() {
        return hero_ID;
    }

    public void setHero_ID(int hero_ID) {
        this.hero_ID = hero_ID;
    }

    public String getHeroname() {
        return heroname;
    }

    public void setHeroname(String heroname) {
        this.heroname = heroname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getCreationyear() {
        return creationyear;
    }

    public void setCreationyear(int creationyear) {
        this.creationyear = creationyear;
    }

    @Override
    public String toString() {
        return "HeroCountDTO{" +
                "hero_ID=" + hero_ID +
                ", heroname='" + heroname + '\'' +
                ", realname='" + realname + '\'' +
                ", creationyear=" + creationyear +
                '}';
    }
}

