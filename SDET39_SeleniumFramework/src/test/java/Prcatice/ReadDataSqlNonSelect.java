package Prcatice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;




public class ReadDataSqlNonSelect {
	public static void main(String[] args) throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "root");
		Statement stat = conn.createStatement();
		String query = "insert into students values ('john',5,5)";
		int res = stat.executeUpdate(query);
		if(res==1) {
			System.out.println("added");
		}
		else
		{
			System.out.println("not added");
		}
		conn.close();
		
	}

}
