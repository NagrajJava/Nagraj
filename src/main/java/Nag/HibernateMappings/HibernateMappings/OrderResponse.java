package Nag.HibernateMappings.HibernateMappings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = false)
@JsonInclude(Include.NON_NULL)
public class OrderResponse 
{
	
   private String name ;
   private String gender;
   private String emailId;
   
   
   
   public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

   

public OrderResponse(String name, String gender, String emailId) {
	super();
	this.name = name;
	this.gender = gender;
	this.emailId = emailId;
}



public String getEmailId() {
	return emailId;
}



public void setEmailId(String emailId) {
	this.emailId = emailId;
}



public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getGender() {
	return gender;
}


public void setGender(String gender) {
	this.gender = gender;
}



@Override
public String toString() {
	return "OrderResponse [name=" + name + ", gender=" + gender + "]";
}
   
    
   
   
}
