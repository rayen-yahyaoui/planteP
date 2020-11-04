package com.rayen.plante.service;

import java.util.List;


import org.springframework.data.domain.Page;

import com.rayen.plante.entities.plante;
import com.rayen.plante.entities.Type;

public interface PlanteService {
	plante savePlante(plante p);
	plante updatePlante(plante p);
	void deletePlante(plante p);
	void deletePlanteById(Long id);
	plante getPlante(Long id);
	List<plante> getAllPlantes();
	Page<plante>getAllPlantesParPage(int page, int size);
	
	List<plante> findByNomPlante(String nom);
	
	List<plante> findByNomPlanteContains(String nom);
	
	List<plante> findByNomPrix (String nom, Double prix);
	
	List<plante> findByType (Type type);
	
	List<plante> findByTypeId(Long id);
	
	List<plante> findByOrderByNomPlanteAsc();
	
	List<plante> trierPlantesNomsPrix();
 

}
