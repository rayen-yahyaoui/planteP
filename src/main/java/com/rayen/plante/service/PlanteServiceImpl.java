package com.rayen.plante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.rayen.plante.entities.Type;
import com.rayen.plante.entities.plante;
import com.rayen.plante.repos.PlanteRepository;

@Service
public class PlanteServiceImpl  implements PlanteService{

	@Autowired
	PlanteRepository planteRepository;
	@Override
	public plante savePlante(plante p) {
	return planteRepository.save(p);
	}
	@Override
	public plante updatePlante(plante p) {
	return planteRepository.save(p);
	}
	@Override
	public void deletePlante(plante p) {
	planteRepository.delete(p);
	}
	 @Override
	public void deletePlanteById(Long id) {
	planteRepository.deleteById(id);
	}
	@Override
	public plante getPlante(Long id) {
	return planteRepository.findById(id).get();
	}
	@Override
	public List<plante> getAllPlantes() {
	return planteRepository.findAll();
	}
	@Override
	public Page<plante> getAllPlantesParPage(int page, int size) {
	return planteRepository.findAll(PageRequest.of(page, size));
	}
	
	@Override
	public List<plante> findByNomPlante(String nom) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<plante> findByNomPlanteContains(String nom) {
		return planteRepository.findByNomPlante(nom);
	}
	
	@Override
	public List<plante> findByNomPrix(String nom, Double prix) {
		return planteRepository.findByNomPlanteContains(nom);
	}
	
	@Override
	public List<plante> findByType(Type type) {
		return planteRepository.findByType(type) ;
	}
	
	@Override
	public List<plante> findByTypeId(Long id) {
		return planteRepository.findByTypeId(id) ;
	}
	
	@Override
	public List<plante> findByOrderByNomPlanteAsc() {
		return planteRepository.findByOrderByNomPlanteAsc() ;
	}
	
	@Override
	public List<plante> trierPlantesNomsPrix() {
		return planteRepository.trierPlantesNomsPrix();
	}

	}