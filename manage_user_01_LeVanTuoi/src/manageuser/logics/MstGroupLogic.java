/**
 * Copyright(C) 2019 [Luvina Software Company]
 * MstGroupLogic.java Nov 19, 2019 TuoiLV
 */
package manageuser.logics;

import java.sql.SQLException;
import java.util.List;

import manageuser.entities.MstGroup;

/**
 * Interface logic of mst_group
 * @author TuoiLV
 */
public interface MstGroupLogic {
	/**
	 * Lấy tất cả group name
	 * @return List<MstGroup>: trả về list nhóm
	 * @throws SQLException
	 * @throws ClassNotFoundException , SQLException
	 */
	public List<MstGroup> getAllMstGroup() throws SQLException;
}
