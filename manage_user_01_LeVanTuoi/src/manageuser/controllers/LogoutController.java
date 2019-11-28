/**
 * Copyright(C) 2019 [Luvina Software Company]
 * LogoutController.java Nov 19, 2019 TuoiLV
 */
package manageuser.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageuser.utils.Constant;

/**
 * Servlet implementation class LogoutController
 */
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			HttpSession session = request.getSession();
			if (session != null) {
				session.invalidate(); //removes all session attributes bound to the session
				RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.ADM001_URL);
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(this.getClass().getName() + " " + this.getClass().getMethods() + e.getMessage());
			e.printStackTrace();
		}
	}
}
