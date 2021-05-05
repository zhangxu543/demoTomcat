package com.csi.util;

import com.csi.domain.Grade;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * 导出的工具类
 * @author LXY
 *
 */
public class GradeExportUtil {
	/**
	 * 导出excel的
	 * @param
	 * @return
	 */
	public static byte[] write2Excel(List<Grade> grades) {
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
					"院系",
					"专业",
					"班级",
					"科目",
					"任课教师",
					"成绩",
					"学分",
					"学期"
			};
			for(int i=0;i<11;i++) {
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
			for(int j=0;j<grades.size();j++) {
				Grade grade=grades.get(j);
				row=sheet.createRow(j+1);
				//给当前行的个列添加数据
				row.createCell(0).setCellValue(grade.getStudent().getStuId());
				row.createCell(1).setCellValue(grade.getStudent().getStuName());
				row.createCell(2).setCellValue(grade.getStudent().getStuSex());
				row.createCell(3).setCellValue(grade.getStudent().getMajor().getDept_name());
				row.createCell(4).setCellValue(grade.getStudent().getMajor().getName());
				row.createCell(5).setCellValue(grade.getStudent().getStuClass());
				row.createCell(6).setCellValue(grade.getSubject().getName());
				row.createCell(7).setCellValue(grade.getTeacher().getTeaName());
				row.createCell(8).setCellValue(grade.getGrade());
				row.createCell(9).setCellValue(grade.getSubject().getCredit());
				row.createCell(10).setCellValue(grade.getTerm());
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
