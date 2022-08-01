import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1979 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int N = Integer.valueOf(st.nextToken());
			int K = Integer.valueOf(st.nextToken());
			int[][] arr = new int[N + 2][N + 2];

			for (int i = 1; i < arr.length - 1; i++) {
				String s2 = br.readLine();
				StringTokenizer st2 = new StringTokenizer(s2);
				for (int j = 1; j < arr.length - 1; j++) {
					arr[i][j] = Integer.valueOf(st2.nextToken());
				}
			}

			int cnt = 0;
			for (int i = 1; i < arr.length - 1; i++) {  // 가로 검색
				int tmp_cnt = 0;
				for (int j = 1; j < arr.length - 1; j++) {
					if(arr[i][j] == 1 && arr[i][j+1] == 1) {
						tmp_cnt++;
					} else if(arr[i][j] == 1 && arr[i][j+1] == 0) {
						tmp_cnt++;
						if(tmp_cnt == K) cnt++;
						tmp_cnt = 0;
					}
				}
			}
			
			for (int i = 1; i < arr.length-1; i++) {
				int tmp_cnt = 0;
				for (int j = 1; j < arr.length-1; j++) {
					if(arr[j][i] == 1 && arr[j+1][i] == 1) {
						tmp_cnt++;
					} else if(arr[j][i] == 1 && arr[j+1][i]==0) {
						tmp_cnt++;
						if(tmp_cnt == K) cnt++;
						tmp_cnt = 0;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + cnt);
		} // end of test_case

	} // end of main
} // end of class
