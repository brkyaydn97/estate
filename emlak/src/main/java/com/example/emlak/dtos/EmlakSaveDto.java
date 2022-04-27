package com.example.emlak.dtos;

public class EmlakSaveDto {
	private int size;
	private int roomCount;
	private int floor;
	private Long musteri_id;
	private Long emlakci_id;
	
	
	public EmlakSaveDto() {
	}
	
	public EmlakSaveDto(int size, int roomCount, int floor, Long musteri_id, Long emlakci_id) {
		this.size = size;
		this.roomCount = roomCount;
		this.floor = floor;
		this.musteri_id = musteri_id;
		this.emlakci_id = emlakci_id;
	}
	
	public EmlakSaveDto(int size, int roomCount, int floor, Long emlakci_id) {
		super();
		this.size = size;
		this.roomCount = roomCount;
		this.floor = floor;
		this.emlakci_id = emlakci_id;
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
	public Long getMusteri_id() {
		return musteri_id;
	}
	public void setMusteri_id(Long musteri_id) {
		this.musteri_id = musteri_id;
	}
	public Long getEmlakci_id() {
		return emlakci_id;
	}
	public void setEmlakci_id(Long emlakci_id) {
		this.emlakci_id = emlakci_id;
	}
	
	

}
