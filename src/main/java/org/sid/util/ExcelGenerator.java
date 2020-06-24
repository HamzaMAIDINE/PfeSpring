package org.sid.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.sid.entities.AppelOffre;
import org.sid.entities.SoumissionOuvrage;
 
public class ExcelGenerator {

	public static ByteArrayInputStream exportSoumission(AppelOffre ao) throws IOException {
		String[] COLUMNs = {"N prix","Désignation des Ouvrages","Unité","Quantité","Prix Unitaire","Prix Total"};
		try(
				Workbook workbook = new XSSFWorkbook();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
		){
			double total = 0;
			
			CellStyle style = workbook.createCellStyle();
			style.setBorderBottom(BorderStyle.THIN);  
            style.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
            style.setBorderRight(BorderStyle.THIN);  
            style.setRightBorderColor(IndexedColors.BLACK.getIndex());  
            style.setBorderTop(BorderStyle.THIN);  
            style.setTopBorderColor(IndexedColors.BLACK.getIndex());  
            style.setBorderLeft(BorderStyle.THIN);  
            style.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
            
			Sheet sheet = workbook.createSheet("Tableau borderau");
	 
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLACK.getIndex());
	 
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
			headerCellStyle.setBorderBottom(BorderStyle.THIN);  
			headerCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
			headerCellStyle.setBorderRight(BorderStyle.THIN);  
            headerCellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());  
            headerCellStyle.setBorderTop(BorderStyle.THIN);  
            headerCellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());  
            headerCellStyle.setBorderLeft(BorderStyle.THIN);  
            headerCellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	 
            int rowIdx = 1;
            
            //title header
            
            
            Row titleRow = sheet.createRow(rowIdx++);
			Cell titleC = titleRow.createCell(2);
			titleC.setCellValue("BORDEREAU DES PRIX");
			
			Row title2Row = sheet.createRow(rowIdx++);
			Cell title2C = title2Row.createCell(1);
			
			title2C.setCellValue(ao.getObjet());
            
			// Row for Header
			Row headerRow = sheet.createRow(rowIdx++);
			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}
			
			for (SoumissionOuvrage so : ao.getSoumission().getSoumissionOuvrages()) {
				Row row = sheet.createRow(rowIdx++);
	 
				ArrayList<Cell> cells = new ArrayList<Cell>();
				for(int i=0;i<COLUMNs.length;i++)cells.add(row.createCell(i));
				int i = 1;
				cells.get(0).setCellValue(i++);
				cells.get(1).setCellValue(so.getOuvrage().getDesignation());
				 sheet.setColumnWidth(1, 9000);  
				cells.get(2).setCellValue(so.getOuvrage().getUnite());
				cells.get(3).setCellValue(so.getQte());
				cells.get(4).setCellValue(so.getPrix());
				cells.get(5).setCellValue(so.getQte() * so.getPrix());
				
				total+=so.getQte() * so.getPrix();
				
	            for(Cell c: cells) {
					
		            c.setCellStyle(style);  
				}
				
			}
			
			CellStyle cs = workbook.createCellStyle();
			cs.setBorderBottom(BorderStyle.THIN);  
			cs.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			cs.setBorderTop(BorderStyle.THIN);  
			cs.setTopBorderColor(IndexedColors.BLACK.getIndex()); 
			
			Row totalR = sheet.createRow(rowIdx++);
			Cell cellTotalTitle = totalR.createCell(0);
			cellTotalTitle.setCellValue("Total :");
			cellTotalTitle.setCellStyle(style);
			Cell cellTotalV = totalR.createCell(5);
			cellTotalV.setCellValue(total);
			cellTotalV.setCellStyle(style);
			
			
			
			Row tvaR = sheet.createRow(rowIdx++);
			Cell cellTvaTitle = tvaR.createCell(4);
			cellTvaTitle.setCellValue("Tva :");
			cellTvaTitle.setCellStyle(style);
			Cell cellTvaV = tvaR.createCell(5);
			cellTvaV.setCellValue(total * 0.2);
			cellTvaV.setCellStyle(style);
			
			Row ttcR = sheet.createRow(rowIdx++);
			Cell cellTtcTitle = ttcR.createCell(4);
			cellTtcTitle.setCellValue("Total TTC :");
			cellTtcTitle.setCellStyle(style);
			Cell cellTtcV = ttcR.createCell(5);
			cellTtcV.setCellValue(total + (total * 0.2));
			cellTtcV.setCellStyle(style);
			for(int i = 1; i> 5; i++ ) {
				totalR.createCell(i).setCellStyle(cs);
				tvaR.createCell(i).setCellStyle(cs);
				ttcR.createCell(i).setCellStyle(cs);
			}
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

}
