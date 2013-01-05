package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import utility.DBService;
import utility.DBobjects;
import utility.MySqlConnection;

public class Item {
	
	private int itemID;
	private String itemName;
	private String itemDescription;
	private int currentStageID;
	private String remarks;
	private String filePath;
	private String tableName;
	
	public Item(){
		
	}
	
			
	public Item(int itemID, String itemName, String itemDescription,
			int currentStageID, String remarks, String filePath) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.currentStageID = currentStageID;
		this.remarks = remarks;
		this.filePath = filePath;
	}


	public Item(String itemName, String itemDescription, int currentStageID,
			String remarks, String filePath) {
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.currentStageID = currentStageID;
		this.remarks = remarks;
		this.filePath = filePath;
	}
	
	public static ArrayList<Item> find(String tableName/*int w_id*/, String whereClause) {
		ResultSet result = null;
		ArrayList<Item> objItemList = new ArrayList<Item>();
		DBobjects dbObject=null;
		
		/*String tableName="item";
		ResultSet resultTableName = null;
		String selectQueryTable=null;
		String whereClauseTable=null;
		
		
		
		selectQueryTable = "SELECT table_suffix FROM workflow_master ";
		whereClauseTable = "where w_id = "+w_id;
		
		
		try {
			dbObject = DBService.dbExecuteQuery(selectQueryTable, whereClauseTable);
			resultTableName=dbObject.getResult();
			while (resultTableName.next()) {
				tableName = tableName+resultTableName.getString(1);
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		String selectQuery = "SELECT `item_id`, `item_name`, `item_description`, `current_stage_id`, `remarks`, `file_path` FROM "+tableName;

		try {
			dbObject = DBService.dbExecuteQuery(selectQuery, whereClause);
			result=dbObject.getResult();
			while (result.next()) {
				Item newItem = new Item();
				newItem.setItemID(result.getInt("item_id"));
				newItem.setItemName(result.getString("item_name"));
				newItem.setItemDescription(result.getString("item_description"));
				newItem.setCurrentStageID(result.getInt("current_stage_id"));
				newItem.setRemarks(result.getString("remarks"));
				newItem.setFilePath(result.getString("file_path"));
				objItemList.add(newItem);
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return objItemList;

	}
	
	
	public int update(String tableName) {
		/*
		String tableName="item";
		ResultSet resultTableName = null;
		String selectQueryTable=null;
		String whereClauseTable=null;
		DBobjects dbObject=null;
		
		selectQueryTable = "SELECT table_suffix FROM workflow_master ";
		whereClauseTable = "where w_id = "+w_id;
		
		
		try {
			dbObject = DBService.dbExecuteQuery(selectQueryTable, whereClauseTable);
			resultTableName=dbObject.getResult();
			while (resultTableName.next()) {
				tableName = tableName+resultTableName.getString(1);
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		String updateSQL = "UPDATE "+tableName+" SET item_name='"
				+ this.getItemName() + "' , item_description='"
				+ this.getItemDescription() + "' ,current_stage_id="
				+ this.getCurrentStageID() + " ,remarks='"
						+ this.getRemarks() + "' ,file_path='" +this.getFilePath()+
								"' WHERE item_id=" +this.getItemID();
		System.out.println("update :\n"+updateSQL);
		return DBService.DDLQueryInDB(updateSQL);
	}
	
	
	public static int insertInDB(Item newItem,int w_id){
		int result;
		Connection conn=null;
		PreparedStatement pst = null;
		String tableName="item";
		String tableSuffix=null;
		ResultSet resultTableName = null;
		int stage_id=0;
		String insertQuery=null;
		String selectQueryTable=null;
		String whereClauseTable=null;
		DBobjects dbObject=null;
		
		selectQueryTable = "SELECT table_suffix FROM workflow_master ";
		whereClauseTable = "where w_id = "+w_id;
		
		
		try {
			dbObject = DBService.dbExecuteQuery(selectQueryTable, whereClauseTable);
			resultTableName=dbObject.getResult();
			while (resultTableName.next()) {
				tableSuffix = resultTableName.getString(1);
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("values="+w_id+"-"+tableSuffix);
		tableName=tableName+tableSuffix;
		
		selectQueryTable = "SELECT stage_id FROM workflow"+tableSuffix;
		whereClauseTable = "where w_id = "+w_id+" HAVING MIN(stage_seqno)";
		
		
		try {
			dbObject = DBService.dbExecuteQuery(selectQueryTable, whereClauseTable);
			resultTableName=dbObject.getResult();
			while (resultTableName.next()) {
				stage_id = resultTableName.getInt(1);
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		insertQuery="INSERT INTO `" +
				tableName +
				"`( `item_name`, `item_description`, `current_stage_id`, `remarks`, `file_path`) VALUES (?,?,?,?,?)";
		
		
		System.out.println("insert\n"+insertQuery);
		try {
			conn= new MySqlConnection().getConnection();
			pst=conn.prepareStatement(insertQuery);
			pst.setString(1, newItem.getItemName());
			pst.setString(2, newItem.getItemDescription());
			pst.setInt(3,stage_id);
			pst.setString(4,newItem.getRemarks());
			pst.setString(5,newItem.getFilePath());
			
			result = pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			result =0;
		}
		return result;
	}
	
	public String itemName(int itemID,String tableName,String whereClause){
		ResultSet result = null;
		DBobjects dbObject=null;
		String itemName=null;
		String selectQuery = "SELECT `item_name` FROM "+tableName;

		try {
			dbObject = DBService.dbExecuteQuery(selectQuery, whereClause);
			result=dbObject.getResult();
			while (result.next()) {
				itemName=result.getString("item_name");
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return itemName;		
	}


	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public int getCurrentStageID() {
		return currentStageID;
	}
	public void setCurrentStageID(int currentStageID) {
		this.currentStageID = currentStageID;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	

}
