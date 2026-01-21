package filesRead;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileRead {
	
	public String readconfig(String path, String key) throws IOException
	{
		FileInputStream FIS = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(FIS);
		String value = prop.getProperty(key);
		return value;
	}
	public String readExcel(String path, String sheetname, int rowcound, int column) throws EncryptedDocumentException, IOException
	{
		FileInputStream FIS = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(FIS);
		Sheet sheet = wb.getSheet(sheetname);
		Row rows = sheet.getRow(rowcound);
		Cell cels = rows.getCell(column);
		DataFormatter df = new DataFormatter();
		String cells = df.formatCellValue(cels);
		return cells;
	}
	public String writeExcel(String path, String sheetname, int rowcound, int column, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rowcound);
		Cell cells = row.getCell(column);
		cells.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		return data;
	}
	public int getlastrows(String path, String sheet, int rowcount) throws EncryptedDocumentException, IOException
	{
		FileInputStream FIS = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(FIS);
		Sheet sheetname = wb.getSheet(sheet);
		int lastrow = sheetname.getLastRowNum();
		return lastrow;
	}
	public int getlastcell(String path, String sheet, int rowcount, int column) throws EncryptedDocumentException, IOException
	{
		FileInputStream FIS = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(FIS);
		Sheet sheetname = wb.getSheet(sheet);
		Row rows = sheetname.getRow(rowcount);
		short lastcell = rows.getLastCellNum();
		return lastcell;
	}
}
