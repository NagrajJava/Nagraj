package Nag.HibernateMappings.HibernateMappings.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Nag.HibernateMappings.HibernateMappings.Service.TestService;

@RestController
@ResponseBody
public class TestController 
{
	 @Autowired
	    TestService testService;
	 	 	 
	 @GetMapping("getExcel")
	 public String covertingController() throws IOException
	 {
		 String path = "/home/user/Desktop/JAVA";
    	 String reportName="ExcelReport";
		 testService.convertingToExcelData(path,reportName);
		 return reportName+" Generated Check in Path:"+path;
	 }
}
