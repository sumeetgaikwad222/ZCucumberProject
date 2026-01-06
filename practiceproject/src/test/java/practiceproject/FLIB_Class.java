package practiceproject;

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
public class FLIB_Class {
	public String readexcel(String excelpath, String Sheetname, int row, int column) throws EncryptedDocumentException, IOException
	{
		FileInputStream FIN = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(FIN);
		Sheet sheet = wb.getSheet(Sheetname);
		Row rowcount = sheet.getRow(row);
		Cell cell = rowcount.getCell(column);
		String data = cell.getStringCellValue();
		return data;
	}
	public String writeexcel(String excelpath, String Sheetname, int row, int column, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream FIN = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(FIN);
		Sheet sheet = wb.getSheet(Sheetname);
		Row rowcount = sheet.getRow(row);
		Cell cell = rowcount.createCell(4);
		cell.setCellValue(data);
		
		FileOutputStream FOS = new FileOutputStream(excelpath);
		wb.write(FOS);
		return data;
	}
	public int readlastrow(String excelpath, String Sheetname, int row) throws EncryptedDocumentException, IOException {
		FileInputStream FIN = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(FIN);
		Sheet sheet = wb.getSheet(Sheetname);
		int lastrow = sheet.getLastRowNum();
		return lastrow;
	}
	public String readconfig(String path, String key) throws IOException
	{
		FileInputStream FIS = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(FIS);
		String value = prop.getProperty(key);
		return value;
	}
}