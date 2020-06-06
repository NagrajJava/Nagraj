package Nag.HibernateMappings.HibernateMappings;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository userRepository;
    
    Logger logger = LoggerFactory.getLogger(this.getClass());
   
    @Override
    public List<TestDto> getUsers(int page, int limit) throws IOException {
    	 File exceptionFile = null;
    	 byte[] fileContent = null;
    	 XSSFRow row;
    	 String path = "/home/user/Desktop/JAVA";
    	logger.debug("Inside convertApplicationDataToExcel method");
        XSSFWorkbook workbook = new XSSFWorkbook();
        String reportName="DataInfo";
        int rowid = 0;
        Pageable pageableRequest = PageRequest.of(page, limit);
        Page<Test> users = userRepository.findAll(pageableRequest);
        List<Test> userEntities = users.getContent();
        List<TestDto> returnValue = new ArrayList<>();
            List<Test> test = (List<Test>) userRepository.findAll();
        Map< Integer, Object[] > applications = new TreeMap< Integer, Object[]>();
        
        for (Test userEntity : userEntities) {
            TestDto userDto = new TestDto();
            BeanUtils.copyProperties(userEntity, userDto);
            returnValue.add(userDto);
        }
       
      
        System.out.println("TestDTO values:"+returnValue.get(0));
        String[] header = CSVHeaderConstant.EXCEPTION_REPORT.split(",");
		XSSFSheet spreadSheet = workbook.createSheet(reportName);
		applications.put(0,new Object[]{header});
		for(int i =1; i<8;i++)
		{
		  applications.put(i,new Object[]{returnValue.get(i)});
		}
		System.out.println("Map info"+applications.size());
        for(int i = 0 ; i< 50;i++){
            spreadSheet.setColumnWidth(i,25*256);
        }
        Set<Integer> keyid = applications.keySet();
            System.out.println(keyid);

            for(int key : keyid){
                row = spreadSheet.createRow(rowid++);
                Object[] objectArr = applications.get(key);

                int cellId = 0;
                 if(key == 0){
                    String[] rowFields = (String[]) objectArr[0];
                    for(String arr :rowFields ){
                        Cell cell = row.createCell(cellId++);
                        cell.setCellValue(arr);
                    }
                 }
					
                 else{
                	               	 
                	 
                	 String[] rowFields = (String[]) objectArr[0];
                     for(Object arr :rowFields ){
                         Cell cell = row.createCell(cellId++);
                         cell.setCellValue((String)arr);
                     }
					 
                
            }
            }  
        exceptionFile = new File(path +"/"+reportName+".xlsx");
        FileOutputStream out = new FileOutputStream(exceptionFile);
        workbook.write(out);
        out.close();
        workbook.close();
        fileContent = Files.readAllBytes(exceptionFile.toPath());
        logger.info("File size in bytes:{}",fileContent.length);
        
       
        return returnValue;
    }
    
    
    public void convertingToExcelData() throws IOException
    { 
    	
    	 File exceptionFile = null;
    	 byte[] fileContent = null;
    	 XSSFRow row;
    	 String path = "/home/user/Desktop/JAVA";
    	logger.debug("Inside convertApplicationDataToExcel method");
        XSSFWorkbook workbook = new XSSFWorkbook();
        String reportName="DataInfo";
        int rowid = 0;
         List<Test> test = (List<Test>) userRepository.findAll();
         System.out.println(test);
        Map< Integer, Object[] > applications = new TreeMap< Integer, Object[]>();
          
      
        System.out.println("TestDTO values:"+test.get(0));
        String[] header = CSVHeaderConstant.EXCEPTION_REPORT.split(",");
		XSSFSheet spreadSheet = workbook.createSheet(reportName);
		applications.put(0,new Object[]{header});
		for(int i =1; i<8;i++)
		{
			for(Test item : test)
			{
		      applications.put(i,new Object[]{item});
			}
		}
		System.out.println("Map info"+applications.size());
        for(int i = 0 ; i< 30;i++){
            spreadSheet.setColumnWidth(i,25*256);
        }
        Set<Integer> keyid = applications.keySet();
            System.out.println(keyid);
             System.out.println(applications.get(2).toString());
            for(int key : keyid){
                row = spreadSheet.createRow(rowid++);
                Object[] objectArr = applications.get(key);

                int cellId = 0;
                 if(key == 0){
                    String[] rowFields = (String[]) objectArr[0];
                    for(String arr :rowFields ){
                        Cell cell = row.createCell(cellId++);
                        cell.setCellValue(arr);
                    }
                 }
					
             }  
        exceptionFile = new File(path +"/"+reportName+".xlsx");
        FileOutputStream out = new FileOutputStream(exceptionFile);
        workbook.write(out);
        out.close();
        workbook.close();
        fileContent = Files.readAllBytes(exceptionFile.toPath());
        logger.info("File size in bytes:{}",fileContent.length);
        
       
        
    }
    
}
