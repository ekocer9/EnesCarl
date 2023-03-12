package com.example.superhelt_v4.repository;

import com.example.superhelt_v4.model.Superhero;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface ISuperheroRepository {
    List<Superhero> getAll();
    void addSuperhero(Superhero s);
}