/**
 * Copyright(C) 2019 [Luvina Software Company]
 * MstGroupDao.java Nov 19, 2019 TuoiLV
 */
package manageuser.dao;

import java.sql.SQLException;
import java.util.List;

import manageuser.entities.MstGroup;

/**
 * Thao tác DB bảng mst_group
 * @author TuoiLV
 */
public interface MstGroupDao {
	/**
	 * lấy ra các group trong database
	 * @return list<MstGroup> trả lại các group có trong db
	 * @throws ClassNotFoundException 
	 */
	public List<MstGroup> getAllMstGroup() throws SQLException, ClassNotFoundException;
}	
