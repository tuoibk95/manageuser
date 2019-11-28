/**
 * Copyright(C) 2019 [Luvina Software Company]
 * MstJapanLogicImpl.java 3:37:56 PM TuoiLV
 */
package manageuser.logics.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.impl.MstJapanDaoImpl;
import manageuser.entities.MstJapan;
import manageuser.logics.MstJapanLogic;

/**
 * 
 * @author TuoiLv
 */
public class MstJapanLogicImpl implements MstJapanLogic {

	@Override
	public List<MstJapan> getAllMstJapan() throws SQLException, ClassNotFoundException {
		List<MstJapan> mstJapan = new ArrayList<MstJapan>();
		try {
			mstJapan = new MstJapanDaoImpl().getAllMstJapan();
		} catch (SQLException e) {
			System.out.println(this.getClass().getName() + " : " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return mstJapan;
	}
	
}
