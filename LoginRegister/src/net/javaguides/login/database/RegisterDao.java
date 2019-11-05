package net.javaguides.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.javaguides.login.bean.RegisterBean;

public class RegisterDao {
	String url = "jdbc:mysql://localhost:3306/mydb?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	 public int registerUser(RegisterBean user) throws ClassNotFoundException {
		 //insert parameters in the database
	        String INSERT_USERS_SQL = "INSERT INTO users" +
	            "  (username, password, first_name, last_name, address) VALUES " +" (?, ?, ?, ?, ?);";

	        int result = 0;

	        Class.forName("com.mysql.cj.jdbc.Driver");

	        try (Connection connection = DriverManager.getConnection(url, "root", "1997"); //connect to db

	            // create statement 
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	        	preparedStatement.setString(1, user.getUsername());
		        preparedStatement.setString(2, user.getPassword());
	            preparedStatement.setString(3, user.getFirstName());
	            preparedStatement.setString(4, user.getLastName());
	           	preparedStatement.setString(5, user.getAddress());
	            

	            System.out.println(preparedStatement);
	            // Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process SQL exception
	            printSQLException(e);
	        }
	        return result;
	    }

	    private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
}
