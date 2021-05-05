package com.csi.util;

import java.io.ByteArrayOutputStream;
import java.util.List;

import com.csi.domain.Student;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 导出的工具类
 * @author LXY
 *
 */
public class StudentExportUtil {
	/**
	 * 导出excel的
	 * @param
	 * @return
	 */
	public static byte[] write2Excel(List<Student> students) {
		byte[] data=null;
		//字节数组 输出流   可以理解成内存的输出流
		ByteArrayOutputStream out=null;
		try {
			out=new ByteArrayOutputStream();
			Workbook wb=new HSSFWorkbook();
			Sheet sheet=wb.createSheet("学生信息");
			
			//创建表头
			Row row=sheet.createRow(0);
			String[] titleArray= {
					"学号",
					"姓名",
					"性别",
					"班级",
					"院系",
					"专业",
					"宿舍",
					"民族",
					"政治面貌",
					"家庭住址",
			};
			for(int i=0;i<10;i++) {
				Cell cell=row.createCell(i);
				//给单元格子添加样式(可以省略)
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				sheet.setColumnWidth(i, 6000);
				CellStyle style=wb.createCellStyle();
				Font font=wb.createFont();
				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				short color=HSSFColor.RED.index;
				font.setColor(color);
				style.setFont(font);
				cell.setCellStyle(style);
				
				//给格子设置值
				cell.setCellValue(titleArray[i]);
			}
			//循环所有的数据并把数据存储给excel的wb中
			System.out.println("6666666666");
			for(int j=0;j<students.size();j++) {
				Student student=students.get(j);
				row=sheet.createRow(j+1);
				//给当前行的个列添加数据
				row.createCell(0).setCellValue(student.getStuId());
				row.createCell(1).setCellValue(student.getStuName());
				row.createCell(2).setCellValue(student.getStuSex());
				row.createCell(3).setCellValue(student.getStuClass());
				row.createCell(4).setCellValue(student.getMajor().getDept_name());
				row.createCell(5).setCellValue(student.getMajor().getName());
				row.createCell(6).setCellValue(student.getStuDorm());
				row.createCell(7).setCellValue(student.getNation().getName());
				row.createCell(8).setCellValue(student.getPolitic().getName());
				row.createCell(9).setCellValue(student.getStuAddress());
			}
			wb.write(out);
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (out!=null) {
					out.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		data=out.toByteArray();
		return data;
	}
	
}
