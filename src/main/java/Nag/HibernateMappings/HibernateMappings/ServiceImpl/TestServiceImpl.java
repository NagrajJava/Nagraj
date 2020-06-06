package Nag.HibernateMappings.HibernateMappings.ServiceImpl;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Nag.HibernateMappings.HibernateMappings.Model.CSVHeaderConstant;
import Nag.HibernateMappings.HibernateMappings.Model.Test;
import Nag.HibernateMappings.HibernateMappings.Service.TestRepository;
import Nag.HibernateMappings.HibernateMappings.Service.TestService;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository userRepository;
    
    Logger logger = LoggerFactory.getLogger(this.getClass());
          
    public void convertingToExcelData(String path,String reportName) throws IOException
    { 
    	
    	 File exceptionFile = null;
    	 byte[] fileContent = null;
    	 XSSFRow row;
    	
    	logger.debug("Inside convertApplicationDataToExcel method");
        XSSFWorkbook workbook = new XSSFWorkbook();
        
        int rowid = 0;
         Iterable<Test> test =  userRepository.findAll();
        
         System.out.println("Coverted test obejcts to string"+test);
         
       
          
        String[] header = CSVHeaderConstant.EXCEPTION_REPORT.split(",");
		XSSFSheet spreadSheet = workbook.createSheet(reportName);
		for(int i = 0 ; i< 30;i++){
            spreadSheet.setColumnWidth(i,25*256);
		}
		int i =1;
		Map<Integer,Object[]> application = new TreeMap<>();
		          application.put(0,new Object[] {header});
		          for(Test testitem : test)
		          {   
		        	  application.put(i,new Object[] {testitem.getId(),testitem.getName(),testitem.getMobilenumber(),testitem.getAddres()});  
		        	  i++;
		          }
		          logger.info("Map info -> {}",application);
		         Set<Integer> keyid = application.keySet();
		         logger.info("Keys in map ->{}",keyid);
		         for(Integer key : keyid)
		         {
		        	 int cellId = 0;
		         	  row = spreadSheet.createRow(rowid++);
		           Object[] objarr = application.get(key);
		           logger.info("Values in map ->{}",objarr);
		           if(key ==0)
		           {
		        	   String[] testitems = (String[]) objarr[0];
		             for(String item : testitems )
		             {
		                 Cell cell = row.createCell(cellId++);
		                        cell.setCellValue(item);
		             }      
		           } else
		               {
		        	   logger.info("In side else block that is items in Test---");
		        	  
			             for(Object item : objarr )
			             {
			                 Cell cell = row.createCell(cellId++);
			                        cell.setCellValue(item.toString());
			             }   
		               }
		         }
        
		/*
		 * for(Test list : test) {
		 * 
		 * String itemslist1 = list.toString(); System.out.println(itemslist1); row =
		 * spreadSheet.createRow(rowid++); Cell cell = row.createCell(cellId++);
		 * 
		 * cell.setCellValue(itemslist1);
		 * 
		 * }
		 */
        
          
        exceptionFile = new File(path +"/"+reportName+".xlsx");
        FileOutputStream out = new FileOutputStream(exceptionFile);
        workbook.write(out);
        out.close();
        workbook.close();
        fileContent = Files.readAllBytes(exceptionFile.toPath());
        logger.info("File size in bytes:{}",fileContent.length);
        
       
        
    }
    
}

