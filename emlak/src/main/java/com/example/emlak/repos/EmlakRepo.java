package com.example.emlak.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.emlak.entity.Emlak;

public interface EmlakRepo extends JpaRepository<Emlak, Long> {
	
	public List<Emlak> getBySizeAndRoomCountAndFloor(int size, int room, int floor);
	
	public List <Emlak> getByMusteriName(String name);
	
	public List <Emlak> getByEmlakciId(Long id);
	
	

}
