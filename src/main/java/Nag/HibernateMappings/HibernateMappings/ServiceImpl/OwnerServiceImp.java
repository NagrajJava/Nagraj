package Nag.HibernateMappings.HibernateMappings.ServiceImpl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Nag.HibernateMappings.HibernateMappings.Model.Owner;

@Repository
public interface OwnerServiceImp extends JpaRepository<Owner, Integer>
{
	
}