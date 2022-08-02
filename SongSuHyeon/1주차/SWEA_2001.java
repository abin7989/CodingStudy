import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s," ");
			int N = Integer.valueOf(st.nextToken());
			int M = Integer.valueOf(st.nextToken());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s2 = br.readLine();
				StringTokenizer st2 = new StringTokenizer(s2, " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.valueOf(st2.nextToken());
				}
			}
			
			int res = 0;
			for (int i = 0; i < N-M+1; i++) {
				for (int j = 0; j < N-M+1; j++) {
					int sum_tmp = 0;
					for (int x = 0; x < M; x++) {
						for (int y = 0; y < M; y++) {
							sum_tmp += arr[i+x][j+y];
						}
					}
					
					if (sum_tmp > res) res = sum_tmp;
				}
			}
			sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}
