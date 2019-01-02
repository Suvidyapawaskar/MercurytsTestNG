package mt.mercurytoursdatadriventest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldataconfig {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	public Exceldataconfig(String filepath) throws IOException
	{
		File src=  new File(filepath);
		FileInputStream fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		
	}
	
	public String getData(String sheetname,int row,int column)
	{
		sheet = wb.getSheet(sheetname);
		String data=sheet.getRow(row).getCell(column).getStringCellValue();
			
		return data;
		
	}
	
	public int getRowcount(String sheetname)
	{
		int row= wb.getSheet(sheetname).getLastRowNum();
		int rowcount = row+1;
		return rowcount;
		
	}
	
	

}
