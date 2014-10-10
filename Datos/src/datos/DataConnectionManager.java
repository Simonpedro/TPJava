package datos;

import java.sql.*;

public class DataConnectionManager {
	private static DataConnectionManager instancia;
	public static DataConnectionManager getInstancia() {
		if (instancia == null) {
			instancia = new DataConnectionManager();
		}
		return instancia;
	}
	
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/dbJavaTP1";
	private static final String USER = "root";
	private static final String PASS = "root";
	
	private Connection conn;
	
	public  Connection getConn() {
		try {
			if (true) { //  conn == null || !conn.isValid(3)
				this.closeConn();
				Class.forName(JDBC_DRIVER).newInstance();
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void closeConn() {
		try {
			if (conn!=null && !conn.isClosed()) {
				conn.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
