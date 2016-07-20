package generics;

import java.util.Hashtable;

public class RunModeConfiguration {

	// Function for Suite Runnable.
	public static boolean isSuiteRunnable(String suiteName, Xlsx_Reader xls){
		int rows = xls.getRowCount(Constants.SUITE_SHEET);
		
		for(int rNum=2;rNum<=rows;rNum++){
			String data = xls.getCellData(Constants.SUITE_SHEET, Constants.SUITENAME_COL, rNum);
			if(data.equals(suiteName)){
				String runmode = xls.getCellData(Constants.SUITE_SHEET, Constants.RUNMODE_COL, rNum);
				if(runmode.equals("Y"))
					return true;
				else
					return false;
			}
		}
		
		return false;
	}

    //Function for Test case runnable.
	public static boolean isTestCaseRunnable(String testCase, Xlsx_Reader xls){
		int rows = xls.getRowCount(Constants.TESTCASES_SHEET);
		for(int rNum=2;rNum<=rows;rNum++){
			String testNameXls = xls.getCellData(Constants.TESTCASES_SHEET, Constants.TESTCASES_COL, rNum);
			if(testNameXls.equals(testCase)){
			String runmode = xls.getCellData(Constants.TESTCASES_SHEET, Constants.RUNMODE_COL, rNum);
			if(runmode.equals(Constants.RUNMODE_YES))
				return true;
			else
				return false;
		    }
		}
		return false;// default		
	}

    //Function for reading data form excel file.
	public static Object[][]  getData(String testName, Xlsx_Reader xls){
		int rows = xls.getRowCount(Constants.DATA_SHEET);
		System.out.println("Total rows - "+ rows);
		
		// row number for testCase
		int testCaseRowNum=1;
		for(testCaseRowNum=1;testCaseRowNum<=rows;testCaseRowNum++){
			String testNameXls = xls.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);
			if(testNameXls.equalsIgnoreCase(testName))
				break;
		}
		System.out.println("Test Starts from row Number - "+ testCaseRowNum);
		int dataStartRowNum=testCaseRowNum+2;
		int colStartRowNum=testCaseRowNum+1;
		
		// rows of data
		int testRows=1;
		while(!xls.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum+testRows).equals("")){
			testRows++;
		}
		System.out.println("Total rows of data are - "+testRows+" and Browser are - "+testRows);
		
		// cols of data
		int testCols=0;
		while(!xls.getCellData(Constants.DATA_SHEET,testCols,colStartRowNum).equals("")){
			testCols++;
		}
		Object[][] data = new Object[testRows][1];
		int r=0;
		for(int rNum=dataStartRowNum;rNum<(dataStartRowNum+testRows);rNum++){
			Hashtable<String,String> table = new Hashtable<String,String>();
			for(int cNum=0;cNum<testCols;cNum++){
				table.put(xls.getCellData(Constants.DATA_SHEET, cNum, colStartRowNum), xls.getCellData(Constants.DATA_SHEET, cNum, rNum));
			}
			data[r][0]=table;
			r++;
		}
		// 0,0 , 0,1
		// 1,0 , 1,1
		return data;

	}
	
}
