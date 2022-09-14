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
		makePool();
	}
	public static Connection getConnection() throws SQLException {
		if(!connectionPool.isEmpty())
			return connectionPool.poll();
		else
			return DriverManager.getConnection(URL,DB_ID,DB_PASS);
	}
	public static void returnConnection(Connection t) {
		connectionPool.offer(t);
	}
	public static void makePool() {
		for(int i = 0 ; i < 5;i++) {
			try {
				connectionPool.offer(DriverManager.getConnection(URL,DB_ID,DB_PASS));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
