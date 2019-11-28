/**
 * Copyright(C) 2019 [Luvina Software Company]
 * MstGroupDaoImpl.java Nov 19, 2019 TuoiLV
 */
package manageuser.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.BaseDao;
import manageuser.dao.MstGroupDao;
import manageuser.entities.MstGroup;

/**
 * Thao tác với DB bảng mst_group
 * 
 * @author TuoiLV
 */
public class MstGroupDaoImpl extends BaseDao implements MstGroupDao{

	// Phương thức lấy tất cả thông tin từ bảng mst_group
	@Override
	public List<MstGroup> getAllMstGroup() throws SQLException {
		// Tạo đối tượng lưu danh sách group
		List<MstGroup> mstGroup = new ArrayList<MstGroup>();
		try {
			// Mở kết nối tới server
			openConnection();
			// Tạo StringBuider lưu câu lệnh MySql
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT group_id, group_name");
			sql.append(" FROM mst_group");
			// Tạo prepared Statment
			PreparedStatement prest = conn.prepareStatement(sql.toString());
			// Lấy giá trị result ser
			ResultSet rs = prest.executeQuery();
			while (rs.next()) {
				MstGroup group = new MstGroup();
				group.setGroupName(rs.getString("group_name"));
				group.setGroupId(rs.getInt("group_id"));
				// thêm group vào list
				mstGroup.add(group);
			}
		} catch (SQLException e) {
			System.out.println(this.getClass().getName() + " : " + e.getMessage());
			throw e;
		} finally {
			// Đóng kết nối tới DB
			closeConnection();
			
		}// Trả về kết quả mst_group
		return mstGroup;
	}
}
