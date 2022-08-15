package Prcatice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Jdbc {
	public static void main(String[] args) throws Throwable {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "root");
		Statement stat = conn.createStatement();
		String query = "select * from students";
		 ResultSet res = stat.executeQuery(query);
		 while(res.next()) {
			 System.out.println(res.getString(1)+" "+res.getInt(2)+" "+res.getInt(3));
		 }
		 conn.close();
	}

}
