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

import com.example.emlak.dtos.EmlakciSaveDto;
import com.example.emlak.entity.Emlakci;
import com.example.emlak.services.EmlakciManager;

@Controller
public class EmlakciController {
	private EmlakciManager emlakciManager;
	@Autowired
	public EmlakciController(EmlakciManager emlakciManager)
	{
		this.emlakciManager=emlakciManager;
	}
	@GetMapping("/emlakci")
	public String EmlakciEkle(Model model)
	{
		model.addAttribute("Emlakci", new Emlakci());
		return "emlakciEkle";		
	}
	@PostMapping("/emlakcistore")
	public void saveEmlakci(@RequestBody EmlakciSaveDto emlakci)
	{	
		emlakciManager.save(emlakci);
	}
	
	@PostMapping("/emlakcistoreform")
	public String EmlakciStore(@ModelAttribute EmlakciSaveDto emlakci, BindingResult result, Model model)
	{
		model.addAttribute("Emlakci",emlakci);
		saveEmlakci(emlakci);
		  return "index";
	}
	@GetMapping("/emlakcilistele")
	public String EmlakciListele(Model model)
	{
		List<Emlakci> emlakcilar = emlakciManager.getAll();
		model.addAttribute("emlakcilar",emlakcilar);
		return "emlakcıListele";
	}

}
