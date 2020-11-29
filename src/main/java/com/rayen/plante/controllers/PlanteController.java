package com.rayen.plante.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rayen.plante.entities.plante;
import com.rayen.plante.service.PlanteService;

@Controller
public class PlanteController {
	@Autowired
	PlanteService planteService;
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		modelMap.addAttribute("plante", new plante());
		modelMap.addAttribute("mode", "new");
		return "formPlante";
	}
	
	@RequestMapping("/savePlante")
	public String savePlante(@Valid plante plante,
			 BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) return "formPlante";
	 planteService.savePlante(plante);
	 return "formPlante";
	}
	
	
	@RequestMapping("/listePlantes")
	public String listePlantes(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<plante> pl = planteService.getAllPlantesParPage(page, size);
	modelMap.addAttribute("plantes", pl);
	 modelMap.addAttribute("pages", new int[pl.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listePlantes";
	}
	
	@RequestMapping("/supprimerPlante")
	public String supprimerPlante(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	planteService.deletePlanteById(id);
	Page<plante> pl = planteService.getAllPlantesParPage(page,size);
	modelMap.addAttribute("plantes", pl);
	modelMap.addAttribute("pages", new int[pl.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listePlantes";
	}


	
	@RequestMapping("/modifierPlante")
	public String editerPlante(@RequestParam("id") Long id,ModelMap modelMap)
	{
	plante p= planteService.getPlante(id);
	modelMap.addAttribute("plante", p);
	modelMap.addAttribute("mode", "edit");
	return "formPlante";
	}
	@RequestMapping("/updatePlante")
	public String updatePlante(@ModelAttribute("plante") plante plante,
	@RequestParam("date") String date,
	 ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateVente = dateformat.parse(String.valueOf(date));
	 plante.setDateVente(dateVente);

	 planteService.updatePlante(plante);
	 List<plante> pl = planteService.getAllPlantes();
	 modelMap.addAttribute("plantes", pl);
	return "listePlantes";
	}
	

	
}
