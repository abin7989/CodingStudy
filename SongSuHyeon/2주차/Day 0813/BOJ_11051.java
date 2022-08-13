import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11051 {
	
	static int N, K;
	static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		
		for (int i = 0; i <= N; i++) {
			arr[i][1] = i;	// i개 중 1개를 뽑는 경우의 수 = i개
			arr[i][0] = 1;	// i개중 0개를 뽑는 경우의 수 = 1개
			arr[i][i] = 1;	// i개중 i개를 선택하는 경우의 수 = 1개
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {  // 고르는 수의 개수가 전체 개수를 넘을 수 없음
				arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
				arr[i][j] = arr[i][j] % 10007;
			}
		}
		
		System.out.println(arr[N][K]);		
	}

}
