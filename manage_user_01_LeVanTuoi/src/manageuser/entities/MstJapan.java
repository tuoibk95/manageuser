/**
 * Copyright(C) 2019 [Luvina Software Company]
 * MstJapan.java Nov 19, 2019 TuoiLV
 */
package manageuser.entities;

/**
 * Lớp thực thể của bảng mst_japan
 * @author TuoiLV
 */
public class MstJapan {
	// Mã level tiếng nhật
	public String codeLevel;
	// Tên level tiếng nhật
	public String nameLevel;
	/**
	 * @return the codeLevel
	 */
	public String getCodeLevel() {
		return codeLevel;
	}
	/**
	 * @param codeLevel the codeLevel to set
	 */
	public void setCodeLevel(String codeLevel) {
		this.codeLevel = codeLevel;
	}
	/**
	 * @return the nameLevel
	 */
	public String getNameLevel() {
		return nameLevel;
	}
	/**
	 * @param nameLevel the nameLevel to set
	 */
	public void setNameLevel(String nameLevel) {
		this.nameLevel = nameLevel;
	}
}
