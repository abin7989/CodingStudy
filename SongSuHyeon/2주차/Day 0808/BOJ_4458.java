import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4458 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			char[] arr = new char[s.length()];
			arr = s.toCharArray();
			arr[0] = Character.toUpperCase(s.charAt(0));
			
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j]);
			}
			System.out.println();
		}
		
	}
}
