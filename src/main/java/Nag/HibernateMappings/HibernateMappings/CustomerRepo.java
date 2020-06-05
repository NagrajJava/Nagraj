package Nag.HibernateMappings.HibernateMappings;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer, Integer> 
{
	
	  @Query("select new Nag.HibernateMappings.HibernateMappings.OrderResponse(c.name,c.gender,c.emailId) from Customer c")
	  public List<OrderResponse> getSomefileds();
	 
  
	  @Query("select new Nag.HibernateMappings.HibernateMappings.OrderResponse(c.name,c.gender,c.emailId) from Customer c where c.emailId=:emailId")
	  public List<OrderResponse> getSomefiledsOnCondition(String emailId);

    @Query("select new Nag.HibernateMappings.HibernateMappings.OrderResponse(c.name,c.gender,c.emailId) from Customer c where c.emailId=?1 or c.name=?2")
	public List<OrderResponse> getSomefiledsOnCondition(String emailId, String name);
}
 