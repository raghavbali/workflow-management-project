package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
	
	Connection uniqueConn;
	
	/**
	 * This function loads the Driver class,
	 * Makes a connection using the RunTimeSettings
	 * 
	 * @return Connection that already is present or is made for the first time
	 */	
	public Connection getConnection(){
		
		RunTimeSetting rts = new RunTimeSetting();
		
		if(uniqueConn ==null){
			
			try{
				Class.forName(rts.driver);
				uniqueConn = DriverManager.getConnection(rts.url + rts.dbName, rts.dbUser, rts.dbPwd);
				}
			catch (Exception e) {
			
				e.printStackTrace();
			}
			
			return uniqueConn;
		}else{
			
			return uniqueConn;
			
		}
	}
}
