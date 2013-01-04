package action;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import utility.DBService;
import utility.WorkflowDBService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.*;

public class CreateWfAction extends ActionSupport {

	private int wf_id;
	private String wf_name;
	private String wf_description;
	private String wf_domain;
	private Map<String, Object> session;
	public List<String> domainList;

	public CreateWfAction() {
		System.out.println("inside constructor");
		domainList = new ArrayList<String>();
		domainList.add("IT_Project");
		domainList.add("Manufacturing");
		domainList.add("Delivery");
		domainList.add("E_Gov");
		
	}

	public String execute() {
		WorkflowMaster objWorkflow = new WorkflowMaster(this.getWf_name(),
				this.getWf_description(), this.getWf_domain(),"N"/* , null */);// update
																			// this
																			// null
																			// value

		session = ActionContext.getContext().getSession();
		ArrayList<String> values = new ArrayList<String>();
		ResultSet result = null;
		int count = 0;
		Date dNow = new Date();
		String suffix = null;
		SimpleDateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");

		String insertQuery = "INSERT INTO `workflow_master`(`w_id`,`workflow_name`,"
				+ " `workflow_description`, `workflow_domain`, `table_suffix`,`freeze`) "
				+ " VALUES ( ? ,? , ? , ? , ?, ? )";
		this.setWf_id(DBService.generate_wid());
/*
  		String tableCount = "SELECT count(*) as tbCount FROM information_schema.tables ";
		String whereClause = "WHERE table_schema ='workflow_mgmt_sys'";
		try {
			result = DBService.dbExecuteQuery(tableCount, whereClause);
			while (result.next()) {
				count = result.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
*/
		suffix = "_" + ft.format(dNow).toString();// + "_" + (count-3);
		values.add(String.valueOf(this.getWf_id()));
		values.add(objWorkflow.getWorkflowName());
		values.add(objWorkflow.getWorkflowDescription());
		values.add(objWorkflow.getWorkflowDomain());
		values.add(suffix);
		values.add("N");
		int result1 = DBService.insertObjectInDB(insertQuery, values);

		if (result1 == 0) {
			addActionError(getText("Could not create new workflow. Contact System Admin."));
			return "error";
		} else {
			session.put("workflowID", this.getWf_id());
			System.out.println("just before gen tbles");
			if (generateTables(suffix) == 1){
				addActionMessage(getText("Workflow tables created Successfully"));
				return "createwf_continue";
			}
			else {
				addActionError(getText("Table creation failed. Contact System Admin"));
				return "error";
			}
		}

	}

	private int generateTables(String suffix) {

		String workflow_table = "workflow" + suffix;
		String stage_table = "stage" + suffix;
		String item_table = "item" + suffix;
		String lead_bucket = "leader_bucket" + suffix;
		String general_bucket = "general_bucket" + suffix;

		try {
			if (WorkflowDBService.createTables(workflow_table, stage_table,
					item_table, lead_bucket, general_bucket) == 1)
				return 1;// success
			else
				return 0;// error

		} catch (Exception e) {
			e.printStackTrace();
			return 0;// error
		}
	}

	public String getWf_name() {
		return wf_name;
	}

	public void setWf_name(String wf_name) {
		this.wf_name = wf_name;
	}

	public String getWf_description() {
		return wf_description;
	}

	public void setWf_description(String wf_description) {
		this.wf_description = wf_description;
	}

	public String getWf_domain() {
		return wf_domain;
	}

	public void setWf_domain(String wf_domain) {
		this.wf_domain = wf_domain;
	}

	public List<String> getDomainList() {
		return domainList;
	}

	public void setDomainList(List<String> domainList) {
		this.domainList = domainList;
	}

	public int getWf_id() {
		return wf_id;
	}

	public void setWf_id(int wf_id) {
		this.wf_id = wf_id;
	}

}
