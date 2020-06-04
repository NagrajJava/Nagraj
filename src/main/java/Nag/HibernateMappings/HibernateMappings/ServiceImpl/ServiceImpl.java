package Nag.HibernateMappings.HibernateMappings.ServiceImpl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Nag.HibernateMappings.HibernateMappings.Model.Car;

@Repository
public interface ServiceImpl extends JpaRepository<Car, Integer>
{
	
}