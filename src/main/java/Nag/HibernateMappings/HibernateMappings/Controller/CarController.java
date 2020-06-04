package Nag.HibernateMappings.HibernateMappings.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Nag.HibernateMappings.HibernateMappings.Model.Car;
import Nag.HibernateMappings.HibernateMappings.Model.Owner;
import Nag.HibernateMappings.HibernateMappings.Service.CarService;

@RestController
public class CarController 
{
	@Autowired
	CarService carService;
   
	@RequestMapping("/mycarsinfo")
	public List<Car> collectingCarsInformation()
	{    
		List<Car> car = carService.collectionAllcarsInfo();
		return  car;
		
	}
	
	@GetMapping(value ="/savemycarsinfo/{name}")
	public Car collectingCarsInformation(@PathVariable("name")  String name)
	{       
	      Car car =  carService.savecarsInfo(name);
		return  car;
		
	}
	
	
	@RequestMapping(value ="/Updatecarinfo/{id}",method = RequestMethod.POST)
	public String updatingCarsInformation(@RequestBody Car car,@PathVariable("id") int id)
	{    
		carService.updateCarByid(car, id);
		return  "CarinfoUpdated";
		
	}
}
