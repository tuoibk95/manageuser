/**
 * Copyright(C) 2019 [Luvina Software Company]
 * Common.java Nov 19, 2019 TuoiLV
 */
package manageuser.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * Lớp các phương thức dùng chung
 * @author TuoiLV
 */
public class Common {
	/*
	 * Phương thức so sánh 2 password
	 * @param password: mật khẩu nhập vào 
	 * @param passDB: mật khẩu trong DB
	 * @return trả về true nếu 2 mật khẩu khớp nhau và ngược lại
	 */
	public static boolean comparePassword(String password, String passDB) {
		return password.equals(passDB);
	}

	/*
	 * Phương thức mã hóa password theo SHA-1
	 * @param password: String Mã hóa mật khẩu nhập vào
	 * @param salt: Salt dùng để mã hóa
	 * @return String Mật khẩu khi đã được mã hóa
	 */
	public static String encryptPassword(String password, String salt) {
		byte[] hashBytes = new byte[password.length()];
		try {
			// Sử dụng cách mã hóa SHA-1
			MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
			// Phương thức digest được gọi để tính toán chuỗi đầu vào và trả về dưới dạng
			// mảng của byte
			hashBytes = sha1.digest(password.getBytes());
			// Bắt và in lỗi
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e.getMessage());
		}
		// chuyển byte thành String theo Base64
		return Base64.getEncoder().encodeToString(hashBytes) + Base64.getEncoder().encodeToString(salt.getBytes());
	}

	/*
	 * Hàm check login của user
	 */
	public static String checkLogin(HttpSession session) {
		String userLogin = null;
		if (session.getAttribute("loginId") != null) {
			userLogin = (String) session.getAttribute("loginId");
		}
		return userLogin;
	}

	/*
	 * phương thức get danh sách paging
	 */
	public static List<Integer> getListPaging(int totalRecord, int limit, int currentPage) {
		// khởi tạo list lưu phân trang
		List<Integer> listPaging = new ArrayList<Integer>();
		// Tính số lượng trang
		int allPaging = (totalRecord / limit) + ((totalRecord % limit) == 0 ? 0 : 1);
		// tìm trang đầu tiên hiển thị
		int firstPage = 3 * (currentPage / 3) + ((currentPage % 3) == 0 ? -2 : 1);
		// Tìm 3 trang tiếp theo
		for (int page = firstPage; page < firstPage + 3; page++) {
			// nếu số thứ tự của trang đó nhỏ hơn số lượng trang
			if (page <= allPaging) {
				// thêm số thứ tự cảu trang đó vào list
				listPaging.add(page);
			}
		}
		// trả lại list trang
		return listPaging;
	}

	/*
	 *  get vị trí trang hiện tại
	 */
	public static int getOffSet(int currentPage, int limit) {
		return (currentPage - 1) * limit;
	}

	/*
	 * get tổng số trang 
	 */
	public static int getTotalPage(int totalUser, int limit) {
		return (totalUser / limit) + ((totalUser % limit) == 0 ? 0 : 1);
	}

	/**
	 * hàm thay thế các kí tự wildcard
	 * @param text: String cấn được thay thế
	 * @return trả về String đã được thay thế
	 */
	public static String replaceWildCard(String text) {
		// thay thế kí tự wildcard % thành \%
		text = text.replaceAll("%", "\\\\%");
		// thay thế kí tự wildcard _ thành \_
		text = text.replaceAll("_", "\\\\_");
		return text;
	}

	/**
	 * Chuyến string sang int
	 * @param stringValue: String cần chuyển đổi
	 * 		  defaultValue: giá trị mặc định nếu không chuyển được
	 * @return Integer: giá trị sau khi chuyển đổi
	 * @throws ParseException
	 */
	public static Integer ConvertStringToInt(String stringValue, int defaultValue) {
		int numberValue = defaultValue;
		try {
			numberValue = Integer.parseInt(stringValue);
		} catch (Exception e) {
			numberValue = defaultValue;
		}
		return numberValue;
	}
	
	public static List<Integer> getListYear(int startYear, int endYear) {
		List<Integer> year = new ArrayList<Integer>();
		for (int i = endYear; i >=  startYear; i--) {
			year.add(i);
		}
		return year;
	}
	
	public static int getCurrentYear() {
		Calendar calender = Calendar.getInstance();
		// lấy năm hiện tại
		int currentYear = calender.get(Calendar.YEAR);
		// trả lại năm hiện tại
		return currentYear;
	}
	
	public static List<Integer> getListMonth() {
		List<Integer> month = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			month.add(i);
		}
		return month;
	}
	
	public static List<Integer> getListDay() {
		List<Integer> day = new ArrayList<Integer>();
		for (int i = 1; i <= 31; i++) {
			day.add(i);
		}
		return day;
	}
}
