/**
 * Copyright(C) 2019 [Luvina Software Company]
 * LoginController.java Nov 19, 2019 TuoiLV
 */
package manageuser.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageuser.utils.Constant;
import manageuser.utils.MessageErrorProperties;
import manageuser.validates.ValidateUser;

/**	Khi người dùng login
 * Servlet implementation class LoginController
 */

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * Hàm doPost gọi khi người dùng đăng nhập
	 * @param request: request đc gửi đến môi khi người dùng nhấn nút đăng nhập
	 * 		  response: phản hồi
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Khai bao biến param của loginId
			String loginName = request.getParameter("loginId");
			// Khai báo biến param của password
			String password = new String(request.getParameter("password").getBytes());
			// Lấy thông báo lỗi khi validate
			List<String> error = new ValidateUser().validateLogin(loginName, password);
			// Nếu không lỗi
			if (error.size() == 0) {
				// Khai báo đối tượng session
				HttpSession session = request.getSession();
				// Nếu ko có lỗi set lên session
				session.setAttribute("loginId",loginName);
				// Chuyến đến màn hình list User
				response.sendRedirect(request.getContextPath() + Constant.LISTUSER_URL +"?type=DEFAULT");
			} else {
				// Thông báo lỗi tương ứng
				request.setAttribute("listError", error);
				request.setAttribute("loginId",	loginName);
				request.getRequestDispatcher(Constant.ADM001_URL).forward(request, response);				
			}
		} catch (Exception e) {
			System.out.println(this.getClass().getName() + " : " + e.getMessage());
			e.printStackTrace();
			request.setAttribute("error", MessageErrorProperties.getValueByKey("ER015"));
			request.getRequestDispatcher(Constant.ERROR_URL).forward(request, response);
		}
	}
}
