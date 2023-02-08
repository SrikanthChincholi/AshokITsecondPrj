package jdbcpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class JDBCClassExample {

	static String url = "jdbc:mysql:///Customer";
	static String uname = "root";
	static String pswd = "Srikanth@kk42";

	public static List<CustomerDetails> readDbDetails() throws ClassNotFoundException, SQLException

	{
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection(url, uname, pswd);

		Statement stmt = con.createStatement();

		String query = "Select * from CustomerDetails";

		ResultSet rs = stmt.executeQuery(query);

		List<CustomerDetails> details = new ArrayList<CustomerDetails>();

		while (rs.next()) {

			CustomerDetails detail = new CustomerDetails();
			detail.setCust_Id(rs.getString("Cust_Id"));
			detail.setCust_Name(rs.getString("Cust_Name"));
			detail.setCust_loc(rs.getString("Cust_Loc"));
			details.add(detail);
		}
		return details;

	}

	@Test
	public void printCusotmerDetails() throws ClassNotFoundException, SQLException {
		List<CustomerDetails> details = readDbDetails();
		for (CustomerDetails custdetails : details) {
			System.out.println(custdetails.getCust_Id() + " ");
			System.out.println(custdetails.getCust_Name() + " ");
			System.out.println(custdetails.getCust_loc() + " ");
		}
	}
}
