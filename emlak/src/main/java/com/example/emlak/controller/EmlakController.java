package com.example.emlak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.emlak.dtos.EmlakSaveDto;
import com.example.emlak.dtos.EmlakSearchDto;
import com.example.emlak.entity.Emlak;
import com.example.emlak.entity.Emlakci;
import com.example.emlak.services.EmlakManager;
import com.example.emlak.services.EmlakciManager;

@Controller
public class EmlakController {
	
	private EmlakManager emlakManager;
	private EmlakciManager emlakciManager;
	@Autowired	
	public EmlakController(EmlakManager emlakManager,EmlakciManager emlakciManager) 
	{
		this.emlakManager = emlakManager;
		this.emlakciManager = emlakciManager;
	}
	
	
	
	@GetMapping("/emlaklistele")
	public String EmlakListele(Model model) 
	{
		List<Emlak> emlaklar = emlakManager.getAll();
		model.addAttribute("emlaklar",emlaklar);
		return "emlakListele";
	}
	
	@GetMapping("/emlak")
	public String EmlakEkle(Model model)
	{	
		model.addAttribute("Emlak", new Emlak());
		List<Emlakci> emlakcilar= EmlakciListesi();
		model.addAttribute("emlakcilar",emlakcilar);
		return "emlakEkle";
	}
	
	@PostMapping("/emlakstore")
	public void saveEmlak(@RequestBody EmlakSaveDto emlak)
	{
		emlakManager.save(emlak);
	}
	
	@PostMapping("emlakstoreform")
	public String EmlakStore(@ModelAttribute EmlakSaveDto emlak,BindingResult result,Model model)
	{
		model.addAttribute("Emlak",emlak);
		saveEmlak(emlak);
		return "index";
	}
	
	@PostMapping("/search")
	public List<Emlak> searchEmlak(@RequestBody EmlakSearchDto emlak) 
	{
		return emlakManager.search(emlak);
	}
	
	@GetMapping("/getByMusteri")
	public List<Emlak> getByName(@RequestParam String musteriName) 
	{
		return emlakManager.searchByMusteriName(musteriName);
	}
	
	@GetMapping("/getByEmlakci/{id}")
	public List<Emlak> getByName(@PathVariable Long id) 
	{
		return emlakManager.searchByEmlakciId(id);
	}
	
	@DeleteMapping("/emlakdelete/{id}")
	public void deleteEmlak(@PathVariable Long id) {
		emlakManager.deleteById(id);
	}
	
	public List<Emlakci> EmlakciListesi()
	{
		List<Emlakci> emlakcilar = emlakciManager.getAll();
		return emlakcilar;
	}


}
