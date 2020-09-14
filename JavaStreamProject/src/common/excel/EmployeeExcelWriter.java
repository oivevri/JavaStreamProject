package common.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import common.Employee;

public class EmployeeExcelWriter {
	public void xlsWriter(List<Employee> list) { // 데이터는 매개값(Employee)로 받음
		HSSFWorkbook workbook = new HSSFWorkbook(); // 엑셀파일 하나 만들고
		HSSFSheet sheet = workbook.createSheet(); // 시트 만든거
//		데이터가 한 롤을 만들어서 셀을 만들어야함??
		HSSFRow row = sheet.createRow(0); // 행 만들기
		HSSFCell cell; // 셀은 라이브러리에 있던 놈들을 가져오자
		
		// 첫번재, 두번째, ... row???에 이름을 붙여주자 칼럼명이 아니라?
		cell = row.createCell(0); // 첫번째
		cell.setCellValue("EmployeeID");
		cell = row.createCell(1);
		cell.setCellValue("FirstName");
		cell = row.createCell(2);
		cell.setCellValue("LastName");
		cell = row.createCell(3);
		cell.setCellValue("Email");
		cell = row.createCell(4);
		cell.setCellValue("Salary");
		
//		이제 각각 이름에 맞는 데이터들을 루핑돌면서 가져오자
		Employee emp;
		for (int i = 0; i < list.size(); i++) {
			emp = list.get(i); // 0부터 가져와서(1번째칼럼) emp에 넣자
			
			// 라인(row)을 새로 계속 만드는거 ( 그럼 cell값은 그대로 고정)
			row = sheet.createRow(i+1);
			
			// 실제 들어갈 정보 쓰면 됨
			cell = row.createCell(0);
			cell.setCellValue(emp.getEmployeeId()); // emp가 가지고있는 정보
			cell = row.createCell(1);
			cell.setCellValue(emp.getFirstName());
			cell = row.createCell(2);
			cell.setCellValue(emp.getLastName());
			cell = row.createCell(3);
			cell.setCellValue(emp.getEmail());
			cell = row.createCell(4);
			cell.setCellValue(emp.getSalary());
// 엑셀파일로 데이터만드는거 완료(워크북 생성 완료			
		}
		
		File file = new File("employeeExcel.xls"); // 엑셀파일 새로만듦
		FileOutputStream fos = null;// 파일 쓰기위해 output Stream 사용
//		쓰기용도로  ___________하나 만들겠다는거..
		
		try { // 파일 하나 생성해준거고
			fos = new FileOutputStream(file); // 파일읽어오고 쓰는건 예외처리 해줘야함
			workbook.write(file); // wirte 메소드로 파일에다가 써줄거임
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null)
					workbook.close();
				if(fos != null)
					fos.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
