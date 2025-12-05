package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	
	String path = "C:\\Users\\Hp\\BoomBolt_Automation\\BoomBolt_Automation_Project\\testData\\MOCK_DATA (1).xlsx";

	
	
	//DataProvider 1
	@DataProvider(name = "regData")
	//@Test
	public String[][] regData() throws IOException
	{
		ExcelUtility xl = new ExcelUtility(path);
		
		int totalrow = xl.getRowCount("data");
		int totalcells = xl.getCellCount("data", 1);
		//System.out.println("rows="+totalrow + "\t" +"cells="+totalcells );
		
		String regData[][] = new String[totalrow][totalcells];
		
		for(int r=1; r<= totalrow; r++)
		{
			for(int c = 0; c<totalcells; c++)
			{
				regData[r-1][c] = xl.getCellData("data", r, c);
			}
		}
	
		return regData;	
	}
	
	//DataProvider 2
	@DataProvider(name = "loginData")
	public String[][] loginData() throws IOException
	{
		ExcelUtility xl = new ExcelUtility(path);
		
		int totalrow = xl.getRowCount("data");
		int totalcells = xl.getCellCount("data", 1);
		//System.out.println("rows="+totalrow + "\t" +"cells="+totalcells );
		
		String loginData[][] = new String[totalrow][totalcells];
		
		for(int r=1; r<= totalrow; r++)
		{
			for(int c = 0; c<totalcells; c++)
			{
				loginData[r-1][c] = xl.getCellData("data", r, c);
			}
		}
	
		return loginData;	
	}
	
	
	
}
