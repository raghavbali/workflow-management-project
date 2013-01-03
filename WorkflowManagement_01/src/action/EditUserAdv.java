package action;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.UserRole;

import utility.DBService;
import utility.DBobjects;

import com.opensymphony.xwork2.ActionSupport;

public class EditUserAdv extends ActionSupport {
	String user_id, username, password, p_id, w_id, role, active_flag; 
	String selected_wf, selected_role, selected_actstate;
	ArrayList<String> wfList, roleList, actstateList;
	ResultSet result;
	UserRole tmpuser = new UserRole();
	
	public EditUserAdv(){
		wfList = new ArrayList<String>();
		roleList = new ArrayList<String>();
		actstateList = new ArrayList<String>();
		String wfquery = "SELECT workflow_name FROM workflow_master";
		DBobjects dbObject;
//		String wfwhere = "WHERE freeze = 'N'";
			
		try{
			dbObject = DBService.dbExecuteQuery(wfquery,"");
			result=dbObject.getResult();
		while(result.next()){
			wfList.add(result.getString("workflow_name"));
		}
		dbObject.getConn().close();
		}catch(Exception ex){
			System.out.println("Exception caught: " + ex);
		}
		
		roleList.add("admin");
		roleList.add("author");
		roleList.add("publisher");
		roleList.add("editor");
		
		actstateList.add("0");
		actstateList.add("1");
	}
	
	public String execute(){
		String selectQuery = "SELECT * FROM `login_credentials`";
		String whereClause = "WHERE user_id = '" + user_id + "'";
		ResultSet result = null;
		DBobjects dbObject;
		try{
			
			dbObject=DBService.dbExecuteQuery(selectQuery, whereClause);
			result=dbObject.getResult();
			while(result.next()){
				tmpuser.setUser_id(result.getString("user_id"));
				tmpuser.setUsername(result.getString("username"));
				tmpuser.setPassword(result.getString("password"));
				tmpuser.setP_id(result.getString("p_id"));
				tmpuser.setW_id(getWfNamefromDB(result.getString("w_id")));
				tmpuser.setRole(result.getString("role"));
				tmpuser.setActive_flag(result.getString("active_flag"));
			}
			dbObject.getConn().close();
			}catch(Exception ex){
				System.out.println("Excption caught: " + ex);
			}
			
			return "edit_user_adv_success";
		}
	
	public String update(){
		tmpuser = new UserRole(user_id, username, password, p_id, String.valueOf(getW_idfromDB(w_id)), role, active_flag);
		String updateQuery = "UPDATE login_credentials SET user_id = '" + tmpuser.getUser_id() +
															"', username = '" + tmpuser.getUsername() + 
															"', password = '" + tmpuser.getPassword() +
															"', p_id = '" + tmpuser.getP_id() + 
															"', w_id = '" + tmpuser.getW_id() + 
															"', active_flag = '" + tmpuser.getActive_flag() + 
															"' WHERE user_id = '" + tmpuser.getUser_id() + "'";
		
		int res = DBService.DDLQueryInDB(updateQuery);
		tmpuser.setW_id(w_id);
		if(res == 0){
			addActionError(getText("Some error, please re-chech the field values."));
			return "error";
		}
		else{
			addActionMessage(getText("User edited successfully."));
			return "edituser_continue";
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
	
	public int getW_idfromDB(String WName){
		String wfquery = "SELECT w_id FROM workflow_master";
		String wfwhere = "WHERE workflow_name = '" + WName + "'";
		int w_id = -1;
		DBobjects dbObject;		
		try{
			dbObject = DBService.dbExecuteQuery(wfquery,wfwhere);
			result=dbObject.getResult();
		while(result.next()){
			w_id = result.getInt("w_id");
		}
		dbObject.getConn().close();
		}catch(Exception ex){
			System.out.println("Exception caught: " + ex);
		}
		return w_id;
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

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
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

	public String getSelected_actstate() {
		return selected_actstate;
	}

	public void setSelected_actstate(String selected_actstate) {
		this.selected_actstate = selected_actstate;
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

	public ArrayList<String> getActstateList() {
		return actstateList;
	}

	public void setActstateList(ArrayList<String> actstateList) {
		this.actstateList = actstateList;
	}

	public UserRole getTmpuser() {
		return tmpuser;
	}

	public void setTmpuser(UserRole tmpuser) {
		this.tmpuser = tmpuser;
	}

}
