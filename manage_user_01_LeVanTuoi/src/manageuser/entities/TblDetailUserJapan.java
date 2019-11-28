/**
 * Copyright(C) 2019 [Luvina Software Company]
 * TblDetailUserJapan.java Nov 19, 2019 TuoiLV
 */
package manageuser.entities;

import java.util.Date;

/**
 * Lớp thực thể của bảng tbl_detail_user_japan
 * @author TuoiLV
 */
public class TblDetailUserJapan {
	// ID của chi tiết user
	public int detailUserJapanId;
	// ID của user
	// Khóa ngoại tham chiếu tới bảng tbl_user
	public int userId;
	// Mã level tiếng nhật
	// Khóa ngoại tham chiếu tới bảng mst_japan
	public String codeLevel;
	// Ngày cấp chứng chỉ
	public Date startDate;
	// Ngày hết hạn
	public Date endDate;
	// Tổng điểm
	public int total;
	/**
	 * @return the detailUserJapanId
	 */
	public int getDetailUserJapanId() {
		return detailUserJapanId;
	}
	/**
	 * @param detailUserJapanId the detailUserJapanId to set
	 */
	public void setDetailUserJapanId(int detailUserJapanId) {
		this.detailUserJapanId = detailUserJapanId;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
}
