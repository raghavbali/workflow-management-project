package model;

import java.sql.ResultSet;
import java.util.ArrayList;

import utility.DBService;

public class WorkflowMaster {

	private int workflowID;
	private String workflowName;
	private String workflowDescription;
	private String workflowDomain;
	private String tableSuffix;
	private String freeze;

	// private ArrayList<WorkflowDetails> objWorkFlowDetails;

	public WorkflowMaster() {

	}

	public WorkflowMaster(String workflowName, String workflowDescription,
			String workflowDomain,String freeze/*
								 * , ArrayList<WorkflowDetails>
								 * objWorkFlowDetails
								 */) {
		// this.workflowID = workflowID;
		this.workflowName = workflowName;
		this.workflowDescription = workflowDescription;
		this.workflowDomain = workflowDomain;
		this.freeze=freeze;
		// this.objWorkFlowDetails=objWorkFlowDetails;
	}

	public int getWorkflowID() {
		return workflowID;
	}

	public void setWorkflowID(int workflowID) {
		this.workflowID = workflowID;
	}

	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public String getWorkflowDescription() {
		return workflowDescription;
	}

	public void setWorkflowDescription(String workflowDescription) {
		this.workflowDescription = workflowDescription;
	}

	public String getWorkflowDomain() {
		return workflowDomain;
	}

	public void setWorkflowDomain(String workflowDomain) {
		this.workflowDomain = workflowDomain;
	}

	public String getTableSuffix() {
		return tableSuffix;
	}

	public void setTableSuffix(String tableSuffix) {
		this.tableSuffix = tableSuffix;
	}

	public String getFreeze() {
		return freeze;
	}

	public void setFreeze(String freeze) {
		this.freeze = freeze;
	}

	public static ArrayList<WorkflowMaster> find(String whereClause) {
		ResultSet result = null;
		ArrayList<WorkflowMaster> objWfMaster = new ArrayList<WorkflowMaster>();
		String selectQuery = "SELECT `w_id`, `workflow_name`, `workflow_description`, `workflow_domain`, `table_suffix`,`freeze` FROM workflow_master ";

		try {
			result = DBService.dbExecuteQuery(selectQuery, whereClause);
			while (result.next()) {
				WorkflowMaster newWorkFlow = new WorkflowMaster();
				newWorkFlow.setWorkflowID(result.getInt("w_id"));
				newWorkFlow.setWorkflowName(result.getString("workflow_name"));
				newWorkFlow.setWorkflowDescription(result
						.getString("workflow_description"));
				newWorkFlow.setWorkflowDomain(result
						.getString("workflow_domain"));
				newWorkFlow.setTableSuffix(result.getString("table_suffix"));
				newWorkFlow.setFreeze(result.getString("freeze"));
				objWfMaster.add(newWorkFlow);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return objWfMaster;

	}

	public int update() {
		String updateSQL = "UPDATE workflow_master SET workflow_name='"
				+ this.getWorkflowName() + "' , workflow_description='"
				+ this.getWorkflowDescription() + "' ,workflow_domain='"
				+ this.getWorkflowDomain() + "', freeze= WHERE w_id="
				+ this.getWorkflowID();
		System.out.println("update :\n"+updateSQL);
		return DBService.DDLQueryInDB(updateSQL);
	}
	/*
	 * public ArrayList<WorkflowDetails> getObjWorkFlowDetails() { return
	 * objWorkFlowDetails; } public void
	 * setObjWorkFlowDetails(ArrayList<WorkflowDetails> objWorkFlowDetails) {
	 * this.objWorkFlowDetails = objWorkFlowDetails; }
	 */
}