package com.example.superhelt_v4.repository;

import com.example.superhelt_v4.model.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("superhero_DB")
public class SuperheroRepository_DB implements ISuperheroRepository {
    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String uid;

    @Value("${spring.datasource.password}")
    private String pwd;

    public List<Superhero> getSuperheroes() {
        List<Superhero> superheroes = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(db_url, uid, pwd);
            PreparedStatement pstmt = con.prepareStatement("SELECT hero_ID, heroname, realname, creationyear FROM superhero");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int hero_id = rs.getInt("hero_ID");
                String heroName = rs.getString("heroname");
                String realName = rs.getString("realname");
                int creationYear = rs.getInt("creationyear");
                superheroes.add(new Superhero(hero_id, heroName, realName, creationYear));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Superhero> getSuperpowers() {
        List<Superhero> superheroList = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(db_url, uid, pwd);
            String sql = "SELECT heroname, realname, COUNT(sp.superpowername) AS antal_superkræfter" +
                    "FROM superheroes s " +
                    "LEFT JOIN superpower sp ON s.heroname = sp.heroname" +
                    "GROUP BY s.heroname";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String heroName = rs.getString("heroname");
                String realName = rs.getString("realname");
                String antalSuperkræfter = rs.getString("antal_superkræfter");

                superheroList.add(new Superhero(heroName, realName, antalSuperkræfter));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return superheroList;
    }

    @Override
    public List<Superhero> getAll() {
        return null;
    }

    @Override
    public void addSuperhero(Superhero s) {

    }
}