package com.jdbc.excel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExcelTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//ragister excel driver
			Class.forName("com.hxtt.sql.excel.ExcelDriver");
			//establish the connection with excel database
			con=DriverManager.getConnection("jdbc:excel:///C:\\Users\\vikas kumar\\Desktop");
			//create statement 
			if(con!=null) {
				st=con.createStatement();
			}
			//send and execute eht query
			if(st!=null) {
				rs=st.executeQuery("select * from college.sheet1");
			}
			//process the result set
			System.err.println("SNO\t"+"SNAME\t"+"ADDRESS");
			if(rs!=null) {
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" \t"+rs.getString(2)+" \t"+rs.getString(3));
				}
			}
		} //try
		catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc object
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
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

}
