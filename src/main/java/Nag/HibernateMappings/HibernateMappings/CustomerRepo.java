package Nag.HibernateMappings.HibernateMappings;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer, Integer> 
{
	/*
	 * @Query("SELECT new Nag.HibernateMappings.HibernateMappings.OrderResponse(p.productName,c.name) FROM Customer c JOIN c.product_name p"
	 * ) public List<OrderResponse> getSomefileds();
	 */
  
}
 