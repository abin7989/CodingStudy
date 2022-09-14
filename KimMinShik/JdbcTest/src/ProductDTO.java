
public class ProductDTO {
	private String productId;
	private String productName;
	private int productPrice;
	private String productDesc;
	private String productDate;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}
	public ProductDTO(String productId, String productName, int productPrice, String productDesc, String productDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDesc = productDesc;
		this.productDate = productDate;
	}
	

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}
	@Override
	public String toString() {
		return String.format("%s\t%s\t%d\t%s\t%s\t",productId,productName,productPrice,productDesc,productDate);
	}

	
}
