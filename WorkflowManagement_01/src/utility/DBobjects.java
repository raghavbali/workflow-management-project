package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBobjects {
	private Connection conn;
	PreparedStatement query;
	ResultSet result;
	ArrayList<String> returnString;
	
	public DBobjects(){
	}
	
	
	
	
	public DBobjects(Connection conn, PreparedStatement query,
			ResultSet result, ArrayList<String> returnString) {
		this.conn = conn;
		this.query = query;
		this.result = result;
		this.returnString = returnString;
	}




	public DBobjects(Connection conn, PreparedStatement query) {
		this.conn = conn;
		this.query = query;
	}




	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public PreparedStatement getQuery() {
		return query;
	}
	public void setQuery(PreparedStatement query) {
		this.query = query;
	}
	public ResultSet getResult() {
		return result;
	}
	public void setResult(ResultSet result) {
		this.result = result;
	}
	public ArrayList<String> getReturnString() {
		return returnString;
	}
	public void setReturnString(ArrayList<String> returnString) {
		this.returnString = returnString;
	}
}
