/**
 * Copyright(C) 2019 [Luvina Software Company]
 * UserInfo.java Nov 19, 2019 TuoiLV
 */
package manageuser.entities;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Lớp thực thể thông tin chi tiết người dùng liên kết các bảng
 * @author TuoiLV
 */
public class UserInfo {
	//Id của user
		private int userId;
		// tên của user
		private String fullName;
		// ngày sinh của user
		private String birthDay;
		// group của user
		private String group;
		// email của user
		private String email;
		// số điện thoại của user
		private String tel;
		// trình độ tiếng Nhật
		private String japanLevel;
		// ngày hết hạn
		private String expireDate;
		// Tổng điểm của user
		private String total;
		/**
		 * @return the id
		 */
		public int getUserId() {
			return userId;
		}
		/**
		 * @param id the id to set
		 */
		public void setUserId(int userId) {
			this.userId = userId;
		}
		/**
		 * @return the fullName
		 */
		public String getFullName() {
			return fullName;
		}
		/**
		 * @param fullName the fullName to set
		 */
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		/**
		 * @return the birthDay
		 */
		public String getBirthDay() {
			return birthDay;
		}
		/**
		 * @param birthDay the birthDay to set
		 */
		public void setBirthDay(Date birthDay) {
			String pattern = "yyyy/MM/dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			this.birthDay = simpleDateFormat.format(birthDay);
		}
		/**
		 * @return the group
		 */
		public String getGroup() {
			return group;
		}
		/**
		 * @param group the group to set
		 */
		public void setGroup(String group) {
			this.group = group;
		}
		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}
		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		/**
		 * @return the tel
		 */
		public String getTel() {
			return tel;
		}
		/**
		 * @param tel the tel to set
		 */
		public void setTel(String tel) {
			this.tel = tel;
		}
		/**
		 * @return the japanLevel
		 */
		public String getJapanLevel() {
			return japanLevel;
		}
		/**
		 * @param japanLevel the japanLevel to set
		 */
		public void setJapanLevel(String japanLevel) {
			this.japanLevel = japanLevel;
		}
		/**
		 * @return the expireDate
		 */
		public String getExpireDate() {
			return expireDate;
		}
		/**
		 * @param expireDate the expireDate to set
		 */
		public void setExpireDate(String expireDate) {
			String pattern = "yyyy/MM/dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			this.expireDate = simpleDateFormat.format(birthDay);
		}
		/**
		 * @return the total
		 */
		public String getTotal() {
			return total;
		}
		/**
		 * @param total the total to set
		 */
		public void setTotal(String total) {
			this.total = total;
		}
}
