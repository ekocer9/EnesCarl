package com.example.superhelt_v4.dto;

import com.example.superhelt_v4.model.Superhero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroCountPowerDTO {
    private String heroName;
    private String realName;
    private int numOfPowers;

    public HeroCountPowerDTO(String heroName, String realName, int numOfPowers) {
        this.heroName = heroName;
        this.realName = realName;
        this.numOfPowers = numOfPowers;
    }

    public List<Superhero> getSuperpowers() {
        List<Superhero> superheroList = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superhero", "root", "Onurfrugt123");
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

    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public int getNumOfPowers() {
        return numOfPowers;
    }
}
