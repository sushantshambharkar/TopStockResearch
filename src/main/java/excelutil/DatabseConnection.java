package excelutil;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabseConnection {
	public ResultSet databaseConnection() {

		java.sql.Connection conn = null;
		ResultSet result = null;
		try {

			/// https://www.connectionstrings.com/sql-server/

			String url = "jdbc:sqlserver://localHost:1433;"
					+ "databaseName=TECHNICAL_ANALYSIS; Trusted_Connection=True;";

			String username = "sushant";
			String password = "sushant";
			// Initialize Sqldriver instance
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Creating the connection providing URL and username password
			conn = DriverManager.getConnection(url,username,password);

			// Checking for the connection( returns boolean false if connected)
			System.out.println(conn.isClosed());

			// For Print
			System.out.println("Data values getting displayed below");
			// Sql Query to dispaly all the values under xxxxxxxx table
			String query = "SELECT * from XXXXXXXXX";
			// Providing the query under prepareStatement parameter
			PreparedStatement pst = conn.prepareStatement(query);

			// Command to execute query and capturing all the result under Result set
			result = pst.executeQuery();
			while (result.next()) {

				// Printing the 1 column 2 column and 6 column of the table
				System.out.println(result.getString(1) + "   " + result.getString(2) + "   " + result.getString(6));
			}

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return result;

	}
}