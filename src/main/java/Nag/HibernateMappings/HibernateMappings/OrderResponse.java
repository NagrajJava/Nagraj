package Nag.HibernateMappings.HibernateMappings;

public class OrderResponse 
{
   private String name ;
   private String productName;
   
   
   public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
   
   public OrderResponse(String productName, String name) {
		super();
		this.productName = productName;
		this.name = name;
	}
public String getProductname() {
	return productName;
}
public void setProductname(String productname) {
	this.productName = productname;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


   
   
   
}
