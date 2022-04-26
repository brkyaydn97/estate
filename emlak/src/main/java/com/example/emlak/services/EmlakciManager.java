package com.example.emlak.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emlak.dtos.EmlakciSaveDto;
import com.example.emlak.entity.Emlak;
import com.example.emlak.entity.Emlakci;
import com.example.emlak.repos.EmlakciRepo;

@Service
public class EmlakciManager {
private EmlakciRepo emlakciRepo;

@Autowired
public EmlakciManager(EmlakciRepo emlakciRepo)
{
	this.emlakciRepo=emlakciRepo;
}

public void save(EmlakciSaveDto saveDto)
{
	Emlakci emlakci = new Emlakci();
	emlakci.setAddress(saveDto.getAddress());
	emlakci.setEmail(saveDto.getEmail());
	emlakci.setFax(saveDto.getFax());
	emlakci.setName(saveDto.getName());
	emlakci.setPhone(saveDto.getPhone());
	emlakciRepo.save(emlakci);
}
public List<Emlakci> getAll() {
	return emlakciRepo.findAll();
}
}
