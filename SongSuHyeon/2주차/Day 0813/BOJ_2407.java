import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_2407 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		BigInteger[][] arr = new BigInteger[101][101];
		for (int i = 0; i < 101; i++) {
			arr[i][1] = BigInteger.ONE;
			arr[i][i] = BigInteger.ONE;
			arr[i][0] = BigInteger.ONE;
		}
		
		for (int i = 2; i < 101; i++) {
			for (int j = 1; j < i; j++) {
				arr[i][j] = arr[i-1][j-1].add(arr[i-1][j]);			}
		}
		
		System.out.println(arr[n][m]);
	}

}
