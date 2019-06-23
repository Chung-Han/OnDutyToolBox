package idv.autumn.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataSets {
	public static Statement stmt = null;
	public static ResultSet res = null;
	public static Connection conn = null;
	public static ArrayList<DataInfo> list = new ArrayList<DataInfo>();

	public static ArrayList<DataInfo> getDataInfo(String driverUrl, String connString, String username, String password, String sql) {
		try {
			conn = JdbcUtils.getConnection(driverUrl, connString, username, password);
			stmt = conn.createStatement();
			res = stmt.executeQuery(sql);
			while (res.next()) {
				DataInfo data = new DataInfo();
				data.setId(res.getInt("employee_id"));
				data.setName(res.getString("first_name"));
				data.setAge(res.getInt("salary"));
				data.setSex(res.getString("job_id"));
				list.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	// list to json
	public static String dataJson(ArrayList<DataInfo> list) {
		String json = "{\"people\":[";
		for (DataInfo dataInfo : list) {
			String line = "{\"name\":\"" + dataInfo.getName() + "\",\"id\":" + dataInfo.getId() + "," + "\"age\":"
					+ dataInfo.getAge() + "," + "\"sex\":" + dataInfo.getSex() + "}," + "\r\n";
			json = json + line;
		}
		json = json.substring(0, json.length() - 3);
		json = json + "]}";
		return json;

	}
}