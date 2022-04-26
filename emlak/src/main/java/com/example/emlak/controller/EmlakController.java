package com.example.emlak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.emlak.dtos.EmlakSaveDto;
import com.example.emlak.dtos.EmlakSearchDto;
import com.example.emlak.entity.Emlak;
import com.example.emlak.services.EmlakManager;

@RestController
@RequestMapping("/v1")
@CrossOrigin
public class EmlakController {
	
	private EmlakManager emlakManager;
	
	@Autowired
	public EmlakController(EmlakManager emlakManager) {
		this.emlakManager = emlakManager;
	}

	@GetMapping("/emlaklar")
	public List<Emlak> getAllEmlak() {
		return emlakManager.getAll();
	}
	
	@PostMapping("/emlak")
	public void saveEmlak(@RequestBody EmlakSaveDto emlak) {
		emlakManager.save(emlak);
	}
	
	@PostMapping("/search")
	public List<Emlak> searchEmlak(@RequestBody EmlakSearchDto emlak) {
		return emlakManager.search(emlak);
	}
	
	@GetMapping("/getByMusteri")
	public List<Emlak> getByName(@RequestParam String musteriName) {
		return emlakManager.searchByMusteriName(musteriName);
	}
	
	@GetMapping("/getByEmlakci/{id}")
	public List<Emlak> getByName(@PathVariable Long id) {
		return emlakManager.searchByEmlakciId(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmlak(@PathVariable Long id) {
		emlakManager.deleteById(id);
	}
	
	


}
