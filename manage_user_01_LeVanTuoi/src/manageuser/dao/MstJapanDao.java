/**
 * Copyright(C) 2019  Luvina Software Company
 * MstJapanDao.java, 2019-11-14 TuoiLV
 */
package manageuser.dao;

import java.sql.SQLException;
import java.util.List;

import manageuser.entities.MstJapan;

/**
 * Description
 * @author TuoiLV
 */
public interface MstJapanDao {
	/**
	 * lấy ra các japan trong database
	 * @return list<MstJapan> trả lại các group có trong db
	 * @throws ClassNotFoundException 
	 */
	public List<MstJapan> getAllMstJapan() throws SQLException, ClassNotFoundException;
}
