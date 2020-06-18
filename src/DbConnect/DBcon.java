package DbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBcon {
	protected Connection dbConn=null;
	private String Name = "root";
	private String Pwd = "020314..";
	private String url="jdbc:mysql://47.96.131.195:3306/ordering?useSSL=false&serverTimezone=UTC";
	//private String url="jdbc:mysql://localhost:3306/helper?useSSL=false&serverTimezone=UTC";
	//加载驱动以及连接数据库
	protected PreparedStatement ps;
	protected ResultSet rs;
	public DBcon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection(url, Name, Pwd);
		} catch (ClassNotFoundException e) {
			System.err.println("未找到驱动");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void conClose() throws SQLException
	{
		rs.close();
		ps.close();
	}
	public void psClose() throws SQLException
	{
		ps.close();
	}

}
