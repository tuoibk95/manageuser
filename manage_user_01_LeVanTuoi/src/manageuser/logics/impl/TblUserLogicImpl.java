/**
 * Copyright(C) 2019 [Luvina Software Company]
 * TblUserLogicImpl.java Nov 19, 2019 TuoiLV
 */
package manageuser.logics.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.impl.TblUserDaoImpl;
import manageuser.entities.TblUser;
import manageuser.entities.UserInfo;
import manageuser.logics.TblUserLogic;
import manageuser.utils.Common;
 
/**
 * Lớp check login user
 * @author TuoiLV
 */
public class TblUserLogicImpl implements TblUserLogic{
	// Khai báo tbl_user
	private TblUserDaoImpl tblUserDao = new TblUserDaoImpl();
	/*
	 * Kiểm tra tồn tại của user trong database
	 * @param loginName: tên đăng nhập của user
	 * @param password: Mật khẩu của user
	 * @return Trả về true nếu tồn tại và ngược lại
	 */
	@Override
	public boolean checkExistLoginUser(String loginName, String password) throws SQLException {
		// Tạo biến kiểm tra tồn tại user
		boolean userExist = false;
		try {
			TblUser user = tblUserDao.getUserByLoginName(loginName);
			// Nếu user khác rỗng
			if (user != null) {
				// get password từ database
				String passDB = user.getPassword();
				// ecypt password nhập từ bàn phím
				password = Common.encryptPassword(password, user.getSalt());
				// So sánh password nhập từ bàn phím và trong DB
				if (Common.comparePassword(password, passDB)) {
					userExist = true;
				}
			}
		// Bắt lỗi, in và ném lỗi
		} catch (SQLException e) {
			System.out.println(this.getClass().getName() + " :" + e.getMessage());
			throw e;
		}
		return userExist;
	}
	
	/**
	 * lấy tất cả tổng số user
	 * @param groupId: số Id của nhóm
	 * @param fullName: tên cần tìm kiếm
	 * @return int: trả về tổng số user
	 */
	@Override
	public int getTotalUser(int groupId, String fullName) throws SQLException {
		int totalUser = 0;
		try{
			// thay thế kí tự wildcard
			fullName = Common.replaceWildCard(fullName);
			totalUser = tblUserDao.getTotalUser(groupId, fullName);
		} catch (SQLException e) {
			// ghi log
			System.out.println(this.getClass().getName() + " : " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return totalUser;
	}
	
	/**
	 * lấy tất cả user
	 * @param groupId: số Id của nhóm
	 * @param fullName: tên cần tìm kiếm
	 * @return int: trả về tổng số user
	 */
	@Override
	public List<UserInfo> getListUser(int offset, int limit, int groupId, String fullName, String sortType, String sortByFullName, String sortByCodeLevel, String sortByEndDate)  throws SQLException, ClassNotFoundException {
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		try {	
			// thay thế kí tự wildcard
			fullName = Common.replaceWildCard(fullName);
			userInfos = tblUserDao.getListUser(offset, limit, groupId, fullName, sortType, sortByFullName, sortByCodeLevel, sortByEndDate);
		} catch (SQLException e) {
			// ghi log
			System.out.println(this.getClass().getName() + " : " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		return userInfos;	}
}
