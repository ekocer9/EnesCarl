package com.example.superhelt_v4.repository;

import com.example.superhelt_v4.dto.CityHeroDTO;
import com.example.superhelt_v4.dto.HeroCountDTO;
import com.example.superhelt_v4.dto.HeroCountPowerDTO;
import com.example.superhelt_v4.dto.HeroPowerDTO;
import com.example.superhelt_v4.model.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository("superhero_DB")
public class SuperheroRepository_DB implements ISuperheroRepository {
    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String uid;

    @Value("${spring.datasource.password}")
    private String pwd;

    public List<HeroCountDTO> getSuperheroes() {
        List<HeroCountDTO> allSuperheroes = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(db_url, uid, pwd);
            PreparedStatement pstmt = con.prepareStatement("SELECT hero_ID, heroname, realname, creationyear " +
                    "FROM superhero");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int hero_id = rs.getInt("hero_ID");
                String heroName = rs.getString("heroname");
                String realName = rs.getString("realname");
                int creationYear = rs.getInt("creationyear");
                allSuperheroes.add(new HeroCountDTO(hero_id, heroName, realName, creationYear));
            }
            return allSuperheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<HeroCountPowerDTO> getSuperpowers() {
        List<HeroCountPowerDTO> allSuperpowers = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(db_url, uid, pwd);
            PreparedStatement pstmt = con.prepareStatement("SELECT heroname, realname, COUNT(sp.superpower) AS antal_superkræfter" +
                    "FROM superheroes s " +
                    "LEFT JOIN superpower sp ON s.heroname = sp.heroname" +
                    "GROUP BY s.heroname");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String heroName = rs.getString("heroname");
                String realName = rs.getString("realname");
                String antalSuperkræfter = rs.getString("antal_superkræfter");

                allSuperpowers.add(new HeroCountPowerDTO(heroName, realName, antalSuperkræfter));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allSuperpowers;
    }


    public List<HeroPowerDTO> getSuperheroesWithSuperpowers(String heroName) {
        List<HeroPowerDTO> superheroSuperpowers = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(db_url, uid, pwd);

            PreparedStatement pstmt = con.prepareStatement("SELECT s.heroname, s.realname, GROUP_CONCAT(sp.superpower SEPARATOR ', ') as superpowers " +
                    "FROM superheroes s " +
                    "LEFT JOIN superpower sp ON s.heroname = sp.heroname " +
                    "WHERE s.heroname = ? " +
                    "GROUP BY s.heroname");
            pstmt.setString(1, heroName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String heroname = rs.getString("heroname");
                String realname = rs.getString("realname");
                String[] currentSuperpowers = rs.getString("superpowers").split(", ");

                HeroPowerDTO superhero = new HeroPowerDTO();
                superhero.setHeroName(heroname);
                superhero.setRealName(realname);
                superhero.setSuperpower(Arrays.asList(currentSuperpowers));

                superheroSuperpowers.add(superhero);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return superheroSuperpowers;
    }

    public List<CityHeroDTO> getSuperheroCity(String heroName) {
        List<CityHeroDTO> superheroCityList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(db_url, uid, pwd);
             PreparedStatement pstmt = conn.prepareStatement("SELECT s.heroname, c.cityname " +
                     "FROM superheroes s " +
                     "LEFT JOIN city c ON s.heroname = c.heroname " +
                     "WHERE s.heroname = ? OR c.cityname IS NOT NULL")) {
            pstmt.setString(1, heroName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String currentHeroName = rs.getString("heroname");
                String currentCity = rs.getString("cityname");
                CityHeroDTO superheroCityDTO = new CityHeroDTO(currentHeroName, currentCity);
                superheroCityList.add(superheroCityDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return superheroCityList;
    }


    @Override
    public List<Superhero> getAll() {
        return null;
    }

    @Override
    public void addSuperhero(Superhero s) {

    }
}