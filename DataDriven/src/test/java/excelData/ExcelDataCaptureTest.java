package excelData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataCaptureTest {
	
	static Dictionary<Object, Object> dicObject = new Hashtable<Object, Object>();
	
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		TestCaseData();
//		System.out.println();
//		System.out.println(getData("TestCase"));	
//	}

	public  void TestCaseData(String TCname) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\eclipse-workspace\\DataDriven\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		
		String KeyObjcet = "", ValObject = "";
		ArrayList<String> keyarray = new ArrayList<String>();
		ArrayList<String> Valarray = new ArrayList<String>();

		if (workbook.getSheetName(0).equalsIgnoreCase("TestData")) {
			XSSFSheet sheet = workbook.getSheet("TestData");

			Iterator<Row> rit = sheet.iterator();
			Row firstrow = rit.next();
			Iterator<Cell> frcit = firstrow.cellIterator();

			while (frcit.hasNext()) {
				Cell val = frcit.next();
				KeyObjcet = val.getStringCellValue();
				KeyObjcet = KeyObjcet.toUpperCase();
				keyarray.add(KeyObjcet);
			}

			while (rit.hasNext()) {
				Row row = rit.next();
				if (row.getCell(0).getStringCellValue().equalsIgnoreCase(TCname)) {
					Iterator<Cell> cit = row.cellIterator();
					while (cit.hasNext()) {
						Cell REQval = cit.next();
						ValObject = REQval.getStringCellValue();
						Valarray.add(ValObject);
					}

				}

			}
			for (int i = 0; i < keyarray.size(); i++) {
				dicObject.put(keyarray.get(i), Valarray.get(i));
			}
		}
		workbook.close();
	}
	public String  getData(String reqkey) {
		reqkey = reqkey.toUpperCase();
		Object x=dicObject.get(reqkey);
//		return object;
		return (String) x;
	
	}

}
