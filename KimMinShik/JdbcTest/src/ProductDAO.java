import java.util.ArrayList;

public interface ProductDAO {
	void register(ProductDTO productDTO);
	void updatePrice(ProductDTO productDTO);
	void deletePrice(ProductDTO productDTO);
	ArrayList<ProductDTO> searchById(ProductDTO productDTO);
	ArrayList<ProductDTO> searchByPrice(ProductDTO productDTO);
	ArrayList<ProductDTO> searchAll();
}
