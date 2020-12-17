package com.jdbc.excel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertExcelData {

	private static String query="INSERT INTO COLLEGE.SHEET2 VALUES(?,?,?)";
	public static void main(String[] args) {
				Connection con=null;
				PreparedStatement st=null;
				ResultSet rs=null;
				int result=0;
				try {
					//ragister excel driver
					Class.forName("com.hxtt.sql.excel.ExcelDriver");
					//establish the connection with excel database
					con=DriverManager.getConnection("jdbc:excel:///C:\\Users\\vikas kumar\\Desktop");
					//create statement 
					if(con!=null) {
						st=con.prepareStatement(query);
					}
					
					//seting the param value
					st.setInt(1, 1002);
					st.setString(2, "vikash");
					st.setString(3, "hydrabad");
					//send and execute eht query
					result=st.executeUpdate();
					if(result!=0) {
						System.out.println("Record inserted");
					}else {
						System.out.println("record not inserted");
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


