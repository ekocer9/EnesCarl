package com.example.superhelt_v4.service;

import com.example.superhelt_v4.model.Superhero;
import com.example.superhelt_v4.repository.SuperheroRepository_DB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperheroService {
    private SuperheroRepository_DB repository;

    public SuperheroService(SuperheroRepository_DB repository) {
        this.repository = repository;
    }

    public List<Superhero> getSuperhero() {
        return repository.getSuperheroes();
    }
}
