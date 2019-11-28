/**
 * Copyright(C) 2019  Luvina Software Company
 * DatabaseProperties.java, 2019-11-25 TuoiLV
 */
package manageuser.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Lớp đọc file database.properties
 * @author TuoiLV
 */
public class DatabaseProperties {
	// lưu các cặp <key, value> trong file properties
	private static Map<String, String> listDBProperties = new HashMap<String, String>();
	static {
		try {
			Properties properties = new Properties(); // tạo đối tượng kiểu Properties
			properties.load(new InputStreamReader(
					DatabaseProperties.class.getClassLoader().getResourceAsStream(Constant.PROPERTIES_DATABASE_PATH),
					"UTF-8")); // đọc file properties
			Enumeration<?> enumeration = properties.propertyNames(); // lưu các giá trị key trong file properties
			while (enumeration.hasMoreElements()) { // true nếu vẫn còn phần tử, false nếu tất cả phần tử đã được lấy ra
				String key = (String) enumeration.nextElement(); // key = key tiếp theo
				String value = properties.getProperty(key); // lấy value tương ứng với key
				listDBProperties.put(key, value); // thêm vào list
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Lấy value tương ứng với key trong file properties
	 * @param key tên key trong file properties
	 * @return trả về value tương ứng với key
	 */
	public static String getValueByKey(String key) {
		String value = listDBProperties.get(key);
		return value;
	}
}
