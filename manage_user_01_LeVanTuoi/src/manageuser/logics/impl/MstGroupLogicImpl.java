/**
 * Copyright(C) 2019 [Luvina Software Company]
 * MstGroupLogicImpl.java Nov 19, 2019 TuoiLV
 */
package manageuser.logics.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.impl.MstGroupDaoImpl;
import manageuser.entities.MstGroup;

/**
 * Lớp xử lý logic của bảng mst_group
 * @author TuoiLV
 */
public class MstGroupLogicImpl{
	
	/**
	 * Lấy tất cả group name
	 * @return List<MstGroup>: trả về tất cả nhóm
	 * @throws SQLException
	 */
	public List<MstGroup> getAllMstGroup() throws SQLException{
		List<MstGroup> allGroup = new ArrayList<MstGroup>();
		try {
			allGroup = new MstGroupDaoImpl().getAllMstGroup();
		} catch (SQLException e) {
			System.out.println(this.getClass().getName() + " : " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return allGroup;
	}
}
