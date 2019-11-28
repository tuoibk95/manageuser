/**
 * Copyright(C) 2019  Luvina Software Company
 * MessageErrorProperties.java, 2019-11-25 TuoiLV
 */
package manageuser.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Lớp đọc file message_error_ja.properties
 * @author TuoiLV
 */
public class MessageErrorProperties {
	// lưu các cặp <key, value> trong file properties
	private static Map<String, String> listMessErrorProperties = new HashMap<String, String>();
	static {
		try {
			Properties properties = new Properties(); // tạo đối tượng kiểu Properties
			properties.load(new InputStreamReader(
					MessageErrorProperties.class.getClassLoader().getResourceAsStream(Constant.PROPERTIES_MESSAGE_ERROR_PATH),
					"UTF-8")); // đọc file properties
			Enumeration<?> enumeration = properties.propertyNames(); // lưu các giá trị key trong file properties
			while (enumeration.hasMoreElements()) { // true nếu vẫn còn phần tử, false nếu tất cả phần tử đã được lấy ra
				String key = (String) enumeration.nextElement(); // key = key tiếp theo
				String value = properties.getProperty(key); // lấy value tương ứng với key
				listMessErrorProperties.put(key, value); // thêm vào list
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Lấy value tương ứng với key trong file properties
	 * @param key tên key trong file properties
	 * @return trả về value tương ứng với key
	 */
	public static String getValueByKey(String key) {
		String value = listMessErrorProperties.get(key);
		return value;
	}
}
