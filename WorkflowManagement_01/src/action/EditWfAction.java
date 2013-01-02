package action;

import java.util.ArrayList;
import java.util.List;

import model.WorkflowMaster;

import com.opensymphony.xwork2.ActionSupport;

public class EditWfAction extends ActionSupport {

	private int workflowID;
	private String workflowName;
	private String workflowDescription;
	private String workflowDomain;
	private List<String> domainList;
	
	public EditWfAction(){
		domainList=new ArrayList<String>();
		domainList.add("IT_Project");
		domainList.add("Manufacturing");
		domainList.add("Delivery");
		domainList.add("E_Gov");
	}

	public String execute() {
		ArrayList<WorkflowMaster> result = WorkflowMaster.find("where w_id="
				+ this.getWorkflowID());
		WorkflowMaster masterUpdate = result.get(0);
		this.setWorkflowName(masterUpdate.getWorkflowName());
		this.setWorkflowDescription(masterUpdate.getWorkflowDescription());
		this.setWorkflowDomain(masterUpdate.getWorkflowDomain());
		return "displayform";
	}

	public String saveChanges() {
		WorkflowMaster masterUpdate = new WorkflowMaster(
				this.getWorkflowName(), this.getWorkflowDescription(),
				this.getWorkflowDomain(),"N");
		masterUpdate.setWorkflowID(this.getWorkflowID());
		if (masterUpdate.update() != 0) {
			addActionMessage(getText("Workflow Updated Successfully"));
			return "success";
		} else {
			addActionError(getText("Could not update workflow. Contact System Admin"));
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

}
