package Nag.HibernateMappings.HibernateMappings.Relationships;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
   @Autowired
	private UserRepo userrepo;
   @Autowired
  	private UserContactRepo userContactRepo;
   
   @Autowired
 private   UsersLogsRepo usersLogsRepo;
	
	@GetMapping("/SaveUsersinfo/{name}")
	public List<UserContact> saveUsersInfo(@PathVariable("name") String name)
	{
		 
		UserContact userContact = new UserContact();
          
          userContact.setContact(900060);
          
          Users users = new Users();
		   users.setName(name);
          users.setSalary(20000);
          users.setDepartment("JavaTeam");
         
      	UserLogs userlogs = new UserLogs();
        userlogs.setLogs("Hi i am hero");
     UserLogs userlog = new UserLogs();
             userlog.setLogs("Hi i am heroin");   
	
		         
             users.setUserLogs(Arrays.asList(userlog,userlogs));
           userContact.setUsers(users);
         
           userContactRepo.save(userContact);
           
		return userContactRepo.findAll();
		
	}
	
	@GetMapping("/getusers")
	public List<Users> getusers()
	{
		return userrepo.findAll();
	}
	@GetMapping("/getusercontacts")
	public List<UserContact> getusercontacts()
	{
		return userContactRepo.findAll();
	}
	
	@GetMapping("/getlogs")
	public List<UserLogs> getAlllogs()
	{
		return usersLogsRepo.findAll();
	}
	
	@GetMapping("/getallLogs/{name}")
	public List<UserLogs> getAlllogs(@PathVariable("name") String name)
	{
		Users user = new Users();
	      user.setDepartment("Testing");
	      user.setName(name);
	      user.setSalary(2000);
	      
		UserLogs userlogs = new UserLogs();
		       userlogs.setLogs("Nagraj logs");
		       userlogs.setUser(user);
		       usersLogsRepo.save(userlogs);
				UserLogs userlog = new UserLogs();
				       userlog.setLogs("Magesh logs");
				       userlog.setUser(user);
				       usersLogsRepo.save(userlog);
					return usersLogsRepo.findAll();
		
	}
	
}
