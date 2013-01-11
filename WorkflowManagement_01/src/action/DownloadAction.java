package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
//import org.apache.tomcat.util.http.parser.ParseException;

import utility.DBService;
import utility.DBobjects;
import utility.POIExcelUtility;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction /* extends ActionSupport */{

	private InputStream fileInputStream;
	String filename;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public InputStream getFileInputStream() {

		return fileInputStream;

	}

	public String missingSLA(String tableSuffix) {

		try {
			InputStream inputStream = new FileInputStream(
					"G:\\Output\\SLA-Template.xls");
			POIFSFileSystem fileSystem = new POIFSFileSystem(inputStream);

			HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);

			HSSFSheet sheet1 = workBook.getSheetAt(0);

			String selectQuery = "SELECT l.stage_id as stage_id,w.stage_name as stage_name,count(l.user_id) as stage_count,DATEDIFF(delivery_date,SYSDATE()) as dt "
					+ " FROM leader_bucket"
					+ tableSuffix
					+ " l,workflow"
					+ tableSuffix + " w ";
			String whereClause = " WHERE l.stage_id=w.stage_id "
					+ " GROUP BY l.stage_id ,w.stage_name ";
			/* + " HAVING dt<0"; */
			ResultSet result = null;
			DBobjects dbObject = null;
			int stageID = 0;
			int stageCount = 0;
			int dtVal = 0;
			String StageName = null;

			try {
				dbObject = DBService.dbExecuteQuery(selectQuery, whereClause);
				result = dbObject.getResult();
				int startRow = 1;
				while (result.next()) {
					stageID = result.getInt("stage_id");
					stageCount = result.getInt("stage_count");
					dtVal = result.getInt("dt");
					StageName = result.getString("stage_name");

					POIExcelUtility.writeXl(sheet1, startRow, 1,
							(double) (stageID));
					POIExcelUtility.writeXl(sheet1, startRow, 2, StageName);

					POIExcelUtility.writeXl(sheet1, startRow, 7,
							(double) (stageID));
					POIExcelUtility.writeXl(sheet1, startRow, 8, StageName);

					if (dtVal < 0) {
						POIExcelUtility.writeXl(sheet1, startRow, 3,
								(double) (stageCount));
						POIExcelUtility.writeXl(sheet1, startRow, 9,
								(double) (0));
					} else {
						POIExcelUtility.writeXl(sheet1, startRow, 3,
								(double) (0));
						POIExcelUtility.writeXl(sheet1, startRow, 9,
								(double) (stageCount));
					}

					startRow++;

				}
				dbObject.getConn().close();
				filename = "sla_report" + new Date().getTime() + ".xls";
				FileOutputStream fileOut1 = new FileOutputStream(
						"G:\\WorkflowReports\\" + filename);
				workBook.write(fileOut1);
				fileOut1.close();
				return "success";

			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";

		}

	}
	
	

	public String itemsPerStage(String tableSuffix) {

		try {
			InputStream inputStream = new FileInputStream(
					"G:\\Output\\itemsPerStage-Template.xls");
			POIFSFileSystem fileSystem = new POIFSFileSystem(inputStream);

			HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);

			HSSFSheet sheet1 = workBook.getSheetAt(0);

			String selectQuery = "SELECT count(item_id) as item_count, s.stage_name as stage_name "
					+ " FROM item"
					+ tableSuffix
					+ " i,workflow"
					+ tableSuffix + " s ";
			String whereClause = " WHERE i.current_stage_id=s.stage_id "
					+ " GROUP BY s.stage_id,s.stage_name ";
			ResultSet result = null;
			DBobjects dbObject = null;
			int itemCount = 0;
			String StageName = null;

			try {
				dbObject = DBService.dbExecuteQuery(selectQuery, whereClause);
				result = dbObject.getResult();
				int startRow = 1;
				while (result.next()) {
					itemCount = result.getInt("item_count");
					StageName = result.getString("stage_name");

					POIExcelUtility.writeXl(sheet1, startRow, 2,
							(double) (itemCount));
					POIExcelUtility.writeXl(sheet1, startRow, 1, StageName);

					startRow++;

				}
				dbObject.getConn().close();
				filename = "items_per_stage" + new Date().getTime() + ".xls";
				FileOutputStream fileOut1 = new FileOutputStream(
						"G:\\WorkflowReports\\" + filename);
				workBook.write(fileOut1);
				fileOut1.close();
				return "success";

			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";

		}

	}
	
	
	public String resourceChart(int w_id) {

		try {
			InputStream inputStream = new FileInputStream(
					"G:\\Output\\ResourceAllocation-Template.xls");
			POIFSFileSystem fileSystem = new POIFSFileSystem(inputStream);

			HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);

			HSSFSheet sheet1 = workBook.getSheetAt(0);

			String selectQuery = "SELECT role,count(user_id) as user_count "
					+ " FROM login_credentials ";
			String whereClause = " WHERE w_id="+w_id
					+ " GROUP BY role ORDER BY role DESC";
			ResultSet result = null;
			DBobjects dbObject = null;
			int userCount = 0;
			String role = null;

			try {
				dbObject = DBService.dbExecuteQuery(selectQuery, whereClause);
				result = dbObject.getResult();
				int startRow = 1;
				while (result.next()) {
					userCount = result.getInt("user_count");
					role = result.getString("role");

					POIExcelUtility.writeXl(sheet1, startRow, 2,
							(double) (userCount));
					POIExcelUtility.writeXl(sheet1, startRow, 1, role);

					startRow++;

				}
				dbObject.getConn().close();
				filename = "resource_allocation_" + new Date().getTime() + ".xls";
				FileOutputStream fileOut1 = new FileOutputStream(
						"G:\\WorkflowReports\\" + filename);
				workBook.write(fileOut1);
				fileOut1.close();
				return "success";

			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";

		}

	}

	
	

}