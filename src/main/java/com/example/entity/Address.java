package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {

	@Id
	private long addressId;
	private int flatOrHouseNumber;
	private String buildingName;
	private String landmark;
	private String village;
	private String taluka;
	private String district;
	private String state;
	@Column(nullable = false)
	private String pincode;

	@OneToOne(mappedBy = "address")
	private Connection connection;

	public Address() {
	}

	public Address(long addressId, int flatOrHouseNumber, String buildingName, String landmark, String village,
			String taluka, String district, String state, String pincode) {
		this.addressId = addressId;
		this.flatOrHouseNumber = flatOrHouseNumber;
		this.buildingName = buildingName;
		this.landmark = landmark;
		this.village = village;
		this.taluka = taluka;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public int getFlatOrHouseNumber() {
		return flatOrHouseNumber;
	}

	public void setFlatOrHouseNumber(int flatOrHouseNumber) {
		this.flatOrHouseNumber = flatOrHouseNumber;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getTaluka() {
		return taluka;
	}

	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
