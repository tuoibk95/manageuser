/**
 * Copyright(C) 2019 [Luvina Software Company]
 * AddUserInputController.java Nov 19, 2019 TuoiLV
 */
package manageuser.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageuser.entities.UserInfo;
import manageuser.logics.impl.MstGroupLogicImpl;
import manageuser.logics.impl.MstJapanLogicImpl;
import manageuser.utils.Common;
import manageuser.utils.Constant;

/**
 * Xử lý khi click vào button Add của ADM002
 * Servlet implementation class AddUserInputController
 */
//@WebServlet("/AddUserInputController")
public class AddUserInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserInputController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /*
     * Thực hiện set giá trị cho các hạng mục selectbox ở màn hình ADM003
     * @param request: set các giá trị select box lên request
     */
    public void setDataLogic(HttpServletRequest request) throws SQLException, ClassNotFoundException {
    	try {
    		MstGroupLogicImpl mstGroupLogic = new MstGroupLogicImpl();
        	MstJapanLogicImpl mstJapanLogic = new MstJapanLogicImpl();
        	
        	request.setAttribute("listgroup", mstGroupLogic.getAllMstGroup());
        	request.setAttribute("listjapan", mstJapanLogic.getAllMstJapan());
        	request.setAttribute("year", Common.getListYear(Constant.START_YEAR, Common.getCurrentYear()));
			request.setAttribute("month", Common.getListMonth());
			request.setAttribute("day", Common.getListDay());
		} catch (SQLException e) {
			System.out.println(this.getClass().getName() + " : " + e.getMessage());
			e.printStackTrace();
		}
    }
    
    /*
     * Get giá trị default cho màn hình ADM003
     * @param request: 
     * @param response:
     * return Đối tượng chứa thông tin của màn hình ADM003
     */
    private UserInfo getDefaultValue(HttpServletRequest request, HttpServletResponse response) {
    	UserInfo userInfo = new UserInfo();
		userInfo.setFullName(Constant.USER_FULL_NAME_DEFAULT);
		return userInfo;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			// nếu người dùng chưa đăng nhập
			if (Common.checkLogin(session) == null) {
				response.sendRedirect(request.getContextPath() + Constant.ADM001_URL);
				return;
			} else {
				setDataLogic(request);
				request.getRequestDispatcher(Constant.ADM003_URL).forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(this.getClass().getName() + " : " + e.getMessage());
			e.printStackTrace();
		}
	}
}
