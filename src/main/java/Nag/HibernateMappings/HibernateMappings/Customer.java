package Nag.HibernateMappings.HibernateMappings;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Customer 
{
	@Id
	@GeneratedValue
  private int id;
  private String name;
  private String emailId;
  private String gender;
  
  @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
  @JoinColumn(name = "id",referencedColumnName = "id")
  private List<Product> products;
      
  
public Customer() {
	
}
public Customer(int id, String name, String emailId, String gender, List<Product> products) {
	super();
	this.id = id;
	this.name = name;
	this.emailId = emailId;
	this.gender = gender;
	this.products = products;
}
public List<Product> getProduct() {
	return products;
}
public void setProduct(List<Product> product) {
	this.products = product;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
  
  
  
  
}
