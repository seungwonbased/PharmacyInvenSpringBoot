package com.example.pharmacyinven.model;

public class PharmacyVO {

    private int pharmaId;
    private String name;
    private String latitude;
    private String longitude;
    private String phone;

    public PharmacyVO () {

    }

    public PharmacyVO(int pharmaId, String name, String latitude, String longitude, String phone) {
		super();
		this.pharmaId = pharmaId;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.phone = phone;
	}


	public int getPharmaId() {
        return pharmaId;
    }

    public void setPharmaId(int pharmaId) {
        this.pharmaId = pharmaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

	@Override
	public String toString() {
		return "PharmacyVO [pharmaId=" + pharmaId + ", name=" + name + ", latitude=" + latitude + ", longitude="
				+ longitude + ", phone=" + phone + "]";
	}

}
