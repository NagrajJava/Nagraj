package Nag.HibernateMappings.HibernateMappings.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Nag.HibernateMappings.HibernateMappings.Model.Car;
import Nag.HibernateMappings.HibernateMappings.Model.Owner;
import Nag.HibernateMappings.HibernateMappings.ServiceImpl.ServiceImpl;

@Service
public class CarService  {

	 @Autowired
	 ServiceImpl serviceimpl;
	 
	public List<Car> collectionAllcarsInfo() {
		     List<Car> car =  (List<Car>) serviceimpl.findAll();
		      return car;
	}

	public Car savecarsInfo(String name) {
		Owner ownr = new Owner();
		   ownr.setAddress("Pune");
		   ownr.setName("Mahesh");
		   Car car = new Car();
		   car.setCarName(name);
		   car.setModel(2018);
		   car.setOwner(ownr);
		   Car car2 = new Car();
		      car2.setCarName(name);
		      car2.setModel(2019);
		      car2.setOwner(ownr);
		      serviceimpl.save(car2);
		      serviceimpl.save(car);
		
		return car2;
		
	}
	 
	public void updateCarByid(Car car, int id) {
		Car carupdate = serviceimpl.findById(id).orElse(null);
		  if(carupdate.getCarId() == id)
		  {
			  carupdate.setCarName(car.getCarName());
			  carupdate.setModel(car.getModel());
			  carupdate.setOwner(car.getOwner());
			  
		  }
		  serviceimpl.save(carupdate);
		
	}
	
}
