package practice_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class File_Class {
	
	public String readexcel(String excelpath, String sheetname, int rowcount, int columns) throws EncryptedDocumentException, IOException
	{
		FileInputStream FIS = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(FIS);
		Sheet sheet = wb.getSheet(sheetname);
		Row rows = sheet.getRow(rowcount);
		Cell cells = rows.getCell(columns);
		String data = cells.getStringCellValue();
		return data;
	}
	public String writeexcel(String excelpath, String sheetname, int rowcount, int columns, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream FIS = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(FIS);
		Sheet sheet = wb.getSheet(sheetname);
		Row rows = sheet.getRow(rowcount);
		Cell cells = rows.createCell(5);
		cells.setCellValue(data);
		
		FileOutputStream FOS = new FileOutputStream(excelpath);
		wb.write(FOS);
		return data;
	}
	public String readconfig(String path, String key) throws IOException
	{
		FileInputStream FIS = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(FIS);
		String value = prop.getProperty(key);
		return value;
	}
	public int getlastrow(String excelpath, String sheetname, int rowcount) throws EncryptedDocumentException, IOException
	{
		FileInputStream FIS = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(FIS);
		Sheet sheet = wb.getSheet(sheetname);
		int lastrow = sheet.getLastRowNum();
		return lastrow;
	}
}
