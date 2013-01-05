package model;

import java.sql.ResultSet;
import java.util.ArrayList;

import utility.DBService;
import utility.DBobjects;

public class UserDetails {

	private User user;
	private UserRole user_role;
	
	public UserDetails(User user, UserRole user_role) {
		this.user = user;
		this.user_role = user_role;
	}
	
	public static ArrayList<UserDetails> find(String whereClause) {
		ResultSet result = null;
		ArrayList<UserDetails> userDetails = new ArrayList<UserDetails>();
		DBobjects dbObject;
		
		String selectQuery = "SELECT ub.*, ur.* FROM personal_information ub, login_credentials ur where ub.p_id = ur.p_id ";

		try {
			dbObject = DBService.dbExecuteQuery(selectQuery, whereClause);
			result=dbObject.getResult();
			while (result.next()) {
				User newUser = new User();
				newUser.setP_id(result.getString("p_id"));
				newUser.setPrefix(result.getString("prefix"));
				newUser.setFname(result.getString("first_name"));
				newUser.setLname(result.getString("last_name"));
				newUser.setSex(result.getString("gender"));
				newUser.setDob(result.getString("dob"));
				newUser.setAddress(result.getString("address"));
				newUser.setCountry(result.getString("country"));
				newUser.setPhone(result.getString("phone_no"));
				newUser.setEmail(result.getString("email"));
				
				UserRole newUserRole = new UserRole();
				newUserRole.setUser_id(result.getString("user_id"));
				newUserRole.setUsername(result.getString("username"));
				newUserRole.setPassword(result.getString("password"));
				newUserRole.setP_id(result.getString("p_id"));
				newUserRole.setW_id(result.getString("w_id"));
				newUserRole.setRole(result.getString("role"));
				newUserRole.setActive_flag(result.getString("active_flag"));
				userDetails.add(new UserDetails(newUser, newUserRole));
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return userDetails;

	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserRole getUser_role() {
		return user_role;
	}
	public void setUser_role(UserRole user_role) {
		this.user_role = user_role;
	}
	
}
