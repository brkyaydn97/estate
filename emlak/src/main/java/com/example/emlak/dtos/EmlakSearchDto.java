package com.example.emlak.dtos;

public class EmlakSearchDto {
	private int size;
	private int roomCount;
	private int floor;
	
	public EmlakSearchDto() {
	}

	public EmlakSearchDto(int size, int roomCount, int floor) {
		this.size = size;
		this.roomCount = roomCount;
		this.floor = floor;
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
	
	
	
	
	
	

}
