package com.example.emlak.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emlak.dtos.MusteriSaveDto;
import com.example.emlak.entity.Musteri;
import com.example.emlak.repos.MusteriRepo;

@Service
public class MusteriManager {
private MusteriRepo musteriRepo;

@Autowired
public MusteriManager(MusteriRepo musteriRepo)
{
	this.musteriRepo=musteriRepo;
}
public void save(MusteriSaveDto saveDto)
{
	Musteri musteri = new Musteri();
	musteri.setName(saveDto.getName());
	musteri.setEmail(saveDto.getEmail());
	musteri.setPhone(saveDto.getPhone());
	musteriRepo.save(musteri);	
}
public List<Musteri> getAll()
{
	return musteriRepo.findAll();
}
}
