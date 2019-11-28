/**
 * Copyright(C) 2019 [Luvina Software Company]
 * ListUserController.java Nov 19, 2019 TuoiLV
 */
package manageuser.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageuser.entities.UserInfo;
import manageuser.logics.impl.MstGroupLogicImpl;
import manageuser.logics.impl.TblUserLogicImpl;
import manageuser.utils.Common;
import manageuser.utils.Constant;
import manageuser.utils.MessageErrorProperties;
import manageuser.utils.MessageProperties;

/**
 * Lớp hiển thị list user Servlet implementation class ListUserController
 */
//@WebServlet("/ListUserController")
public class ListUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListUserController() {
		super();
	}

	// Khai báo logic của mst_group
	MstGroupLogicImpl group = new MstGroupLogicImpl();
	// Khai báo logic của tbl_user
	TblUserLogicImpl userLogic = new TblUserLogicImpl();

	/**
	 * hàm doPost gọi khi người dùng thao tác trên màn hình ADM002 khi người dùng
	 * đăng nhập lần đầu, Tìm kiếm, Sắp xếp, Phân trangvà Back
	 * 
	 * @param requestuest:  requestuest đc gửi đến môi khi người dùng thực hiện thao tác ở
	 *                  trên
	 * @param responseponse: phản hồi
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			// khởi tạo giá trị cần thiết
			// tổng số user ban đầu là 0
			int totalUser = 0;
			// tổng số paging ban đầu là 0
			int allPaging = 0;
			int offset = 0;
			// giá trị sắp xếp default của full_name là ASC
			String sortByFullName = Constant.SORT_BY_FULLNAME_DEFAULT;
			// giá trị sắp xếp default của code level là ASC
			String sortByCodeLevel = Constant.SORT_BY_CODELEVEL_DEFAULT;
			// giá trị sắp xếp default của expire Date là DÊSC
			String sortByExpireDate = Constant.SORT_BY_EXPIREDATE_DEFAULT;
			// giá trị tìm kiếm default theo nhóm là 1
			int groupIdSearch = Constant.GROUP_ID_DEFAULT;
			// giá trị tìm kiếm default theo tên là rỗng
			String nameSearch = Constant.FULL_NAME_DEFAULT;
			// giá trị sắp xếp ưu tiên default là theo full name
			String sortType = Constant.SORT_TYPE_DEFAULT;
			// page hiện tại default là 1
			int currentPage = Constant.CURRENT_PAGE_DEFAULT;
			// Sắp xếp mặc định là tăng dần
			String sort = "ASC";
			// session hiện tại
			HttpSession session = request.getSession();
			// nếu người dùng chưa đăng nhập
			if (Common.checkLogin(session) == null) {
				response.sendRedirect(request.getContextPath() + Constant.ADM001_URL);
				return;
			} else {
				if (request.getParameter("type") != null) {
					// biến lưu action của người dùng
					String type = request.getParameter("type");
					// các action tương ứng
					switch (type) {
					case "DEFAULT":
						break;
					case "SEARCH":
						// Click vào button search
					case "PAGING":
						// click vào phân trang
					case "SORT":
						// click vào button sắp xếp
						// lấy giá trị của group id
						if (request.getParameter("group_id") != null) {
							groupIdSearch = Common.ConvertStringToInt(request.getParameter("group_id"), groupIdSearch);
						}
						// lấy giá tri của tên tìm kiểm
						if (request.getParameter("name") != null) {
							nameSearch = request.getParameter("name");
						}
						// nếu current page khác rỗng
						if (request.getParameter("currentPage") != null) {
							currentPage = Common.ConvertStringToInt(request.getParameter("currentPage"), currentPage);
						}
						// Nếu trường sắp xếp khác rỗng
						if (request.getParameter("sortField") != null) {
							sortType = request.getParameter("sortField");
						}
						if (request.getParameter("sort") != null) {
							sort = request.getParameter("sort");
						}
						break;
					case "BACK":
						if (session.getAttribute("groupSearch") != null) {
							groupIdSearch = (int) session.getAttribute("groupSearch");
						}
						if (session.getAttribute("nameSearch") != null) {
							nameSearch = (String) session.getAttribute("nameSearch");
						}
						if (session.getAttribute("currentPage") != null) {
							currentPage = (int) session.getAttribute("currentPage");
						}
						if (session.getAttribute("sortField") != null) {
							sortType = (String) session.getAttribute("sortField");
						}
						if (session.getAttribute("sort") != null) {
							sort = (String) session.getAttribute("sort");
						}
						break;
					}
				}
			}
			// xem đang sort theo hạng mục nào
			switch (sortType) {
			case "fullName":
				sortByFullName = sort;
				break;
			case "codeLevel":
				sortByCodeLevel = sort;
				break;
			case "expireDate":
				sortByExpireDate = sort;
				break;
			}
			// gán các giá trị lên session
			session.setAttribute("nameSearch", nameSearch);
			session.setAttribute("groupSearch", groupIdSearch);
			session.setAttribute("currentPage", currentPage);
			session.setAttribute("sortType", sortType);
			session.setAttribute("sort", sort);
			// lấy số lượng các user
			totalUser = userLogic.getTotalUser(groupIdSearch, nameSearch);
			MessageProperties.getValueByKey(null);
			// nếu không có bản ghi nào
			if (totalUser == 0) {
				request.setAttribute("error", MessageProperties.getValueByKey("MSG005"));
			}
			// list lưu các paging cần hiển thị
			List<Integer> listPaging = Common.getListPaging(totalUser, Constant.LIMIT, currentPage);
			// số lượng tổng của paging
			allPaging = Common.getTotalPage(totalUser, Constant.LIMIT);
			// nếu page hiện tại nhỏ hơn 1 thì hiển thị default paging current
			if (currentPage < 1) {
				currentPage = Constant.CURRENT_PAGE_DEFAULT;
			}
			// list lưu các paging cần hiển thị
			listPaging = Common.getListPaging(totalUser, Constant.LIMIT, currentPage);
			// offset lấy từ bản ghi thứ bao nhiêu
			offset = Common.getOffSet(currentPage, Constant.LIMIT);
			// lấy danh sách các info của user mà tìm được
			List<UserInfo> userInfo = userLogic.getListUser(offset, Constant.LIMIT, groupIdSearch, nameSearch,
					sortType, sortByFullName, sortByCodeLevel, sortByExpireDate);

			// set các giá trị lên requestuest
			request.setAttribute("listgroup", group.getAllMstGroup());
			request.setAttribute("name", nameSearch);
			request.setAttribute("group_id", groupIdSearch);
			request.setAttribute("sortField", sortType);
			request.setAttribute("sort", sort);
			// vùng set để hiển thị ra màn hình
			request.setAttribute("userInfo", userInfo);
			// Vùng set cho paging
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("listPaging", listPaging);
			request.setAttribute("allPaging", allPaging);
			request.setAttribute("limitPage", Constant.LIMIT_PAGE);
			// vùng set cho sắp xếp
			request.setAttribute("sortByFullName", sortByFullName);
			request.setAttribute("sortByCodeLevel", sortByCodeLevel);
			request.setAttribute("sortByExpireDate", sortByExpireDate);
			// gửi lại màn hình ADM002
			request.getRequestDispatcher(Constant.ADM002_URL).forward(request, response);
			// bắt và in ra lỗi, có lỗi thì hiển thị màn hình lỗi
		} catch (Exception e) {
			System.out.println(this.getClass().getName() + " : " + e.getMessage());
			e.printStackTrace();
			// Chuyển sang màn hình lỗi
			request.setAttribute("error", MessageErrorProperties.getValueByKey("ER015"));
			request.getRequestDispatcher(Constant.ERROR_URL).forward(request, response);
		}
	}
}
