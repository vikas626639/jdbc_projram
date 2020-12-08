package com.jdbc.fetchCount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchCountEMPTest {
	private static String query="SELECT COUNT(*) FROM EMP";
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			//load the jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//stablish the connection with database
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			//create statement 
			st=con.createStatement();
			//execute the query
			rs=st.executeQuery(query);
			//gather data from resultset 
			System.out.print("count * of emp table is:-");
			if(rs!=null) {
				while(rs.next()) {
					System.err.println(rs.getInt(1));
				}
			}
		} catch (ClassNotFoundException e) {
			System.err.println("jdbc jar file not added");
			System.out.println("plz add jdbc jar file in classpath");
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//closing the all connection 
			try {
				if(rs!=null)
					rs.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
