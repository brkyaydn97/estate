package com.example.emlak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.example.emlak.dtos.EmlakSaveDto;
import com.example.emlak.dtos.EmlakSearchDto;
import com.example.emlak.entity.Emlak;
import com.example.emlak.entity.Emlakci;
import com.example.emlak.entity.Musteri;
import com.example.emlak.services.EmlakManager;
import com.example.emlak.services.EmlakciManager;
import com.example.emlak.services.MusteriManager;

@Controller
public class EmlakController {
	
	private EmlakManager emlakManager;
	private EmlakciManager emlakciManager;
	private MusteriManager musteriManager;
	@Autowired	
	public EmlakController(EmlakManager emlakManager,EmlakciManager emlakciManager,MusteriManager musteriManager) 
	{
		this.emlakManager = emlakManager;
		this.emlakciManager = emlakciManager;
		this.musteriManager = musteriManager;
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
	
	@GetMapping("/emlakarama")
	public String emlakAra(Model model)
	{
		model.addAttribute("Emlak", new Emlak());
		List<Emlakci> emlakcilar= EmlakciListesi();
		model.addAttribute("emlakcilar",emlakcilar);
		return "emlakAra";
		
	}
	@PostMapping("/emlakstore")
	public void saveEmlak(@RequestBody EmlakSaveDto emlak)
	{
		emlakManager.save(emlak);
	}
	@PostMapping("emlakselling")
	public void sellEmlak(@RequestBody EmlakSaveDto emlak)
	{
		emlakManager.sell(emlak);
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
	
	@PostMapping("/emlakSearchForm")
	public String searchEmlakForm(@ModelAttribute EmlakSearchDto emlak,BindingResult result,Model model)
	{
		model.addAttribute("Emlak",emlak);
		List<Emlak> emlaklar= searchEmlak(emlak);
		model.addAttribute("emlaklar",emlaklar);
		return "emlakListele";
		
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
	
	public List<Musteri> MusteriListesi()
	{
		List<Musteri> musteriler = musteriManager.getAll();
		return musteriler;
	}
	
	
	@GetMapping("/emlakSatis/{id}")
	public String emlakSatis(@PathVariable Long id,Model model)
	{
		Emlak emlak=emlakManager.findById(id);
		List<Musteri> musteriler= MusteriListesi();
		model.addAttribute("musteriler",musteriler);
		model.addAttribute("emlak",emlak);
		return "emlakSat";		
	}
	@PostMapping("/emlaksatform/{id}")
	public String EmlakSat(@ModelAttribute EmlakSaveDto emlak,@PathVariable Long id,BindingResult result,Model model)
	{
		Emlak emlakv= emlakManager.findById(id);
		model.addAttribute("Emlak",emlak);
		emlak.setId(id);
		emlak.setSize(emlakv.getSize());
		emlak.setRoomCount(emlakv.getRoomCount());
		emlak.setFloor(emlakv.getFloor());
		emlak.setEmlakci_id(emlakv.getEmlakci().getId());
		sellEmlak(emlak);
		return "index";
	}


}
