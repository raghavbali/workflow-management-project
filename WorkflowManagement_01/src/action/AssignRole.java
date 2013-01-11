package action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import utility.DBService;
import utility.DBobjects;

import model.UserRole;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AssignRole extends ActionSupport {

	String user_id, username, password, p_id, w_id, role, active_flag;
	String selected_wf, selected_role;
	ArrayList<UserRole> usrlist;
	ArrayList<String> wfList, roleList;
	ResultSet result;
	private String pageName, workflowName;
	private int workflowID;
	Map<String, Object> session;

	public AssignRole() {
		
	}
	
	public void populateLists()
	{
		session = ActionContext.getContext().getSession();
		wfList = new ArrayList<String>();
		roleList = new ArrayList<String>();
		this.setWorkflowID(Integer.parseInt(session.get("workflowID").toString()));
		String wfquery;
		if(pageName.equals("AdminConsole")){
			if(session.get("tableSuffix").toString().equals("_00000000000000")){
				wfquery = "SELECT workflow_name FROM workflow_master WHERE table_suffix <> '_00000000000000'";
				roleList.add("admin");
			}
			else
				wfquery = "SELECT workflow_name FROM workflow_master WHERE w_id='" + this.workflowID + "'";
		}
		else
			wfquery = "SELECT workflow_name FROM workflow_master WHERE w_id='" + this.workflowID + "'";
//		System.out.println(wfquery);
		DBobjects dbObject = null;
		// String wfwhere = "WHERE freeze = 'N'";

		try {
			dbObject = DBService.dbExecuteQuery(wfquery, "");
			result = dbObject.getResult();
			while (result.next()) {
				wfList.add(result.getString("workflow_name"));
			}
			dbObject.getConn().close();
		} catch (Exception ex) {
			System.out.println("Exception caught: " + ex);
		}
//		System.out.println(pageName);
		if(pageName.equals("AdminConsole"))
		{
			roleList.add("editor");
		}
		roleList.add("publisher");
		roleList.add("author");
	}


	public String execute() {
//		System.out.println(workflowID);
		if(pageName.equals("EditorConsole"))
			workflowName = getWfNamefromDB(String.valueOf(workflowID));
		populateLists();
		usrlist = DBService.getUserRoleList(p_id);
		if (usrlist.size() == 0)
			addActionError(getText("No roles for selected user."));
		return "seeUserDetails";
	}

	public String addRole() {
		user_id = String.valueOf(DBService.generate_userid());
		active_flag = String.valueOf(1);
		w_id = String.valueOf(getW_idfromDB(selected_wf));
		UserRole tmpusr = new UserRole(user_id, username, password, p_id, w_id, selected_role, active_flag);
		String insertQuery = "INSERT INTO `login_credentials`(`user_id`, `username`, `password`, `p_id`, `w_id`, `role`, `active_flag`) VALUES (?,?,?,?,?,?,?)";
		ArrayList<String> values = new ArrayList<String>();
		values.add(tmpusr.getUser_id());
		values.add(tmpusr.getUsername());
		values.add(tmpusr.getPassword());
		values.add(tmpusr.getP_id());
		values.add(tmpusr.getW_id());
		values.add(tmpusr.getRole());
		values.add(tmpusr.getActive_flag());

		int result = DBService.insertObjectInDB(insertQuery, values);
		usrlist = DBService.getUserRoleList(p_id);
		if(pageName.equals("EditorConsole"))
			workflowName = getWfNamefromDB(String.valueOf(workflowID));
		populateLists();

		if (result == 0) {
			addActionError(getText("Some error, please re-chech the field values."));
			return "error";
		} else {
			addActionMessage(getText("User Role added successfully."));
			return "addrole_continue";
		}
	}
	
	public String getWfNamefromDB(String W_id){
		String wfquery = "SELECT workflow_name FROM workflow_master";
		String wfwhere = "WHERE w_id = '" + W_id + "'";
		String WfName = null;
		DBobjects dbObject;	
		try{
			dbObject = DBService.dbExecuteQuery(wfquery,wfwhere);
			result=dbObject.getResult();
		while(result.next()){
			WfName = result.getString("workflow_name");
		}
		dbObject.getConn().close();
		}catch(Exception ex){
			System.out.println("Exception caught: " + ex);
		}
		return WfName;
	}

	public int getW_idfromDB(String WName) {
		String wfquery = "SELECT w_id FROM workflow_master";
		String wfwhere = "WHERE workflow_name = '" + WName + "'";
		int w_id = -1;
		DBobjects dbObject = null;

		try {
			dbObject = DBService.dbExecuteQuery(wfquery, wfwhere);
			result = dbObject.getResult();
			while (result.next()) {
				w_id = result.getInt("w_id");
			}
			dbObject.getConn().close();
		} catch (Exception ex) {
			System.out.println("Exception caught: " + ex);
		}
		return w_id;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getW_id() {
		return w_id;
	}

	public void setW_id(String w_id) {
		this.w_id = w_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getActive_flag() {
		return active_flag;
	}

	public void setActive_flag(String active_flag) {
		this.active_flag = active_flag;
	}

	public ArrayList<UserRole> getUsrlist() {
		return usrlist;
	}

	public void setUsrlist(ArrayList<UserRole> usrlist) {
		this.usrlist = usrlist;
	}

	public ArrayList<String> getWfList() {
		return wfList;
	}

	public void setWfList(ArrayList<String> wfList) {
		this.wfList = wfList;
	}

	public ArrayList<String> getRoleList() {
		return roleList;
	}

	public void setRoleList(ArrayList<String> roleList) {
		this.roleList = roleList;
	}

	public String getSelected_wf() {
		return selected_wf;
	}

	public void setSelected_wf(String selected_wf) {
		this.selected_wf = selected_wf;
	}

	public String getSelected_role() {
		return selected_role;
	}

	public void setSelected_role(String selected_role) {
		this.selected_role = selected_role;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
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

}
