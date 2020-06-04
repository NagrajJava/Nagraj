package Nag.HibernateMappings.HibernateMappings.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
//@Table(name = "CarsInfo")
public class Car 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int carId;
   private String carName;
   private int model;
   

   @ManyToOne(cascade = CascadeType.ALL)
   private Owner owner;
   
   
   
   
public Car(int carId, String carName, int model,int ownerId) {
	super();
	this.carId = carId;
	this.carName = carName;
	this.model = model;
	this.owner = new Owner(ownerId, "","",ownerId);
	
}




public int getModel() {
	return model;
}




public void setModel(int model) {
	this.model = model;
}




public Owner getOwner() {
	return owner;
}




public void setOwner(Owner owner) {
	this.owner = owner;
}




public int getCarId() {
	return carId;
}




public void setCarId(int carId) {
	this.carId = carId;
}




public Car() {
	super();
	// TODO Auto-generated constructor stub
}

public String getCarName() {
	return carName;
}


public void setCarName(String carName) {
	this.carName = carName;
}

   
	 
}
