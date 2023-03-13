package com.example.superhelt_v4.dto;

public class CityHeroDTO {
    private String heroName;
    private String cityName;

    public CityHeroDTO(String heroName, String cityName) {
        this.heroName = heroName;
        this.cityName = cityName;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "CityHeroDTO{" +
                "heroName='" + heroName + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
