package com.bluesoft.resources;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bluesoft.entities.System;
import com.bluesoft.entities.SystemContract;

public class XMLReader {

	public static void readXLSXFile(InputStream fileToRead) throws IOException {
		InputStream ExcelFileToRead = fileToRead;
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

		XSSFWorkbook test = new XSSFWorkbook();

		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();
		int index = 0;
		List<Object> labels;
		List<SystemContract> systems = new ArrayList<SystemContract>();
		List<System> systemT = new ArrayList<System>();

		while (rows.hasNext()) {
			SystemContract systemContract = new SystemContract();

			row = (XSSFRow) rows.next();
			Iterator<Cell> cells = row.cellIterator();

			String name = "";
			if (row.getRowNum() == 0) {
				continue;
			}
			while (cells.hasNext()) {
				Cell nextCell = cells.next();
				int columnIndex = nextCell.getColumnIndex();

				switch (columnIndex) {
				case 0:
					int randId = new Random().nextInt(5000 + 1);
					System system = new System(randId);
					systemT.add(system);
					system.setName((String) getCellValue(nextCell, false));
					// name = (String) getCellValue(nextCell,false);
					// system.setId(randId);
					systemContract.setId(randId + 1);
					systemContract.setSystem(system);
					break;
				case 1:
					systemContract.setRequest(String.valueOf(getCellValue(nextCell, false)));
					break;
				case 2:
					systemContract.setOrderNumber((String) getCellValue(nextCell, false));
					break;
				case 3:
					Object fromDate = getCellValue(nextCell, true);
					// Object dateFor = new Date((long) date).toString();
					systemContract.setFromDate((Date) fromDate);
					break;
				case 4:
					Object toDate = getCellValue(nextCell, true);
					systemContract.setToDate((Date) toDate);
					break;
				case 5:
					Object amountObj = getCellValue(nextCell, false);
					// double value = Double.parseDouble((String) amount);
					BigDecimal bdec = new BigDecimal((String) amountObj);
					systemContract.setAmount(bdec);
					break;
				case 6:
					systemContract.setAmountType((String) getCellValue(nextCell, false));
					break;
				case 7:
					systemContract.setAmountPeriod((String) getCellValue(nextCell, false));
					break;
				case 8:
					Object authObj = getCellValue(nextCell, false);
					BigDecimal authBigDec = new BigDecimal((Double) authObj);
					systemContract.setAuthorizationPercent(authBigDec);
					break;
				case 9:
					systemContract.setActive(Boolean.valueOf((String) getCellValue(nextCell, false)));
					break;
				}

			}

			systems.add(systemContract);
		}
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		for (System sysContr : systemT) {
			session.save(sysContr);
		}
		for (SystemContract sysContr : systems) {
			session.save(sysContr);
		}
		session.getTransaction().commit();
		session.close();
	}

	private static Object getCellValue(Cell cell, boolean date) {
		int type = cell.getCellType();
		switch (type) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();

		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();

		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				java.util.Date dateFormat = cell.getDateCellValue();
				return dateFormat;
			}
			return cell.getNumericCellValue();

		}

		return null;
	}
}
