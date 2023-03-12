package com.example.superhelt_v4.dto;

import com.example.superhelt_v4.model.Superhero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroCountDTO {
    private int hero_ID;
    private String heroname;
    private String realname;
    private int creationyear;

    public List<Superhero> getSuperheroes() {
        List<Superhero> superheroList = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superhero", "root", "Onurfrugt123");
            String sql = "SELECT hero_ID, heroname, realname, creationyear FROM superhero";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int hero_id = rs.getInt("hero_ID");
                String heroName = rs.getString("heroname");
                String realName = rs.getString("realname");
                int creationYear = rs.getInt("creationyear");
                superheroList.add(new Superhero(hero_id, heroName, realName, creationYear));
            }

        } catch (SQLException e) {
            System.out.println("Cannot connect to database");
            e.printStackTrace();
        }
        return superheroList;
    }
}

