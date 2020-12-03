package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpTestAssignment {
	private static String query="SELECT EMPNO,ENAME,JOB FROM EMP WHERE SAL=(SELECT MAX(SAL)FROM EMP)";
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//loading jdbc class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Stablish the connection between application and database
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			//create statement 
			st=con.createStatement();
			//execute query
			rs=st.executeQuery(query);
			//print the output from resultset
			System.out.println("EMPNO\t"+"ENAME\t"+"JOB");
			if(rs.next()) {
				System.err.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			//System.out.println("Class loaded suseccfully");
		} catch (ClassNotFoundException e) {
			System.err.println("Driver class not found");
			System.err.println("add jdbc driver to classpath");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
