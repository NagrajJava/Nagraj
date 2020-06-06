package Nag.HibernateMappings.HibernateMappings;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class TestController 
{
	 @Autowired
	    TestService testService;
	 
	    //produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} 
	 @GetMapping(value = "/Users")
	    public List<TestRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
	            @RequestParam(value = "limit", defaultValue = "30") int limit) throws FileNotFoundException, IOException 
	    {
	    	 List<TestRest> returnValue = new ArrayList<TestRest>();
	    	  List<TestDto> users = testService.getUsers(page, limit);
	    	  users.forEach(System.out::println);
	        for (TestDto userDto : users) {
	        	TestRest userModel = new TestRest();
	            BeanUtils.copyProperties(userDto, userModel);
	            //returnValue.forEach(System.out::println);
	            returnValue.add(userModel);
	        }
	        
	        return returnValue;
	    }
	 
	 @GetMapping("getExcel")
	 public String covertingController() throws IOException
	 {
		 testService.convertingToExcelData();
		 return "Excel Genereted Check";
	 }
}
