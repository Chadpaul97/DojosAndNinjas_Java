package com.codingdojo.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojoandninjas.models.Dojo;
import com.codingdojo.dojoandninjas.models.Ninja;
import com.codingdojo.dojoandninjas.repositories.DojoRepository;
import com.codingdojo.dojoandninjas.repositories.NinjaRepository;

@Service
public class MainService {
	
	private final NinjaRepository ninjaRepository;
	private final DojoRepository dojoRepository;
	public MainService(NinjaRepository ninjaRepository, DojoRepository dojoRepository) {
		this.ninjaRepository = ninjaRepository;
		this.dojoRepository = dojoRepository;
	}
	
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
		
	}
	
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
		
	}

	public Dojo createDojo(Dojo d) {
		return dojoRepository.save(d);

	}
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);

	}

	public Dojo findDojoById(Long id) {
		Optional<Dojo> optionaldojo = dojoRepository.findById(id);
		if(optionaldojo.isPresent()) {
			return optionaldojo.get();
		} else {
			return null;
		}
	}



}
