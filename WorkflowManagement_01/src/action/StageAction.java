package action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import model.WorkflowDetails;
import model.WorkflowMaster;

import utility.DBService;
import utility.DBobjects;
import utility.WorkflowDBService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StageAction extends ActionSupport {

	private int stageID;
	private String stageName;
	private String stageDescription;
	private int stageSLA;
	private int stageSequenceNo;
	private int workflowID;
	private String workflow;
	private Map<String, Object> session;
	private WorkflowDetails objWorkflowDetails;
	private String table_suffix;

	private ArrayList<WorkflowMaster> objListWfMaster;

	public StageAction() {
	}

	public StageAction(int stageId, String stageName, String stageDescription,
			int stageSLA, int stageSequenceNo, int wfId) {
		this.stageID = stageId;
		this.stageName = stageName;
		this.stageDescription = stageDescription;
		this.stageSLA = stageSLA;
		this.stageSequenceNo = stageSequenceNo;
		this.workflowID = wfId;
	}

	public String addLater() {
		return "later";
	}
	
	public void loadWorkflowList(){
		String whereClause=null;
		
		session = ActionContext.getContext().getSession();
		
		if(session.get("tableSuffix").toString().equalsIgnoreCase("_00000000000000"))
			this.objListWfMaster = WorkflowMaster.find(" WHERE w.w_id<>1");
		else{
			whereClause=",login_credentials l WHERE w.w_id=l.w_id and l.user_id="+Integer.parseInt(session.get("userID").toString());
			this.objListWfMaster=WorkflowMaster.find(whereClause);
		}
		if (this.objListWfMaster != null)
			addActionMessage(getText("Workflow list generated."));
		else
			addActionError(getText("No workflows Available."));
	}

	public String done() {
		loadWorkflowList();
		return "done";
	}

	public String execute() {
		/*
		session = ActionContext.getContext().getSession();
		session.put("workflow", this.workflow);*/
		return "success";
	}

	public String updateNow() {
		try {
			setParamsNoCookie();
			this.objWorkflowDetails = new WorkflowDetails(this.getStageName(),
					this.getStageDescription(), this.getStageSLA(),
					this.getStageSequenceNo(), this.getWorkflowID());
			this.objWorkflowDetails.setStageID(this.getStageID());
			this.objWorkflowDetails.update(this.table_suffix);
			addActionMessage(getText("Stage Updated Successfully"));
			loadWorkflowList();
			return "updateSuccess";
		} catch (Exception e) {
			addActionError(getText("Could not update stage. Check the data entered and try again"));
			return "updateError";
		}
	}

	public String addNow() {

		//setParams();
		System.out.println("stageAction values addnow "+this.getWorkflowID());
		setParamsNoCookie();

		this.objWorkflowDetails = new WorkflowDetails(this.getStageName(),
				this.getStageDescription(), this.getStageSLA(),
				this.getStageSequenceNo(), this.getWorkflowID());

		ArrayList<String> values = new ArrayList<String>();
		try {
			values.add(this.objWorkflowDetails.getStageName());
			values.add(this.objWorkflowDetails.getStageDescription());
			values.add(this.objWorkflowDetails.getStageSLA() + "");
			values.add(this.objWorkflowDetails.getStageSequenceNo() + "");
			values.add(this.getWorkflowID() + "");

			if (WorkflowDBService.insertObjectInDB("workflow"
					+ this.table_suffix, values) != 0) {
				addActionMessage(getText("Stage Added Successfully"));
				return "success";
			} else {
				addActionError(getText("Could not add stage. Check the data entered and try again"));
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(getText("Could not add stage. Check the data entered and try again"));
			return "error";
		}
	}

	private void setParams() {
		String selectQuery;
		String whereClause;
		ResultSet result = null;
		DBobjects dbObject;

		session = ActionContext.getContext().getSession();

		selectQuery = "SELECT table_suffix,w_id FROM workflow_master ";
		whereClause = "where w_id = "
				+ Integer.parseInt(session.get("workflowID").toString());

		try {
			dbObject = DBService.dbExecuteQuery(selectQuery, whereClause);
			result=dbObject.getResult();
			while (result.next()) {
				this.table_suffix = result.getString(1);
				this.setWorkflowID(result.getInt(2));
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			addActionError(getText("Could not set parameters. Please try again"));
			e.printStackTrace();
		}

	}

	private void setParamsNoCookie() {
		String selectQuery;
		String whereClause;
		ResultSet result = null;
		DBobjects dbObject;

		//session = ActionContext.getContext().getSession();

		selectQuery = "SELECT table_suffix FROM workflow_master ";
		whereClause = "where w_id = " + this.getWorkflowID();

		try {
			 dbObject = DBService.dbExecuteQuery(selectQuery, whereClause);
			 result=dbObject.getResult();
			while (result.next()) {
				this.table_suffix = result.getString(1);
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			addActionError(getText("Could not set parameters. Please try again"));
			e.printStackTrace();
		}

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

	public int getStageID() {
		return stageID;
	}

	public void setStageID(int stageID) {
		this.stageID = stageID;
	}

	public int getWorkflowID() {
		return workflowID;
	}

	public void setWorkflowID(int workflowID) {
		this.workflowID = workflowID;
	}

	public WorkflowDetails getObjWorkflowDetails() {
		return objWorkflowDetails;
	}

	public void setObjWorkflowDetails(WorkflowDetails objWorkflowDetails) {
		this.objWorkflowDetails = objWorkflowDetails;
	}

	public String getTable_suffix() {
		return table_suffix;
	}

	public void setTable_suffix(String table_suffix) {
		this.table_suffix = table_suffix;
	}

	public String getWorkflow() {
		return workflow;
	}

	public void setWorkflow(String workflow) {
		this.workflow = workflow;
	}

	public ArrayList<WorkflowMaster> getObjListWfMaster() {
		return objListWfMaster;
	}

	public void setObjListWfMaster(ArrayList<WorkflowMaster> objListWfMaster) {
		this.objListWfMaster = objListWfMaster;
	}

}
