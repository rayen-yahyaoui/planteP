package com.rayen.plante.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rayen.plante.entities.plante;
import com.rayen.plante.service.PlanteService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PlanteRESTController {
	@Autowired
	PlanteService planteService ;
	@RequestMapping(method = RequestMethod.GET) 
	public List<plante> getAllProduits() {
		return planteService.getAllPlantes();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public plante getPlanteById(@PathVariable("id") Long id) {
	return planteService.getPlante(id);

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public plante createProduit(@RequestBody plante plante) {
	return planteService.savePlante(plante);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public plante updatePlante(@RequestBody plante pl) {
	return planteService.updatePlante(pl);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deletePlante(@PathVariable("id") Long id)
	{
	planteService.deletePlanteById(id);
	}
	
	@RequestMapping(value="/plnTyp/{id}",method = RequestMethod.GET)
	public List<plante> getProduitsByCatId(@PathVariable("id") Long id) {
	return planteService.findByTypeId(id);
	}

}
