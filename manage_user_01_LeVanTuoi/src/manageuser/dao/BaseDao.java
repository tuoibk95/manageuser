/**
 * Copyright(C) 2019 [Luvina Software Company]
 * BaseDao.java Nov 19, 2019 TuoiLV
 */
package manageuser.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import manageuser.utils.DatabaseProperties;

/**
 * Lớp mở đóng kết nối tới Server
 * @author TuoiLV
 */
public class BaseDao {
	// khai báo user của localhost
	private static final String USER = DatabaseProperties.getValueByKey("user");
	// khai báo mật khẩu của localhost
	private static final String PASS = DatabaseProperties.getValueByKey("pass");
	// khai báo mật khẩu của localhost
	private static final String DATABASE = DatabaseProperties.getValueByKey("url");
	// Khai báo driver của localhost
	private static final String DRIVER = DatabaseProperties.getValueByKey("driver");

	// Khai báo connection
	protected static Connection conn;

	// Kết nối tới DB
	public void openConnection() {
		try {
			// Nạp class cho database
			Class.forName(DRIVER);
			// Kết nối tới DB
			conn = DriverManager.getConnection(DATABASE, USER, PASS);
		} catch (SQLException | ClassNotFoundException ex) {
			// nếu không kết nối được thì catch
			System.out.println(this.getClass().getName() + " " + this.getClass().getMethods() + ex.getMessage());
		}
	}

	/**
	 * đóng kết nối tới Server
	 * @throws SQLException 
	 */
	public void closeConnection() throws SQLException {
		try {
			// Kết nối chưa được đóng
			if (!conn.isClosed()) {
				// Đóng kết nối
				conn.close();
			}
		} catch (SQLException ex) {
			System.out.println(this.getClass().getName() + " " + this.getClass().getMethods() + ex.getMessage());
//			System.out.println("Đóng kết nối thất bại");
			throw ex;
		} catch (NullPointerException ex) {
			System.out.println(this.getClass().getName() + " " + this.getClass().getMethods() + ex.getMessage());
//			System.out.println("Server không tìm thấy hoặc chưa kết nối");
			throw ex;
		}
	}
}
