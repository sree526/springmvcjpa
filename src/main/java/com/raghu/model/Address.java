package com.raghu.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="address")
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Id
    @GeneratedValue
    private Integer addressId;
    private String city;
    private String street;
    private String state;
    private String zip;
	public Integer getAddressId() {
		return addressId;
	}
	
	public Address(){
		
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
    public String toString() {
        return "Address [id=" + addressId + ", street=" + street
                + ", city=" + city + ", state=" + state
                + ", zip=" + zip+"]";
    }
}
