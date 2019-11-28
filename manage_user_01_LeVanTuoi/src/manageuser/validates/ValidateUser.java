/**
 * Copyright(C) 2019 [Luvina Software Company]
 * ValidateUser.java Nov 19, 2019 TuoiLV
 */
package manageuser.validates;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.logics.impl.TblUserLogicImpl;
import manageuser.utils.MessageErrorProperties;
/**
 * Lớp Xử lý thông tin nhập từ màn hình
 * @author TuoiLV
 */
public class ValidateUser {
	// Khai báo đối tượng logic để kiểm tra bảng tbluser
	private TblUserLogicImpl userLogic = new TblUserLogicImpl();
	
	/*
	 * Phương thức xác thực tài khoản 
	 * @param loginName: Tên đăng nhập
	 * @param password: Mật khẩu đăng nhập
	 * @return Trả về list các lỗi
	 */
	public List<String> validateLogin(String loginName, String password) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {
		// Khởi tạo các mã lỗi
		List<String> listError = new ArrayList<String>();
		try {
			// Nếu không nhập gì vào loginName
			if ("".equals(loginName)) {
				listError.add(MessageErrorProperties.getValueByKey("ER001_loginName"));
			}
			// Nếu không nhập gì vào password
			if ("".equals(password)) {
				listError.add(MessageErrorProperties.getValueByKey("ER001_password"));
			}
			// Nếu loginName , password sai, không tồn tại user trong DB
			if (!"".equals(loginName) && !"".equals(password) && !userLogic.checkExistLoginUser(loginName, password)) {
				listError.add(MessageErrorProperties.getValueByKey("ER016"));
			}
		} catch (SQLException e) {
			// Ghi log ra console
			System.out.println(this.getClass().getName() + " " + this.getClass().getMethods() + e.getMessage());
			e.printStackTrace();
			// Ném lỗi
			throw e;
		}
		return listError;
	}
}
