package com.example.superhelt_v4.repository;

import com.example.superhelt_v4.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("superhero_Stub")
public class SuperheroRepository_STUB implements ISuperheroRepository {
    private List<Superhero> superheroes = new ArrayList<Superhero>(List.of(
            new Superhero(1, "spider man", "peter parker", 1962),
            new Superhero(2, "batman", "bruce wayne", 1939),
            new Superhero(3, "iron man", "tony stark", 1963),
            new Superhero(4, "superman", "clark kent", 1938),
            new Superhero(5, "captain america", "steve rogers", 1941)

    ));
    public List<Superhero> getSuperheroes() {
        return superheroes;
    }

    @Override
    public List<Superhero> getAll() {
        return null;
    }

    @Override
    public void addSuperhero(Superhero s) {

    }
}
