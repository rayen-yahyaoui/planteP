package com.rayen.plante.repos;

import com.rayen.plante.entities.Type;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rayen.plante.entities.plante;

@RepositoryRestResource(path = "rest")
public interface PlanteRepository extends JpaRepository<plante, Long> {
	
	 List<plante> findByNomPlante(String nom);
	 List<plante> findByNomPlanteContains(String nom);
	 
	 @Query("select p from plante p where p.nomPlante like %?1 and p.prix > ?2")
	 List<plante> findByNomPrix (String nom, Double prix);
	 
	 @Query("select p from plante p where p.type = ?1")
	 List<plante> findByType (Type type);
	 
	 List<plante> findByTypeId(Long id);
	 
	
	 List<plante> findByOrderByNomPlanteAsc();
	 
	 @Query("select p from plante p order by p.nomPlante ASC, p.prix DESC")
	 List<plante> trierPlantesNomsPrix ();
	 
}
