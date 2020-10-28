package com.rayen.plante;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rayen.plante.entities.plante;
import com.rayen.plante.service.PlanteService;

@SpringBootApplication
public class PlanteApplication implements CommandLineRunner {
@Autowired
PlanteService planteService;
public static void main(String[] args) {
SpringApplication.run(PlanteApplication.class, args);
}
@Override
public void run(String... args) throws Exception {
planteService.savePlante(new plante("Rose","rose", 112.0, new Date()));
planteService.savePlante(new plante("larum","vert", 32.5, new Date()));
planteService.savePlante(new plante("Narcis","blanche", 72.5, new Date()));
}}
