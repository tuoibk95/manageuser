/**
 * Copyright(C) 2019 [Luvina Software Company]
 * MstJapanLogic.java 3:35:58 PM TuoiLV
 */
package manageuser.logics;

import java.sql.SQLException;
import java.util.List;

import manageuser.entities.MstJapan;

/**
 * @author TuoiLV
 */
public interface MstJapanLogic {
	/**
	 * Lấy tất cả japan name
	 * @return List<MstJapan>: trả về list nhóm
	 * @throws SQLException
	 * @throws ClassNotFoundException , SQLException
	 */
	public List<MstJapan> getAllMstJapan() throws SQLException , ClassNotFoundException;
}
