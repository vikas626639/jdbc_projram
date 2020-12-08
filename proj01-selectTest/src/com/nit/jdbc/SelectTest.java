package com.nit.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//ragister jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection 
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system","manager");
			//create jdbc Statement object
			st=con.createStatement();
			//execute the query and process the result set
			rs=st.executeQuery("select * from emp");
			//print database table record
			System.out.println("number "+"\t"+"  name"+"\t"+"  desg");
			while(rs.next()!=false) {
				System.out.println(rs.getInt(1)+"\t "+rs.getString(2)+"\t "+rs.getString(3));
			}
			//closeing all jdbc stream object
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
