import java.sql.*;

public class Jdbc {
	
	public static void main(String[] args) {
		Jdbc a = new Jdbc();
		a.searchAll();
		
	}
	public void searchAll() {
		
		String sql = "select product_name,product_id,product_price,product_desc,date_format(register_date,\"%y.%m.%d\") as register_date from product";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			pstmt =  con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			System.out.printf("%s\t%s\t%s\t%s\t%s\n","상품이름","상품아이디","가격","설명","날짜");
			while(rs.next()) {
				String pname 	= rs.getString("product_name");
				String pid 		= rs.getString("product_id");
				int pprice		= rs.getInt("product_price");
				String pdesc	= rs.getString("product_desc");
				String pdate 	= rs.getString("register_date");
				System.out.printf("%s\t%s\t%d\t%s\t%s\n",pname,pid,pprice,pdesc,pdate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(con,pstmt,rs);
		}
	}
	
}
