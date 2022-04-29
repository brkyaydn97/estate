package com.example.emlak.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emlak.dtos.EmlakSaveDto;
import com.example.emlak.dtos.EmlakSearchDto;
import com.example.emlak.entity.Emlak;
import com.example.emlak.entity.Emlakci;
import com.example.emlak.entity.Musteri;
import com.example.emlak.repos.EmlakRepo;

@Service
public class EmlakManager {
	
	private EmlakRepo emlakRepo;
	
	@Autowired
	public EmlakManager(EmlakRepo emlakRepo) {
		this.emlakRepo = emlakRepo;
	}
	
	public List<Emlak> getAll() {
		return emlakRepo.findAll();
	}
	
	public Emlak findById(Long id) {
		return emlakRepo.getById(id); 
	}
	
	public void save(EmlakSaveDto saveDto) {
		Emlak emlak = new Emlak();
		Emlakci emlakci = new Emlakci();
		emlak.setSize(saveDto.getSize());
		emlak.setFloor(saveDto.getFloor());
		emlak.setRoomCount(saveDto.getRoomCount());		
		emlakci.setId(saveDto.getEmlakci_id());
		emlak.setEmlakci(emlakci);
		emlakRepo.save(emlak);
	}
	
	public void sell(EmlakSaveDto saveDto)
	{
		Emlak emlak=emlakRepo.getById(saveDto.getId());
		Musteri musteri = new Musteri();
		emlak.setSize(saveDto.getSize());
		emlak.setFloor(saveDto.getFloor());
		emlak.setRoomCount(saveDto.getRoomCount());
		musteri.setId(saveDto.getMusteri_id());
		emlak.setMusteri(musteri);
		emlakRepo.save(emlak);
	}
	
	public List<Emlak> search(EmlakSearchDto searchDto) {
		return emlakRepo.getBySizeAndRoomCountAndFloor(searchDto.getSize(), searchDto.getRoomCount(), searchDto.getFloor());
		
	}
	
	public List<Emlak> searchByMusteriName(String name) {
		return emlakRepo.getByMusteriName(name);
	}
	
	public List<Emlak> searchByEmlakciId(Long id) {
		return emlakRepo.getByEmlakciId(id);
	}
	
	public void deleteById(Long id) {
		emlakRepo.deleteById(id);
	}

}
