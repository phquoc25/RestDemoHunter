package com.qph.restdemo.service.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.*;

public class ExcelParsingUtils {
	
	/**
	 * Get columns header map
	 * @param sheet
	 * @param rowIndex
	 * @return
	 */
	public static Map<String, Integer> getColumnsMap(Sheet sheet, int rowIndex) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		if (sheet != null) {
			Row headerRow = sheet.getRow(rowIndex);
			Iterator<Cell> cellIterator = headerRow.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String h = cell.getStringCellValue();
				if (StringUtils.isEmpty(h)) {
					break;
				} else {
					map.put(h.toLowerCase().trim().replace(" ",  ""), cell.getColumnIndex());
				}

			}
		}
		return map;
	}
	
	public static boolean checkIfRowIsEmpty(Row row) {
		int emptyCell = 0;
		if (row == null) {
			return true;
		}
		if (row.getLastCellNum() <= 0) {
			return true;
		}
		for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
			Cell cell = row.getCell(cellNum, Row.CREATE_NULL_AS_BLANK);
			if (cell == null
					|| (cell != null && (StringUtils.isBlank(cell.toString()) || cell
							.getCellType() == Cell.CELL_TYPE_FORMULA))) {
				emptyCell++;
			}
		}
		if (emptyCell == row.getLastCellNum()) {
			return true;
		}
		return false;
	}
	
	public static List<String>  getHeader(Row headerRow) {
		List<String> headers = new ArrayList<String>();
		Iterator<Cell> cellIterator = headerRow.cellIterator();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			String h = cell.getStringCellValue();
			if (!StringUtils.isEmpty(h)) {
				headers.add(h.toLowerCase().trim().replace(" ", ""));
			}
		}
		return headers;
	}
	
	/**
	 * Return all cell values as String
	 */
	public static String getCellValue(Cell cell) {
		String value = "";
		
		switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				value = String.valueOf(cell.getNumericCellValue());
				break;
			
			case Cell.CELL_TYPE_STRING:
				value = cell.getStringCellValue();
				break;
				
			default:
			break;
		}
		
		return value;
	}
	
	
}
