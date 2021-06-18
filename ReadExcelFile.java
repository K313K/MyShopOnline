import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	public static final String SEPERATOR = ",";

	public static void main(String args[]) throws IOException {

		FileInputStream fis = new FileInputStream(new File("D:\\SOftware\\Jar\\Student.xlsx"));

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);
		FileWriter fw = new FileWriter(new File("D:\\SOftware\\Jar\\Student.txt"));
		List<Student> studentList = new ArrayList<Student>();
		// writMetaData(sheet,fw);
		for (Row row : sheet) {

			if (row.getRowNum() > 0) {
				Student s = new Student();
				for (Cell cell : row) {
					switch (cell.getColumnIndex()) {
					case 0:
						s.setName(cell.getStringCellValue());
						break;
					case 1:
						s.setAge((int) cell.getNumericCellValue());
						break;
					case 2:
						s.setClassName(cell.getStringCellValue());
						break;
					}
				}
				studentList.add(s);
			}
		}
		Set<Student> s1 = new LinkedHashSet<Student>(studentList);

		for (Student s : s1) {

			System.out.println(s.name + SEPERATOR + s.age + SEPERATOR + s.className);
			fw.write(s.name + SEPERATOR + s.age + SEPERATOR + s.className + "\n");

		}
		fw.close();
		wb.close();
	}

	public static void writMetaData(XSSFSheet sheet, FileWriter fw) {
		List<String> metaDataList = new ArrayList<String>();
		for (Row row : sheet) {
			if (row.getRowNum() == 0) {

				for (Cell cell : row) {
					metaDataList.add(cell.getStringCellValue());
				}
			}
		}
		// For Header Only

		System.out.println(metaDataList.get(0) + SEPERATOR + metaDataList.get(1) + SEPERATOR + metaDataList.get(2));
		try {
			fw.write(metaDataList.get(0) + SEPERATOR + metaDataList.get(1) + SEPERATOR + metaDataList.get(2) + "\n");
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
