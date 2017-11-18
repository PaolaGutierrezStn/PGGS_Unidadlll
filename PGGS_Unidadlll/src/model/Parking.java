package model;

import java.io.Serializable;

public class Parking implements Serializable{
	private Long id;
	private String type;
	private int num_cars;
	private String company;
	
	public Parking(Long id, String type, int num_cars, String company) {
		super();
		this.id = id;
		this.type = type;
		this.num_cars = num_cars;
		this.company = company;
	}
	
	public Parking() {
		this(0L,"",0,"");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNum_cars() {
		return num_cars;
	}

	public void setNum_cars(int num_cars) {
		this.num_cars = num_cars;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Parking [id=" + id + ", type=" + type + ", num_cars=" + num_cars + ", company=" + company + "]";
	}
	
	
	
	
	
	
	

}
