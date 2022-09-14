import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DMLTest {
	public static void main(String[] args) {
		DMLTest dmlTest = new DMLTest();
		dmlTest.insertProduct("A123","B",4000,"비싸다");
		dmlTest.updateProduct("A123",3000000);
		dmlTest.deleteProduct("A123");
	}

	private void deleteProduct(String product_id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.getConnection();
			con.setAutoCommit(false);
			String sql = "delete from product where product_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product_id);
			int cnt  = pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con,pstmt);
		}
	}

	private void updateProduct(String product_id, int product_price) {
		// TODO Auto-generated method stub
				Connection con = null;
				PreparedStatement pstmt = null;
				try {
					con = DBConnection.getConnection();
					con.setAutoCommit(false);
					String sql = "update product set product_price = ? where product_id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, product_price);
					pstmt.setString(2, product_id);
					int cnt  = pstmt.executeUpdate();
					con.commit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DBClose.close(con,pstmt);
				}
		
	}

	private void insertProduct(String product_id, String product_name, int product_price, String product_desc) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.getConnection();
			con.setAutoCommit(false);
			String sql = "insert into product(product_id,product_name,product_price,product_desc) \r\n" + 
					"value (?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product_id);
			pstmt.setString(2, product_name);
			pstmt.setInt(3, product_price);
			pstmt.setString(4, product_desc);
			int cnt  = pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con,pstmt);
		}
		
	}
}
