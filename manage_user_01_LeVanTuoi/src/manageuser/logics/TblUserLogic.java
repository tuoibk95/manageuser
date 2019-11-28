/**
 * Copyright(C) 2019 [Luvina Software Company]
 * TblUserLogic.java Nov 19, 2019 TuoiLV
 */
package manageuser.logics;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import manageuser.entities.UserInfo;

/**
 * interface logic of tbl_user
 * @author TuoiLV
 */
public interface TblUserLogic {
	/**
	 * Kiểm tra user có  tồn tại trong database không
	 * @param loginName: tên login nguười dùng nhập
	 * 		  password: pass của người dùng nhập
	 * @return boolean: trả về true nếu tồn tại người dùng
	 * @throws SQLException, NoSuchAlgorithmException
	 * @throws ClassNotFoundException , SQLException, NoSuchAlgorithmException
	 */
	public boolean checkExistLoginUser(String loginName, String password) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException;
	/**
	 * lấy tất cả tổng số user
	 * @param groupId: số Id của nhóm
	 * 		  fullName: tên cần tìm kiếm
	 * @return int: trả về tổng số user
	 * @throws ClassNotFoundException, SQLException
	 */
	public int getTotalUser(int groupId, String fullName) throws SQLException, ClassNotFoundException;
	/**
	 * lấy tất cả user
	 * @param groupId: số Id của nhóm
	 * 		  fullName: tên cần tìm kiếm
	 * @return int: trả về tổng số user
	 * @throws ClassNotFoundException, SQLException 
	 */
	public List<UserInfo> getListUser(int offset, int limit, int groupId, String fullName, String sortType, String sortByFullName, String sortByCodeName, String sortByEndDate)  throws SQLException, ClassNotFoundException, SQLException;
}
