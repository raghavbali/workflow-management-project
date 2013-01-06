package utility;

import java.sql.*;
import java.util.ArrayList;

import model.User;
import model.UserRole;
import model.WorkflowMaster;


public class DBService {
	
	public static ArrayList<String> db_authenticate(String username, String password){
		Connection conn = null;
		PreparedStatement query = null;
		ResultSet result = null;
		//String returnString = "login_fail";
		ArrayList<String> returnString=new ArrayList<String>();
		
		try{
			conn = new MySqlConnection().getConnection();
			query = conn.prepareStatement("select password, role, w_id,user_id from login_credentials where username = ? and active_flag = 1");
			query.setString(1, username);
			result = query.executeQuery();

			while(result.next()){

				if(password.equals(result.getString("password"))){
					//returnString = result.getString("role");
					returnString.add(result.getString("role"));
					returnString.add(String.valueOf(result.getInt("w_id")));
					returnString.add(String.valueOf(result.getInt("user_id")));
				}
				else{
					//returnString = "login_fail";
					returnString.add("login_fail");
				}
			}
			conn.close();
		}catch(Exception ex){
			System.out.println("Exception caught:\n" + ex);
		}
		return returnString;
	}
	
	
	
	public static DBobjects dbExecuteQuery(String strQuery, String whereClause){
		
		//Connection conn = null;
		PreparedStatement query = null;
		//ResultSet result = null;
		DBobjects dbObject=new DBobjects();
		
		try{
			dbObject.setConn(new MySqlConnection().getConnection());
			query = dbObject.getConn().prepareStatement(strQuery+" "+whereClause);
			dbObject.setResult(query.executeQuery());
			//conn.close();
			return dbObject;
		}catch(Exception ex){
			System.out.println("Exception caught:\n" + ex);
			return null;
		}
		
	}


	public static int insertObjectInDB(String insertQuery,ArrayList<String> params){
		int result;
		Connection conn=null;
		PreparedStatement pst = null;
		int i=1;

		try {
			conn= new MySqlConnection().getConnection();
			pst=conn.prepareStatement(insertQuery);
			
			for (String string : params) {
				pst.setString(i, string);
				i++;
			}
			
			result = pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			result =0;
		}
		return result;
	}

	
	public static int DDLQueryInDB(String sqlQuery){
		int result;
		Connection conn=null;
		PreparedStatement pst = null;

		try {
			conn= new MySqlConnection().getConnection();
			pst=conn.prepareStatement(sqlQuery);
			result = pst.executeUpdate();
					
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	public static int generate_wid(){
		Connection conn = null;
		PreparedStatement query = null;
		ResultSet result = null;
		int w_id = 0;
		
		try{
			conn = new MySqlConnection().getConnection();
			query = conn.prepareStatement("SELECT MAX(w_id) as w_id FROM `workflow_master`");
			result = query.executeQuery();
			while(result.next()){
				w_id = result.getInt("w_id") + 1;
			}
			conn.close();
		}catch(Exception ex){
			System.out.println("Exception caught:\n" + ex);
		}
		return w_id;
	}
	
	
	
	public static int generate_pid(){
		Connection conn = null;
		PreparedStatement query = null;
		ResultSet result = null;
		int p_id = 0;
		
		try{
			conn = new MySqlConnection().getConnection();
			query = conn.prepareStatement("SELECT MAX(p_id) as p_id FROM `personal_information`");
			result = query.executeQuery();
			while(result.next()){
				p_id = result.getInt("p_id") + 1;
			}
			conn.close();
		}catch(Exception ex){
			System.out.println("Exception caught:\n" + ex);
		}
		return p_id;
	}
	

	public static int generate_userid(){
		Connection conn = null;
		PreparedStatement query = null;
		ResultSet result = null;
		int user_id = 0;
		
		try{
			conn = new MySqlConnection().getConnection();
			query = conn.prepareStatement("SELECT MAX(user_id) as user_id FROM `login_credentials`");
			result = query.executeQuery();
			while(result.next()){
				user_id = result.getInt("user_id") + 1;
			}
			conn.close();
		}catch(Exception ex){
			System.out.println("Exception caught:\n" + ex);
		}
		return user_id;
	}
	
	public static ArrayList<User> getUserList(String whereClause){
		Connection conn = null;
		PreparedStatement query = null;
		ResultSet result = null;
		
		ArrayList<User> usrlist= new ArrayList<User>();
		User usr;
		try{
			conn = new MySqlConnection().getConnection();
			query = conn.prepareStatement("SELECT * FROM `personal_information`" + whereClause);
			result = query.executeQuery();
			while(result.next()){
				usr = new User();
				usr.setP_id(result.getString("p_id"));
				usr.setPrefix(result.getString("prefix"));
				usr.setFname(result.getString("first_name"));
				usr.setLname(result.getString("last_name"));
				usr.setSex(result.getString("gender"));
				usr.setDob(result.getString("dob"));
				usr.setAddress(result.getString("address"));
				usr.setCountry(result.getString("country"));
				usr.setPhone(result.getString("phone_no"));
				usr.setEmail(result.getString("email"));
				
				usrlist.add(usr);
			}
			conn.close();
		}catch(Exception ex){
			System.out.println("Exception caught:\n" + ex);
	}
	return usrlist;
	}
	
	public static ArrayList<UserRole> getUserRoleList(String pid){
		Connection conn = null;
		PreparedStatement query = null;
		ResultSet result = null;
		
		ArrayList<UserRole> usrlist= new ArrayList<UserRole>();
		UserRole usr;
		try{
			conn = new MySqlConnection().getConnection();
			query = conn.prepareStatement("SELECT * FROM `login_credentials` where p_id = ?");
			query.setString(1, pid);
			result = query.executeQuery();
			while(result.next()){
				usr = new UserRole();
				usr.setUser_id(result.getString("user_id"));
				usr.setUsername(result.getString("username"));
				usr.setPassword(result.getString("password"));
				usr.setP_id(result.getString("p_id"));
				usr.setW_id(result.getString("w_id"));
				usr.setRole(result.getString("role"));
				usr.setActive_flag(result.getString("active_flag"));
				if(usr.getActive_flag().equals("1"))
					usr.setActive_flag("Yes");
				else if(usr.getActive_flag().equals("0"))
					usr.setActive_flag("No");
				
				usrlist.add(usr);
			}
			conn.close();
		}catch(Exception ex){
			System.out.println("Exception caught:\n" + ex);
	}
	return usrlist;
	}
	
	public static String tableSuffix(int w_id){
		String selectQueryTable=null;
		String whereClauseTable=null;
		DBobjects dbObject;
		ResultSet resultTableName=null;
		String tableName=null;
		
		
		selectQueryTable = "SELECT table_suffix FROM workflow_master ";
		whereClauseTable = "where w_id = "+w_id;
		
		
		try {
			dbObject = DBService.dbExecuteQuery(selectQueryTable, whereClauseTable);
			resultTableName=dbObject.getResult();
			while (resultTableName.next()) {
				tableName =resultTableName.getString(1);
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("tbl name="+tableName);
		return tableName;
	}
	
	
}
