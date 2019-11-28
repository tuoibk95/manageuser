/**
 * Copyright(C) 2019  Luvina Software Company
 * MstJapan.java, 2019-11-14 TuoiLV
 */
package manageuser.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.BaseDao;
import manageuser.dao.MstJapanDao;
import manageuser.entities.MstJapan;

/**
 * Description
 * 
 * @author TuoiLV
 */
public class MstJapanDaoImpl extends BaseDao implements MstJapanDao {

	@Override
	public List<MstJapan> getAllMstJapan() throws SQLException, ClassNotFoundException {
		// Tạo đối tượng lưu danh sách group
		List<MstJapan> mstJapans = new ArrayList<MstJapan>();
		try {
			// Mở kết nối tới server
			openConnection();
			// Tạo StringBuider lưu câu lệnh MySql
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT code_level, name_level");
			sql.append(" FROM mst_japan");
			// Tạo prepared Statment
			PreparedStatement prest = conn.prepareStatement(sql.toString());
			// Lấy giá trị result ser
			ResultSet rs = prest.executeQuery();
			while (rs.next()) {
				MstJapan mstJapan = new MstJapan();
				mstJapan.setCodeLevel(rs.getString("code_level"));
				mstJapan.setNameLevel(rs.getString("name_level"));
				// thêm group vào list
				mstJapans.add(mstJapan);
			}
		} catch (SQLException e) {
			System.out.println(this.getClass().getName() + " : " + e.getMessage());
			throw e;
		} finally {
			// Đóng kết nối tới DB
			closeConnection();

		} // Trả về kết quả mst_group
		return mstJapans;
	}

}
