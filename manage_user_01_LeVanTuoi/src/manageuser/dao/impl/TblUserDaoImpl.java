/**
 * Copyright(C) 2019 [Luvina Software Company]
 * TblUserDaoIpl.java Nov 19, 2019 TuoiLV
 */
package manageuser.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.BaseDao;
import manageuser.dao.TblUserDao;
import manageuser.entities.TblUser;
import manageuser.entities.UserInfo;

/**
 * Thao tác với bảng tbl_user trong DB
 * @author TuoiLV
 */
public class TblUserDaoImpl extends BaseDao implements TblUserDao {
	/*
	 * Phương thức lấy tên tài khoản của user
	 * @param loginName: Tài khoản user 
	 * @return trả về tài khoản user
	 */
	@Override
	public TblUser getUserByLoginName(String loginName) throws SQLException {
		// Khởi tạo user
		TblUser user = null;
		try {
			// Mở kết nối tới DB
			openConnection();
			// Tạo StringBuilder cho câu lệnh SQL
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT login_name, password, salt");
			sql.append(" FROM tbl_user");
			sql.append(" WHERE login_name = ? ");
			// Tạo PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, loginName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// Khởi tạo đối tượng user khi tồn tại trong DB
				user = new TblUser();
				// lấy password của user đó
				user.setPassword(rs.getString("password"));
				// lấy salt của user đó
				user.setSalt(rs.getString("salt"));
			}
		} catch (SQLException e) {
			System.out.println(this.getClass().getName() + " : " + e.getMessage());
			throw e;
		} finally {
			// đóng kết nối tới database
			closeConnection();
			
		} return user;
	}

	/**
	 * Tìm kiếm số lượng của user theo groupId và fullname
	 * @param groupId:  Id của nhóm cần tìm kiếm
	 * @param fullName: tên của user cần tìm kiếm
	 * @return trả về số lượng user tìm thấy từ DB
	 */
	@Override
	public int getTotalUser(int groupId, String fullName) throws SQLException {
		int totalUsers = 0;
		try {
			// Mở kết nối tới server
			openConnection();
			// tạo String builder cho câu lệnh SQL
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT count(*) as totaluser");
			sql.append(" FROM tbl_user");
			sql.append(" WHERE");
			// Nếu full_name rỗng
			if ("".equals(fullName)) {
				sql.append(" full_name LIKE '%' ");
				// Nếu full_name có giá trị
			} else {
				sql.append(" full_name LIKE ? ");
			}
			// Nếu group_id k phải giá trị default 0
			if (groupId != 0) {
				sql.append(" AND group_id = ? ");
			}
			// user
			sql.append(" AND rule = 1 ");
			// Tạo một đối tượng PrepareStatement
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			if (!"".equals(fullName)) {
				// set giá trị tham số fullName thứ 1
				ps.setString(1, '%' + fullName + '%');
			}

			// Nếu mã nhóm khác 0
			if (groupId != 0) {
				// Nếu fullName rỗng
				if ("".equals(fullName)) {
					// set giá trị tham số groupId thứ 1
					ps.setInt(1, groupId);
				} else {
					// set giá trị tham số fullName thứ 1
					ps.setString(1, '%' + fullName + '%');
					// set giá trị tham số groupId thứ 2
					ps.setInt(2, groupId);
				}
			}
			ResultSet rs = ps.executeQuery();
			// Duyệt trên dữ liệu trả về
			while (rs.next()) {
				// lấy dữ liệu totaluser
				totalUsers = rs.getInt("totaluser");
			}
		} catch (SQLException e) {
			System.out.println(this.getClass().getName() + " : " + e.getMessage());
			throw e;
		} finally {
			// Đóng kết nối tới server
			closeConnection();
			
		}// Trả về số lượng user
		return totalUsers;
	}

	/**
	 * lấy ra tất cả các user theo fullname và groupId
	 * @param int              offset vị trí data cần lấy nào
	 * @param offset           vị trí data cần lấy nào
	 * @param limit            số lượng lấy
	 * @param groupId          mã nhóm tìm kiếm
	 * @param fullName         Tên tìm kiếm
	 * @param sortType:        Nhận biết xem cột nào được ưu tiên sắp xếp(full_name
	 *                         or end_date or code_level)
	 * @param sortByFullName:  Giá trị sắp xếp của cột Tên(ASC or DESC)
	 * @param sortByCodeLevel: Giá trị sắp xếp của cột Trình độ tiếng nhật(ASC or
	 *                         DESC)
	 * @param sortByEndDate:   Giá trị sắp xếp của cột Ngày kết hạn(ASC or DESC)
	 * @return List<UserInfo> trả về tât cả user tìm thấy được
	 */
	@Override
	public List<UserInfo> getListUser(int offset, int limit, int groupId, String fullName, String sortType, String sortByFullName, String sortByCodeName, String sortByEndDate) throws SQLException {
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		try {
			// Mở kết nối tới server
			openConnection();
			//Tạo StringBuider lưu câu lệnh MySql
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT u.user_id,u.full_name, birthday, g.group_name,u.email,u.tel, j.name_level, tduj.end_date, tduj.total");
			sql.append(" FROM tbl_user u");
			sql.append(" INNER JOIN mst_group g ON u.group_id = g.group_id");
			sql.append(" LEFT JOIN tbl_detail_user_japan tduj ON tduj.user_id = u.user_id");
			sql.append(" LEFT JOIN mst_japan j ON j.code_level = tduj.code_level");
			sql.append(" WHERE u.rule = '1'");
			// nếu tên là rỗng
			if ("".equals(fullName)) {
				sql.append(" AND full_name LIKE '%'");
			} else { // nếu name có giá tri
				sql.append(" AND full_name LIKE ? ");
			}
			// nếu id của group không phải giá trị default
			if (groupId != 0) {
				sql.append(" AND u.group_id = ? ");
			}
			// sắp xếp theo trường
			sql.append(" ORDER BY" + sortField(sortType, sortByFullName, sortByCodeName, sortByEndDate));
			// giới hạn bản ghi
			sql.append(" LIMIT " + limit);
			// offset
			sql.append(" OFFSET " + offset);
			// tạo preparedStatement
			PreparedStatement prest = conn.prepareStatement(sql.toString());
			// thay thế wildcard
			if (!"".equals(fullName)) {
				prest.setNString(1, '%' + fullName + '%'); 
			} 
			if (groupId != 0) {
				if ("".equals(fullName)) {
					prest.setInt(1, groupId); 
				} else {
					prest.setNString(1, '%' + fullName + '%'); 
					prest.setInt(2, groupId); 
				}
			} 
			// thực hiện prepared statement
			ResultSet rs = prest.executeQuery();
			while(rs.next()) {
				// khởi tạo đối tượng userÌno khi tồn tại trong db
				UserInfo userInfo  = new UserInfo();
				//  set giá trị cho thuộc tính Id
				userInfo.setUserId(rs.getInt("user_id"));
				// set giá trị cho thuộc tính full name
				userInfo.setFullName(rs.getString("full_name"));
				// set giá trị cho thuộc tính birthDay
				userInfo.setBirthDay(rs.getDate("birthDay"));
				// set giá trị cho thuộc tính group
				userInfo.setGroup(rs.getString("group_name"));
				// set giá trị cho thuộc tính email
				userInfo.setEmail(rs.getString("email"));
				// set giá trị cho thuộc tính tel
				userInfo.setTel(rs.getString("tel"));
				// thêm userInfo vừa mới tìm được vào list
				userInfos.add(userInfo);
			}
		} catch (SQLException e) {
			System.out.println(this.getClass().getName() + " :" + e.getMessage());
			throw e;
		} finally {
			// đóng kết nối tới database
			closeConnection();
			
		}return userInfos;
	}
	
	/**
	 * Tạo ra prepared statement để sắp xếp theo trường
	 * @param sortType: trường sắp xếp
	 * 		  sortByFullName: sắp xếp theo full name
	 * 		  sortByCodeLevel: sắp xếp theo trình độ tiếng nhật
	 * 		  sortByEndDate: sắp xếp theo ngày hết hạn
	 * @return String: câu lệnh SQL tương ứng
	 */
	public String sortField(String sortType, String sortByFullName, String sortByCodeName, String sortByEndDate) {
		StringBuilder sql = new StringBuilder();
		switch (sortType) {
			case "fullName":
				sql.append("  u.full_name " + sortByFullName);
				sql.append(", j.name_level " + sortByCodeName);
				sql.append(", tduj.end_date " + sortByEndDate);
				break;
			case "codeLevel":
				sql.append(" j.name_level " + sortByCodeName);
				sql.append(", u.full_name " + sortByFullName);
				sql.append(", tduj.end_date " + sortByEndDate);
				break;
			case "expireDate":
				sql.append(" tduj.end_date " + sortByEndDate);
				sql.append(", u.full_name " + sortByFullName);
				sql.append(", j.name_level " + sortByCodeName);
				break;
		}
		return sql.toString();
	}
}
