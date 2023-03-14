package com.example.superhelt_v4.controller;

import com.example.superhelt_v4.repository.ISuperheroRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/superheroes")
public class SuperheroController {
    ISuperheroRepository superheroRepository;

    public SuperheroController(ApplicationContext context, @Value("${superhero.repository.impl}") String impl) {
        superheroRepository = (ISuperheroRepository) context.getBean(impl);
    }



}
