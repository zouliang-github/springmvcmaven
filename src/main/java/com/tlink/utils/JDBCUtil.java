/**
 * 
 */
package com.tlink.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author HUASINE
 *
 */
public class JDBCUtil {
	 private static Connection conn = null;
	 
	 public static Connection getConn(){
		 //PropertiesUtil.loadFile("jdbc.properties");
		 PropertiesUtil.loadFile("config/jdbc.properties");
		 String driver = PropertiesUtil.getPropertyValue("driver");
		 String url = PropertiesUtil.getPropertyValue("url");
		 String username  = PropertiesUtil.getPropertyValue("username");
		 String password = PropertiesUtil.getPropertyValue("password");
		 try {
			 Class.forName(driver);
			 conn = DriverManager.getConnection(url,username,password);
		 } catch (ClassNotFoundException e) {
			 e.printStackTrace();
		 } catch (SQLException e) {
			 e.printStackTrace();
			 close();
		 }
		 return conn;
	 }
	 public static void close(){
		 try {
			 conn.close();
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
	 }
}
