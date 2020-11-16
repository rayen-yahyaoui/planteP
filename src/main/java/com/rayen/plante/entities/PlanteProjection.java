package com.rayen.plante.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomPlan", types = { plante.class })
public interface PlanteProjection {
	
		public String getNomPlante();

}
