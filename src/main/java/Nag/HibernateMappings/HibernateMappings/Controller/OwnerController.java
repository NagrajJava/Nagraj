package Nag.HibernateMappings.HibernateMappings.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Nag.HibernateMappings.HibernateMappings.Model.Owner;
import Nag.HibernateMappings.HibernateMappings.Service.OwnerService;

@RestController
public class OwnerController 
{
	@Autowired
	OwnerService ownerService;
   
	@RequestMapping("/ownerinfo")
	public List<Owner> collectingCarsInformation()
	{    
		List<Owner> owner = ownerService.collectionAllOwnersInfo();
		return  owner;
		
	}
	
	@RequestMapping(value ="/Collectownerinfo/{id}")
	public Optional<Owner> collectingCarsInformation(@PathVariable("id") int id)
	{    
		Optional<Owner> owner = ownerService.collectOwnerInfoByid(id);
		return  owner;
		
	}
	
	@RequestMapping(value ="/saveownerinfo",method = RequestMethod.POST)
	public String collectingCarsInformation(@RequestBody List<Owner> owner)
	{    
		ownerService.saveOwnerInfo(owner);
		return  "OwnerinfoSaved";
		
	}
	
	

	@GetMapping(value ="/saveownerinfo/{name}")
	public Owner savingCarsAndOwnerInformation(@PathVariable("name") String name)
	{    
		Owner owner = ownerService.saveOwnerInfo(name);
		return  owner;
		
	}
	@RequestMapping(value ="/Updateownerinfo/{id}",method = RequestMethod.POST)
	public Owner collectingCarsInformation(@RequestBody Owner owner,@PathVariable("id") int id)
	{    
		Owner ownerupdated = ownerService.updateOwnerInfoByid(owner,id);
		return  ownerupdated;
		
	}
}
