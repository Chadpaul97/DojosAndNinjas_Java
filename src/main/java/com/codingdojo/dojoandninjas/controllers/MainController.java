package com.codingdojo.dojoandninjas.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojoandninjas.models.Dojo;
import com.codingdojo.dojoandninjas.models.Ninja;
import com.codingdojo.dojoandninjas.services.MainService;

@Controller
public class MainController {

	@Autowired
	MainService mainService;
	
	@RequestMapping("/dojos/new")
		public String dojoForm(Model model,@ModelAttribute("dojos") Dojo dojo) {
			return "newDojo.jsp";
	}
	
	@PostMapping("/newdojo")
	public String newDojo(@Valid @ModelAttribute("dojos") Dojo dojo, BindingResult result) {
	if(result.hasErrors()) {
		return "newDojo.jsp";
	} else {
		mainService.createDojo(dojo);
		return "redirect:/ninjas/new";
	}
	}
	
	@RequestMapping("/ninjas/new")
	public String ninjaForm(Model model,@ModelAttribute("ninjas") Ninja ninja) {
		model.addAttribute("dojos", mainService.allDojos());
		return "newNinja.jsp";
	}
	
	
	@PostMapping("/newninja")
	public String createNinja(Model model, @Valid @ModelAttribute("ninjas") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", mainService.allDojos());
			return "newNinja.jsp";
		} else {
			mainService.createNinja(ninja);
			Dojo dojo = ninja.getDojo();
			Long id = dojo.getId();
			return "redirect:/dojos/" + id;
		}
	}


	
	@RequestMapping("/dojos/{id}")
	public String DojoNinjas(Model model, @PathVariable Long id) {
		Dojo dojos = mainService.findDojoById(id);
		model.addAttribute("dojo",dojos);
		return "dojoninjas.jsp";
	}
	
}
