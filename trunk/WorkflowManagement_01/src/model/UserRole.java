package model;

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
	
}
