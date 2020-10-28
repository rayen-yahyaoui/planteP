package com.rayen.plante.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rayen.plante.entities.plante;

public interface PlanteRepository extends JpaRepository<plante, Long> {
	
}
