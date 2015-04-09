//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Iterator;
//
//import org.apache.poi.ss.formula.functions.Column;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.junit.Test;
//import org.openqa.selenium.By;
//
//
//public class ReadFromExcel extends BaseTest
//{
//	@Test
//	public void getDataFromExcel() throws Throwable
//	
//	{
//	
//	
//	
//	{
//		 try {
//		      /*// Open the Excel file
//		        FileInputStream fis = new FileInputStream("C:\\Users\\bittech\\project\\ExcelSheetRead\\src\\test\\java\\EXCELSHEET.xlsx");
//		        //Access the required test data sheet
//		        XSSFWorkbook wb = new XSSFWorkbook(fis);
//		        XSSFSheet sheet = wb.getSheet("sheet1");*/
//		        for (int count = 1; count <= sheet.getLastRowNum(); count++)
//		        {
//		            HSSFRow row = sheet.getRow(count);
//		            HSSFCell cell = row.getCell(4, row.RETURN_BLANK_AS_NULL);
//
//		            String execute = row.getCell(0).toString();
//		            String affiliateName = row.getCell(1).toString();
//		            String userid = row.getCell(2).toString();
//		            String password = row.getCell(3).toString();
//
//		            log.info("Affiliates name : " + affiliateName);
//		            log.info("Execute : " + execute);
//
//		            if (execute.equalsIgnoreCase("yes"))
//		            {
//		                log.info("=========================================================");
//		                log.info("Login Test Started for  : ' " + affiliateName + " '");
//		                log.info("=========================================================");
//
//		        /*for(int count =1; count <= sheet.getLastRowNum(); count++)
//		        {
//		        	XSSFRow row= sheet.getRow(count);
//		        	XSSFCell cell= row.getCell(1, row.RETURN_BLANK_AS_NULL);
//		        	
//		        	String execute =row.getCell(0).toString();
//		        	
//		        	String userid=row.getCell(1).toString();
//		        	String password =row.getCell(2).toString();
//		        	if(execute.equalsIgnoreCase("1"))
//		        	{
//		        		System.out.println( execute +" " + userid + "  " + password );
//		        		dr.findElement(By.id("email")).sendKeys(userid);
//		        		dr.findElement(By.id("pass")).sendKeys(password);
//		        		
//		        	}
//		        	
//		        	
//		        }
//		        
//		        */
//		        
//		        
//		        
//		        
//		        
//		       // Loop through all rows in the sheet
//		       // Start at row 1 as row 0 is our header row
//		        /*Iterator<Row> ite = sheet.rowIterator();
//				while(ite.hasNext()){
//					Row row = ite.next();
//					Iterator<Cell> cite = row.cellIterator();
//					while(cite.hasNext()){
//						Cell c = cite.next();
//						
//						
//						System.out.print(c.toString()+"   ");
//					} 
//					System.out.println();
//
//		        }
//		        fis.close();
//		        wb.close();
//		    } catch (IOException e) {
//		        System.out.println("Test data file not found");
//		    }  
//		 
//		 
//		 
//		}
//
//	}*/
//}
//		        }
//		 }
//	
