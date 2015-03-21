import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;


public class Asheet extends BaseTest
{
	@Test
	public void m1() throws Exception
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\bittech\\project\\ExcelSheetRead\\src\\test\\java\\EXCELSHEET.xls");
        //Access the required test data sheet
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheet("sheet1");
	
		 for (int count = 1; count <= sheet.getLastRowNum(); count++)
	        {
	            HSSFRow row = sheet.getRow(count);
	            String id = row.getCell(0).toString();
	            String userid = row.getCell(1).toString();
	            String password = row.getCell(2).toString();
	            if (id.equalsIgnoreCase("1.0"))
	            {
	                System.out.println("hellos");
	                dr.findElement(By.id("email")).sendKeys(userid);
	                dr.findElement(By.id("pass")).sendKeys(password);
	                dr.findElement(By.id("u_0_n")).click();
	                break;
	              
	            }
	            
	        }
	}

}
