package Nag.HibernateMappings.HibernateMappings.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Nag.HibernateMappings.HibernateMappings.Model.Car;
import Nag.HibernateMappings.HibernateMappings.Model.Owner;
import Nag.HibernateMappings.HibernateMappings.ServiceImpl.OwnerServiceImp;

@Service
public class OwnerService  {

	 
	 
	 @Autowired
	 OwnerServiceImp ownerServiceimpl;
	public List<Owner> collectionAllOwnersInfo() {
		     List<Owner> owner =  ownerServiceimpl.findAll();
		      return owner;
	}
	
	

	public Owner saveOwnerInfo(String name) {
		Car c  = new Car();
		 c.setCarName("RangeRover");
		  c.setModel(2021);
		 
		Owner ownr = new Owner();
		      ownr.setAddress("Pune");
		      ownr.setName(name);
		      ownr.setCar(c);
		    
		ownerServiceimpl.save(ownr);
		
		return ownr;
		
	}

	public void updateOwnerInfoByid(int id) {
		
		ownerServiceimpl.findById(id);
		
	}
	
public Optional<Owner> collectOwnerInfoByid(int id) {
		
	Optional<Owner> owner = ownerServiceimpl.findById(id);
		
		return owner;
		
	}

	public Owner updateOwnerInfoByid(Owner owner, int id) {
		Owner ownerupdated = ownerServiceimpl.findById(id).orElse(null);
		  if(ownerupdated.getId() == id)
		  {
			  ownerupdated.setId(owner.getId());
			  ownerupdated.setName(owner.getName());
			  ownerupdated.setAddress(owner.getAddress());
			  ownerupdated.setCar(owner.getCar());
			  ownerServiceimpl.save(ownerupdated);
		  }
		return ownerupdated;
		
	}



	public void saveOwnerInfo(List<Owner> owner) {
		   ownerServiceimpl.saveAll(owner);
	}
	 
	
}
