import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;

public class DBConnection {
	static private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	static private final String URL = "jdbc:mysql://127.0.0.1:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	static private final String DB_ID = "ssafy";
	static private final String DB_PASS = "ssafy";
	static private Queue<Connection> connectionPool = new ArrayDeque<>(); 
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
			return DriverManager.getConnection(URL,DB_ID,DB_PASS);
	}
}
