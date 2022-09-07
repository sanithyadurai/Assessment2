package Assesment;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ReadExcel {
		public static String[][] testData () throws IOException {
			// TODO Auto-generated method stub
			XSSFWorkbook book = new XSSFWorkbook("./Exceldata/testData.xlsx");
			XSSFSheet sheet = book.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			XSSFRow row = sheet.getRow(1);
			int lastCellNum = row.getLastCellNum();
			String[][] data = new String[rowCount][lastCellNum];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < lastCellNum; j++) {
					String input = sheet.getRow(i).getCell(j).getStringCellValue();
					data[i-1][j]=input;     
				}
			}
			book.close();
			return data;
    }
}
Footer
© 2022 GitHub, Inc.
Footer navigation
Terms
Privacy
Security
Status
