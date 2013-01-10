package action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import utility.DBService;
import utility.DBobjects;

import model.WorkflowMaster;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditWfAction extends ActionSupport {

	private int workflowID;
	private String workflowName;
	private String workflowDescription;
	private String workflowDomain;
	private String freeze;
	private List<String> domainList;
	private List<String> freezeList;
	private ArrayList<WorkflowMaster> objListWfMaster;
	private Map<String, Object> session;

	public EditWfAction() {
		domainList = new ArrayList<String>();
		domainList.add("IT_Project");
		domainList.add("Manufacturing");
		domainList.add("Delivery");
		domainList.add("E_Gov");

		freezeList = new ArrayList<String>();
		freezeList.add("Y");
		freezeList.add("N");
	}

	public String execute() {
		ArrayList<WorkflowMaster> result = WorkflowMaster.find("where w_id="
				+ this.getWorkflowID());
		WorkflowMaster masterUpdate = result.get(0);
		this.setWorkflowName(masterUpdate.getWorkflowName());
		this.setWorkflowDescription(masterUpdate.getWorkflowDescription());
		this.setWorkflowDomain(masterUpdate.getWorkflowDomain());
		this.setFreeze(masterUpdate.getFreeze());
		return "displayform";
	}

	public String back() {
		return loadList();
	}

	public String saveChanges() {
		WorkflowMaster masterUpdate = new WorkflowMaster(
				this.getWorkflowName(), this.getWorkflowDescription(),
				this.getWorkflowDomain(), this.getFreeze());

		masterUpdate.setWorkflowID(this.getWorkflowID());

		if (masterUpdate.update() != 0) {
			addActionMessage(getText("Workflow Updated Successfully"));
			return loadList();
		} else {
			addActionError(getText("Could not update workflow. Contact System Admin"));
			return loadList();
		}
	}

	public String deleteMaster() {
		WorkflowMaster masterUpdate = new WorkflowMaster(
				this.getWorkflowName(), this.getWorkflowDescription(),
				this.getWorkflowDomain(), this.getFreeze());

		masterUpdate.setWorkflowID(this.getWorkflowID());

		String returnMessage = masterUpdate.delete(getTablePrefix());

		if (returnMessage.equalsIgnoreCase("deleted")) {
			addActionMessage(getText("Workflow Deleted Successfully"));
			return loadList();
		} else {
			addActionError(getText("Hey, you can't delete this, items are being worked upon!"));
			return loadList();
		}

	}

	private String getTablePrefix() {
		String selectQuery;
		String whereClause;
		ResultSet result = null;
		DBobjects dbObject;
		String tableSuffix = null;

		// session = ActionContext.getContext().getSession();

		selectQuery = "SELECT table_suffix FROM workflow_master ";
		whereClause = "where w_id = " + this.getWorkflowID();

		try {
			dbObject = DBService.dbExecuteQuery(selectQuery, whereClause);
			result = dbObject.getResult();
			while (result.next()) {
				tableSuffix = result.getString(1);
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			addActionError(getText("Could not set parameters. Please try again"));
			e.printStackTrace();
		}

		return tableSuffix;
	}

	public String loadList() {
		String whereClause = null;

		session = ActionContext.getContext().getSession();
		if (session.get("tableSuffix").toString()
				.equalsIgnoreCase("_00000000000000")) {
			this.objListWfMaster = WorkflowMaster.find(" WHERE w.w_id<>1");
		} else {
			whereClause = ",login_credentials l WHERE w.w_id=l.w_id and l.user_id="
					+ Integer.parseInt(session.get("userID").toString());
			this.objListWfMaster = WorkflowMaster.find(whereClause);
		}
		if (this.objListWfMaster != null) {
			addActionMessage(getText("Workflow list generated."));
			return "success";
		} else {
			addActionError(getText("No workflows Available."));
			return "error";
		}
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

	public List<String> getDomainList() {
		return domainList;
	}

	public void setDomainList(List<String> domainList) {
		this.domainList = domainList;
	}

	public List<String> getFreezeList() {
		return freezeList;
	}

	public void setFreezeList(List<String> freezeList) {
		this.freezeList = freezeList;
	}

	public String getFreeze() {
		return freeze;
	}

	public void setFreeze(String freeze) {
		this.freeze = freeze;
	}

	public ArrayList<WorkflowMaster> getObjListWfMaster() {
		return objListWfMaster;
	}

	public void setObjListWfMaster(ArrayList<WorkflowMaster> objListWfMaster) {
		this.objListWfMaster = objListWfMaster;
	}

}
