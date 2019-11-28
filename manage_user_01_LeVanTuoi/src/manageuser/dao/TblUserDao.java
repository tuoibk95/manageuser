/**
 * Copyright(C) 2019 [Luvina Software Company]
 * TblUserDao.java Nov 19, 2019 TuoiLV
 */
package manageuser.dao;

import java.sql.SQLException;
import java.util.List;

import manageuser.entities.TblUser;
import manageuser.entities.UserInfo;

/**
 * Thao tác với DB từ bảng tbl_user
 * @author TuoiLV
 */
public interface TblUserDao {
	/**
	 * Lấy loginName từ DB
	 * @param loginName: tên đăng nhập của người dùng
	 * @return TblUser trả về user được tìm thấy theo tên
	 */
	public TblUser getUserByLoginName(String loginName) throws SQLException;
	
	/**
	 * lấy ra các user bẳng tên login của user đó
	 * @param groupId: Id của nhóm cần tìm kiếm
	 * @param fullname: tên của user cần tìm kiếm
	 * @return trả về số lượng user tìm thấy dduocjwj từ database
	 */
	public int getTotalUser(int groupId, String fullName) throws SQLException;
	
	/**
	 * lấy ra tất cả các user theo fullname và groupId
	 * @param int offset vị trí data cần lấy nào
	 * @param offset vị trí data cần lấy nào
	 * @param limit số lượng lấy
	 * @param groupId mã nhóm tìm kiếm
	 * @param fullName Tên tìm kiếm
	 * @param sortType: Nhận biết xem cột nào được ưu tiên sắp xếp(full_name or end_date or code_level)
	 * @param sortByFullName: Giá trị sắp xếp của cột Tên(ASC or DESC)
	 * @param sortByCodeLevel: Giá trị sắp xếp của cột Trình độ tiếng nhật(ASC or DESC)
	 * @param sortByEndDate: Giá trị sắp xếp của cột Ngày kết hạn(ASC or DESC)
	 * @return List<UserInfo> trả về tât cả user tìm thấy được
	 */
	public List<UserInfo> getListUser(int offset, int limit, int groupId, String fullName, String sortType, String sortByFullName, String sortByCodeName, String sortByEndDate) throws SQLException;

}
