package com.rayen.plante.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.rayen.plante.entities.plante;

public interface PlanteService {
	plante savePlante(plante p);
	plante updatePlante(plante p);
	void deletePlante(plante p);
	void deletePlanteById(Long id);
	plante getPlante(Long id);
	List<plante> getAllPlantes();
	Page<plante>getAllPlantesParPage(int page, int size);
 

}
