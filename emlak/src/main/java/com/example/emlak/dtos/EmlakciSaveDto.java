package com.example.emlak.dtos;

public class EmlakciSaveDto {
	private String name;
	private String address;
	private String phone;
	private String email;
	private String fax;
	
	public EmlakciSaveDto() {
		
	}	
	public EmlakciSaveDto(String name, String address, String phone, String email, String fax) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.fax = fax;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}

}
