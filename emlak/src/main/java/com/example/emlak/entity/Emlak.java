package com.example.emlak.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "emlak")
public class Emlak {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int size;
	private int roomCount;
	private int floor;
	@ManyToOne()
	@JoinColumn(name = "emlakci_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	Emlakci emlakci;
	@ManyToOne()
	@JoinColumn(name = "musteri_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	Musteri musteri;
	
	public Emlak() {
	}

	public Emlak(Long id, int size, int roomCount, int floor) {
		this.id = id;
		this.size = size;
		this.roomCount = roomCount;
		this.floor = floor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public Emlakci getEmlakci() {
		return emlakci;
	}

	public void setEmlakci(Emlakci emlakci) {
		this.emlakci = emlakci;
	}

	public Musteri getMusteri() {
		return musteri;
	}

	public void setMusteri(Musteri musteri) {
		this.musteri = musteri;
	}
	
	
	
	
	
	
	

}
