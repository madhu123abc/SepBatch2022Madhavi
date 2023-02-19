package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
static XSSFWorkbook WB; 
	
	public static Object[][] getDataFromSheet(String sheetName) 
	{
		System.out.println("************Loading Data from Excel********");
		Object arr[][] = null;
		try {
			//load Excel
			WB = new XSSFWorkbook(new FileInputStream(new File("./testdata/TestData.xlsx")));
			//load sheet
			XSSFSheet sheet = WB.getSheet(sheetName);
			int row = sheet.getPhysicalNumberOfRows();
			int column = sheet.getRow(0).getPhysicalNumberOfCells();
			arr=new Object[row-1][column];
			for(int i=1;i<row;i++) 
			{
			for(int j=0;j<column;j++)
				{	
				   //arr[i][j]=WB.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue();
				    System.out.println(getData(sheetName,i,j));
				    arr[i-1][j]=getData(sheetName,i,j);
			     }
			
		}
				
		}catch (FileNotFoundException e) {
			System.out.println("Couldnot find the file" + e.getMessage());

		} catch (IOException e) {
			System.out.println("Could not load the file" + e.getMessage());
		}
	
        return arr;
		}
	public static String  getData(String sheetName,int row,int column)
	{
		String data ="";
		XSSFCell cell=WB.getSheet(sheetName).getRow(row).getCell(column);
		if(cell.getCellType()==CellType.STRING) {
			data =cell.getStringCellValue();
		}
		else if(cell.getCellType()==CellType.NUMERIC) {
		 double dataInDouble=cell.getNumericCellValue();
			data =String.valueOf(dataInDouble);
			
		}
		else if(cell.getCellType()==CellType.BLANK) {
			data=" ";
		}
		return data;
	}
	
	
	
	
}