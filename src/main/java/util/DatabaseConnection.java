package util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DatabaseConnection {
	public ResultSet databaseConnection() {

		java.sql.Connection conn = null;
		ResultSet result = null;
		try {

			/// https://www.connectionstrings.com/sql-server/
			/// https://seleniummaster.com/sitecontent/index.php/sql-for-tester-menu/205-how-to-retrieve-data-with-sql-statement-select-syntax

			String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=TECHNICAL_ANALYSIS;integratedSecurity=true";


			// Initialize Sqldriver instance
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Creating the connection providing URL and username password
			conn = DriverManager.getConnection(connectionUrl);

			// Checking for the connection( returns boolean false if connected)
			System.out.println("SchemaName " + conn.getSchema());

			System.out.println("Data values getting displayed below");
			
			// Sql Query to dispaly all the values under xxxxxxxx table
			String query = "SELECT top 10  * from dbo.get_tech_daily";
			
			
			// Providing the query under prepareStatement parameter
			PreparedStatement pst = conn.prepareStatement(query);

			// Command to execute query and capturing all the result under Result set
			result = pst.executeQuery();
			while (result.next()) {

				// Printing the 1 column 2 column and 6 column of the table
				System.out.println(result.getString(1) + "   " + result.getString(2) + "   " + result.getString(6));
			}

			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				System.out.println("is connection closed " + conn.isClosed());
			}

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return result;

	}

}