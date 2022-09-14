import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ProductMain {
	private BufferedReader br;
	
	public ProductMain() {
		br = new BufferedReader(new InputStreamReader(System.in));
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new ProductMain().menu();
	}
	private void menu() throws NumberFormatException, IOException {
		int num;
		boolean pass = true;
		while(pass) {
			System.out.println("==================메뉴선택==================");
			System.out.println("1. 등록");
			System.out.println("2. 가격변경");
			System.out.println("3. 제품 삭제");
			System.out.println("4. 아이디로 검색");
			System.out.println("5. 가격으로 검색(~원 이상)");
			System.out.println("6. 모든 상품 검색");
			System.out.println("0. 종료");
			System.out.println("=========================================");
			num= Integer.parseInt(br.readLine());
			switch (num) {
			case 1: register();			break;
			case 2: updatePrice(); 		break;
			case 3: deletePrice();		break;
			case 4: searchById(); 		break;
			case 5: searchByPrice();	break;
			case 6: searchAll(); 		break;
			case 0: pass=false; 		break;
			}
		}
		System.out.println("===================종료===================");
	}
	private void searchAll() {
		System.out.println("==모든상품검색==");
		ProductDAO dao = ProductDAOImpl.getProductDAOImpl();
		ArrayList<ProductDTO> pl =dao.searchAll();
		for(ProductDTO p : pl) {
			System.out.println(p);
		}
	}
	private void searchByPrice() throws NumberFormatException, IOException {
		System.out.println("==가격으로검색==");
		System.out.print("기준 가격 : ");
		int productPrice = Integer.parseInt(br.readLine());
		ProductDTO productDTO = new ProductDTO("", "",productPrice,"","");
		ProductDAO dao = ProductDAOImpl.getProductDAOImpl();
		ArrayList<ProductDTO> pl =dao.searchByPrice(productDTO);
		for(ProductDTO p : pl) {
			System.out.println(p);
		}
	}
	private void searchById() throws IOException {
		System.out.println("==제품삭제==");
		System.out.print("상품 아이디 : ");
		String productId = br.readLine();
		ProductDTO productDTO = new ProductDTO(productId, "",0,"","");
		ProductDAO dao = ProductDAOImpl.getProductDAOImpl();
		ArrayList<ProductDTO> pl =dao.searchById(productDTO);
		for(ProductDTO p : pl) {
			System.out.println(p);
		}
	}
	private void deletePrice() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("==제품삭제==");
		System.out.print("상품 아이디 : ");
		String productId = br.readLine();
		ProductDTO productDTO = new ProductDTO(productId, "",0,"","");
		ProductDAO dao = ProductDAOImpl.getProductDAOImpl();
		dao.deletePrice(productDTO);
	}
	private void updatePrice() throws IOException {
		System.out.println("==가격변경==");
		System.out.print("상품 아이디 : ");
		String productId = br.readLine();
		System.out.print("변경 가격 : ");
		int productPrice = Integer.parseInt(br.readLine());
		ProductDTO productDTO = new ProductDTO(productId, "", productPrice, "","");
		ProductDAO dao = ProductDAOImpl.getProductDAOImpl();
		dao.updatePrice(productDTO);
		
	}
	private void register() throws IOException {
		System.out.println("==상품등록==");
		System.out.print("상품 아이디 : ");
		String productId = br.readLine();
		System.out.print("상품 이름 : ");
		String productName = br.readLine();
		System.out.print("상품 가격 : ");
		int productPrice = Integer.parseInt(br.readLine());
		System.out.print("상품 설명 : ");
		String productDesc = br.readLine();
		ProductDTO productDTO = new ProductDTO(productId, productName, productPrice, productDesc,"");
		ProductDAO dao = ProductDAOImpl.getProductDAOImpl();
		dao.register(productDTO);
	}	
}
