import java.sql.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class ProductDAOImpl implements ProductDAO {

	static private ProductDAOImpl productDAOImpl = new ProductDAOImpl();
	static public ProductDAOImpl getProductDAOImpl() {
		return productDAOImpl;
	}
	private ProductDAOImpl() {
	}
	
	@Override
	public void register(ProductDTO productDTO) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "insert into product(product_id,product_name,product_price,product_desc) value (?,?,?,?)";
		try {
		con = DBConnection.getConnection();
		pst = con.prepareStatement(sql);
		con.setAutoCommit(false);
		pst.setString(1,productDTO.getProductId());
		pst.setString(2,productDTO.getProductName());
		pst.setInt(3, productDTO.getProductPrice());
		pst.setString(4,productDTO.getProductDesc());
		pst.executeUpdate();
		con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(pst);
			DBConnection.returnConnection(con);
		}
	}
	@Override
	public void updatePrice(ProductDTO productDTO) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "update product set product_price = ? where product_id = ? ";
		try {
			con = DBConnection.getConnection();
		pst = con.prepareStatement(sql);
		con.setAutoCommit(false);
		pst.setInt(1, productDTO.getProductPrice());
		pst.setString(2,productDTO.getProductId());
		pst.executeUpdate();
		con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(pst);
			DBConnection.returnConnection(con);
		}
	}
	@Override
	public void deletePrice(ProductDTO productDTO) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "delete from product where product_id = ?";
		try {
			con = DBConnection.getConnection();
		pst = con.prepareStatement(sql);
		con.setAutoCommit(false);
		pst.setString(1,productDTO.getProductId());
		pst.executeUpdate();
		con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(pst);
			DBConnection.returnConnection(con);
		}
		
	}
	@Override
	public ArrayList<ProductDTO> searchById(ProductDTO productDTO) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<ProductDTO> pp = new ArrayList<>();
		String sql = "select product_id,product_name,product_price,product_desc,date_format(register_date,\"%y.%m.%d\") as register_date from product where product_id = ?";
		try {
			con = DBConnection.getConnection();
		pst = con.prepareStatement(sql);
		pst.setString(1,productDTO.getProductId());
		rs = pst.executeQuery();
		while(rs.next()) {
			ProductDTO p = new ProductDTO(rs.getString("product_id")
					,rs.getString("product_name")
					,rs.getInt("product_price")
					,rs.getString("product_desc")
					,rs.getString("register_date"));
			pp.add(p);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(pst,rs);
			DBConnection.returnConnection(con);
		}
		return pp;
		
	}
	@Override
	public ArrayList<ProductDTO> searchByPrice(ProductDTO productDTO) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<ProductDTO> pp = new ArrayList<>();
		String sql = "select product_id,product_name,product_price,product_desc,date_format(register_date,\"%y.%m.%d\") as register_date from product where product_price>=?";
		try {
			con = DBConnection.getConnection();
		pst = con.prepareStatement(sql);
		pst.setInt(1,productDTO.getProductPrice());
		rs = pst.executeQuery();
		while(rs.next()) {
			ProductDTO p = new ProductDTO(rs.getString("product_id")
					,rs.getString("product_name")
					,rs.getInt("product_price")
					,rs.getString("product_desc")
					,rs.getString("register_date"));
			pp.add(p);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(pst,rs);
			DBConnection.returnConnection(con);
		}

		return pp;
	}
	@Override
	public ArrayList<ProductDTO> searchAll() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<ProductDTO> pp = new ArrayList<>();
		String sql = "select product_id,product_name,product_price,product_desc,date_format(register_date,\"%y.%m.%d\") as register_date from product";
		try {
			con = DBConnection.getConnection();
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next()) {
			ProductDTO p = new ProductDTO(rs.getString("product_id")
					,rs.getString("product_name")
					,rs.getInt("product_price")
					,rs.getString("product_desc")
					,rs.getString("register_date"));
			pp.add(p);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(pst,rs);
			DBConnection.returnConnection(con);
		}
		return pp;
	}
}
