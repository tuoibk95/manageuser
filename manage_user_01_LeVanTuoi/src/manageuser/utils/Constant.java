/**
 * Copyright(C) 2019 [Luvina Software Company]
 * Common.java Nov 19, 2019 TuoiLV
 */
package manageuser.utils;
/**
 * Lớp chứa các constant
 * 
 * @author TuoiLV
 */
public class Constant {
	// giới hạn record trong 1 trang
	public static final int LIMIT = 5;
	// giới hạn trang trong phân trang
	public static final int LIMIT_PAGE = 3;
	// tên của user cần tìm kiếm
	public static String nameSearch = "";
	// group Id cần tìm kiếm
	public static int groupIdSearch = 0;
	// đương dẫn đến file ADM001.jsp
	public static final String ADM001_URL = "/Login";
	// đương dẫn đến file LoginController.java
	public static final String LOGIN_URL = "/Login.do";
	// đương dẫn đến file ADM002.jsp
	public static final String ADM002_URL = "/ListUser";
	// đương dẫn đến file LoginController.java
	public static final String LISTUSER_URL = "/ListUser.do";
	// đương dẫn đến file ADM001.jsp
	public static final String ADM003_URL = "/AddUserInput";
	// đương dẫn đến file LoginController.java
	public static final String ADD_USER_URL = "/AddUserInput.do";
	// đương dẫn đến file ADM002.jsp
	public static final String ERROR_URL = "/error";

	// SẮp xếp full_name tăng dần
	public static final String SORT_BY_FULLNAME_DEFAULT = "ASC";
	// Sắp xếp trình độ tiếng nhật tăng dần
	public static final String SORT_BY_CODELEVEL_DEFAULT = "ASC";
	// Sắp xếp ngày hết hạn giảm dần
	public static final String SORT_BY_EXPIREDATE_DEFAULT = "DESC";

	// tìm kiếm mặc định theo group_id
	public static final int GROUP_ID_DEFAULT = 0;
	// tìm kiếm mặc định theo full name
	public static final String FULL_NAME_DEFAULT = "";

	// Khai báo hằng số đọc file properties
	public static final String PROPERTIES_DATABASE_PATH = "manageuser/properties/database.properties";
	// Khai báo hằng số đọc file properties
	public static final String PROPERTIES_MESSAGE_PATH = "manageuser/properties/message_ja.properties";
	// Khai báo hằng số đọc file properties
	public static final String PROPERTIES_MESSAGE_ERROR_PATH = "manageuser/properties/message_error_ja.properties";
	// sắp xếp mặc định là theo full name
	public static final String SORT_TYPE_DEFAULT = "fullName";
	// current page mặc định
	public static final int CURRENT_PAGE_DEFAULT = 1;
	
	// start year
	public static final int START_YEAR = 1990;
	// các giá trị default của userInfo
	public static final String USER_FULL_NAME_DEFAULT = "";
}
