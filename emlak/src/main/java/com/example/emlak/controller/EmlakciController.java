package com.example.emlak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emlak.entity.Emlakci;

@Controller
public class EmlakciController {
	
	@GetMapping("/emlakci")
	public String EmlakciEkle(Model model)
	{
		model.addAttribute("Emlakci", new Emlakci());
		return "emlakciekle";
		
	}
	@PostMapping("emlakcistore")
	public String EmlakciKaydet()
	{
		return null;
	}

}
