package Nag.HibernateMappings.HibernateMappings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TestRepo extends JpaRepository<Test, Integer>{

	@Transactional
	@Modifying
	@Query("delete from Test where id =?1")
	public void deleteRecord(int id);
	
}
