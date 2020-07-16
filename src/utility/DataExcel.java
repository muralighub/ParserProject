/* **
 
 * This is Excel utility thats sends the data sets to the input date field. 
 
 ***/

package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*; //this is for the iterator Iterator<Row>
import org.apache.poi.ss.usermodel.*; // this is for Row Iterator<Row>
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataExcel {

	public static XSSFWorkbook wb;
	public static FileInputStream fis;

	public ArrayList<String> getData(String testcasename) throws IOException {
		ArrayList<String> a = new ArrayList<String>();

		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\resources\\TestData.xlsx");
		wb = new XSSFWorkbook(fis);
		int sheets = wb.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (wb.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = wb.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();

				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						column = k;

					}
					k++;
				}

				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {
						Iterator<Cell> pv = r.cellIterator();
						while (pv.hasNext()) {

							Cell valueType = pv.next();
							if (valueType.getCellTypeEnum() == CellType.STRING) {
								a.add(valueType.getStringCellValue());
							} else {
								a.add(NumberToTextConverter.toText(valueType.getNumericCellValue()));
							}

						}

					}
				}
			}
		}
		return a;
	}

}
