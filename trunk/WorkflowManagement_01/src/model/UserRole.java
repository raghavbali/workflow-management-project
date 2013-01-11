package model;

import java.sql.ResultSet;
import java.util.ArrayList;

import utility.DBService;
import utility.DBobjects;

public class UserRole {
	String user_id, username, password, p_id, w_id, role, active_flag;
	
	public UserRole(){
		
	}

	public UserRole(String user_id, String username, String password,
			String p_id, String w_id, String role, String active_flag) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.p_id = p_id;
		this.w_id = w_id;
		this.role = role;
		this.active_flag = active_flag;
	}
	
	public static ArrayList<UserRole> find(String whereClause) {
		ResultSet result = null;
		ArrayList<UserRole> userRole = new ArrayList<UserRole>();
		DBobjects dbObject;
		
		String selectQuery = "SELECT `user_id`, `username`, `password`, `p_id`, `w_id`, `role`, `active_flag` FROM `login_credentials` ";

		try {
			dbObject = DBService.dbExecuteQuery(selectQuery, whereClause);
			result=dbObject.getResult();
			while (result.next()) {
				UserRole newUserRole = new UserRole();
				newUserRole.setUser_id(result.getString("user_id"));
				newUserRole.setUsername(result.getString("username"));
				newUserRole.setPassword(result.getString("password"));
				newUserRole.setP_id(result.getString("p_id"));
				newUserRole.setW_id(result.getString("w_id"));
				newUserRole.setRole(result.getString("role"));
				newUserRole.setActive_flag(result.getString("active_flag"));
				userRole.add(newUserRole);
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return userRole;

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
	
	public static String get(String colname, String userID){
		String value = "";
		ResultSet result;
		String query = "SELECT " + colname + " FROM login_credentials ";
		String where = "WHERE user_id = '" + userID + "'";
		DBobjects dbObject;	
		try{
			dbObject = DBService.dbExecuteQuery(query,where);
			result=dbObject.getResult();
		while(result.next()){
			value = result.getString(colname);
		}
		dbObject.getConn().close();
		}catch(Exception ex){
			System.out.println("Exception caught: " + ex);
		}
		return value;
	}
	
	public static String getEditorByWid(String colname, String wID){
		String value = "";
		ResultSet result;
		String query = "SELECT " + colname + " FROM login_credentials ";
		String where = "WHERE p_id = '" + wID + "' AND role IN ('editor')";
		DBobjects dbObject;	
		try{
			dbObject = DBService.dbExecuteQuery(query,where);
			result=dbObject.getResult();
		while(result.next()){
			value = result.getString(colname);
		}
		dbObject.getConn().close();
		}catch(Exception ex){
			System.out.println("Exception caught: " + ex);
		}
		return value;
	}
	
}
