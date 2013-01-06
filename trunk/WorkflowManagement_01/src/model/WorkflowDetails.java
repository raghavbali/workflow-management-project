package model;

import java.sql.ResultSet;
import java.util.ArrayList;

import utility.DBService;
import utility.DBobjects;

public class WorkflowDetails {
	
	private int stageID;
	private String stageName;
	private String stageDescription;
	private int stageSLA;
	private int stageSequenceNo;
	private int stageLeadID;
	private int wfId;
	private String tableName;
	
	
	public WorkflowDetails(){
		
	}
	
	public WorkflowDetails(String stageName,
			String stageDescription, int stageSLA, int stageSequenceNo,int wfId) {
		//this.stageId = stageId;
		this.stageName = stageName;
		this.stageDescription = stageDescription;
		this.stageSLA = stageSLA;
		this.stageSequenceNo = stageSequenceNo;
		this.wfId = wfId;
	}
	
	public static ArrayList<WorkflowDetails> find(int w_id, String whereClause) {
		ResultSet result = null;
		ArrayList<WorkflowDetails> objWfDetails = new ArrayList<WorkflowDetails>();
		String tableName="workflow";
		ResultSet resultTableName = null;
		String selectQueryTable=null;
		String whereClauseTable=null;
		DBobjects dbObject;
		
		
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
//		String selectQuery = "SELECT `stage_id`, `stage_name`, `stage_description`, `stage_sla`, `stage_seqno`, `w_id` FROM "+tableName;
		String selectQuery = "SELECT `stage_id`, `stage_name`, `stage_description`, `stage_sla`, `stage_seqno`, `stage_lead_id`, `w_id` FROM "+tableName;
		
		try {
			dbObject = DBService.dbExecuteQuery(selectQuery, whereClause);
			result=dbObject.getResult();
			while (result.next()) {
				WorkflowDetails newWorkFlowDetails = new WorkflowDetails();
				newWorkFlowDetails.setStageID(result.getInt("stage_id"));
				newWorkFlowDetails.setStageName(result.getString("stage_name"));
				newWorkFlowDetails.setStageDescription(result.getString("stage_description"));
				newWorkFlowDetails.setStageSLA(result.getInt("stage_sla"));
				newWorkFlowDetails.setStageSequenceNo(result.getInt("stage_seqno"));
				newWorkFlowDetails.setStageLeadID(result.getInt("stage_lead_id"));
				newWorkFlowDetails.setWfId(result.getInt("w_id"));
				newWorkFlowDetails.setTableName(tableName);
				objWfDetails.add(newWorkFlowDetails);
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return objWfDetails;

	}
	
	
	public int update(String tableName) {
		String updateSQL = "UPDATE workflow"+tableName+" SET stage_name='"
				+ this.getStageName() + "' , stage_description='"
				+ this.getStageDescription() + "' ,stage_sla="
				+ this.getStageSLA() + " ,stage_seqno="
						+ this.getStageSequenceNo() + " WHERE w_id=" +this.getWfId()+
								" and stage_id="+this.getStageID();
		System.out.println("update :\n"+updateSQL);
		return DBService.DDLQueryInDB(updateSQL);
	}
	
	public static void updateLead(int w_id, int lead_id, int stage_id){
		String tableName="workflow";
		ResultSet resultTableName = null;
		String selectQueryTable=null;
		String whereClauseTable=null;
		DBobjects dbObject;
		
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
		
		String updateQuery = "UPDATE " + tableName + " SET stage_lead_id = '" + lead_id + "' WHERE stage_id = '" + stage_id + "'" ;
		DBService.DDLQueryInDB(updateQuery);
	}
	
	public int getStageID() {
		return stageID;
	}
	public void setStageID(int stageID) {
		this.stageID = stageID;
	}
	public String getStageName() {
		return stageName;
	}
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	public String getStageDescription() {
		return stageDescription;
	}
	public void setStageDescription(String stageDescription) {
		this.stageDescription = stageDescription;
	}
	public int getStageSLA() {
		return stageSLA;
	}
	public void setStageSLA(int stageSLA) {
		this.stageSLA = stageSLA;
	}
	public int getStageSequenceNo() {
		return stageSequenceNo;
	}
	public void setStageSequenceNo(int stageSequenceNo) {
		this.stageSequenceNo = stageSequenceNo;
	}
	
	public int getWfId() {
		return wfId;
	}
	public void setWfId(int wfId) {
		this.wfId = wfId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getStageLeadID() {
		return stageLeadID;
	}

	public void setStageLeadID(int stageLeadID) {
		this.stageLeadID = stageLeadID;
	}
	
}
