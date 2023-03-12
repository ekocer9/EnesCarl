package com.example.superhelt_v4.model;

public class Superhero {
    private int hero_ID;
    private String heroName;
    private String realName;
    private int creationYear;
    private String cityName;
    private String superpowerName;
    private String superpower;
    private String superhero;
    private String city;

    public Superhero() {
    }

    public Superhero(int hero_ID, String heroName, String realName, int creationYear, String cityName, String superpowerName, String superpower, String superhero, String city) {
        this.hero_ID = hero_ID;
        this.heroName = heroName;
        this.realName = realName;
        this.creationYear = creationYear;
        this.cityName = cityName;
        this.superpowerName = superpowerName;
        this.superpower = superpower;
        this.superhero = superhero;
        this.city = city;
    }

    public Superhero(int hero_ID, String heroName, String realName, int creationYear) {
        this.hero_ID = hero_ID;
        this.heroName = heroName;
        this.realName = realName;
        this.creationYear = creationYear;
    }

    public Superhero(String heroName, String realName, String superpowerName) {
        this.heroName = heroName;
        this.realName = realName;
        this.superpowerName = superpowerName;

    }



    public int getHero_ID() {
        return hero_ID;
    }

    public void setHero_ID(int hero_ID) {
        this.hero_ID = hero_ID;
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

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getSuperpowerName() {
        return superpowerName;
    }

    public void setSuperpowerName(String superpowerName) {
        this.superpowerName = superpowerName;
    }

    public String getSuperpower() {
        return superpower;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "hero_ID=" + hero_ID +
                ", heroName='" + heroName + '\'' +
                ", realName='" + realName + '\'' +
                ", creationYear=" + creationYear +
                ", cityName='" + cityName + '\'' +
                ", superpowerName='" + superpowerName + '\'' +
                ", superpower='" + superpower + '\'' +
                ", superhero='" + superhero + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}
