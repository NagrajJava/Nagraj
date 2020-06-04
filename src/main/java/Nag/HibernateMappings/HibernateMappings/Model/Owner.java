package Nag.HibernateMappings.HibernateMappings.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.bytebuddy.dynamic.scaffold.TypeInitializer.None;

@Entity
public class Owner 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
   private String Name;
   private String Address;
   
  @ManyToOne(cascade = CascadeType.ALL)
   private Car car;
  
  
  


public Car getCar() {
	return car;
}




public void setCar(Car car) {
	this.car = car;
}




public Owner() {
	super();
	// TODO Auto-generated constructor stub
}




public Owner(int id, String name, String address,int carId) {
	super();
	this.id = id;
	Name = name;
	Address = address;
	this.car = new Car(carId, "",0,id);
	
}




public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
 
   
   
   
}
