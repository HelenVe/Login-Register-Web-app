package net.javaguides.login.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDao {
	String url = "jdbc:mysql://localhost:3306/mydb?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	//checks the credentials of the user
	public boolean validate(String uname, String pass) throws ClassNotFoundException {
	        boolean status = false;

	        Class.forName("com.mysql.cj.jdbc.Driver"); //load class

	        try (Connection connection = DriverManager.getConnection(url, "root", "1997"); //database username and password

	            // Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ? and password = ? ")) {
	            preparedStatement.setString(1, uname);
	            preparedStatement.setString(2, pass);

	            System.out.println(preparedStatement);
	            ResultSet result = preparedStatement.executeQuery(); //execute
	            status = result.next();
	            
	            if (status) {
	            	return true;
	            }

	        } catch (SQLException e) {
	            // process SQL exception
	            printSQLException(e);
	        }
	        return status;
	    }
	 	// display errors
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
