package net.javaguides.login.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.javaguides.login.database.RegisterDao;
import net.javaguides.login.bean.RegisterBean;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RegisterDao registerDao;
    
    public void init() {
    	registerDao = new RegisterDao();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the users info
		String username = request.getParameter("username");
        String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        
        // create a user of type RegisterBean from the info given above
        RegisterBean user = new RegisterBean();
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress(address);

        try {
            registerDao.registerUser(user);
        } catch (Exception e) {
            
            e.printStackTrace();
        }

        
        //Redirect to this webpage
        response.sendRedirect("successfulregister.jsp");
    }
}


