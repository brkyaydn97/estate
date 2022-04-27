package com.example.emlak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.emlak.dtos.MusteriSaveDto;
import com.example.emlak.entity.Musteri;
import com.example.emlak.services.MusteriManager;

@Controller
public class MusteriController {

	private MusteriManager musteriManager;
	
	@Autowired
	public MusteriController(MusteriManager musteriManager)
	{
		this.musteriManager=musteriManager;
	}
	
	@GetMapping("/musteri")
	public String MusteriEkle(Model model)
	{
		model.addAttribute("Musteri", new Musteri());
		return "musteriEkle";
	}
	
	@PostMapping("/musteristore")
	public void saveMusteri(@RequestBody MusteriSaveDto musteri)
	{
		musteriManager.save(musteri);
	}
	
	@PostMapping("musteristoreform")
	public String MusteriStore(@ModelAttribute MusteriSaveDto musteri, BindingResult result, Model model)
	{
		model.addAttribute("Musteri",musteri);
		saveMusteri(musteri);
		return "index";		
	}
	
	@GetMapping("/musterilistele")
	public String MusteriLislete(Model model)
	{
		List<Musteri> musteriler = musteriManager.getAll();
		model.addAttribute("musteriler",musteriler);
		return "musteriListele";
	}
	
}
