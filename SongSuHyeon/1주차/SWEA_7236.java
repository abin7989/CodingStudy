import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7236 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.valueOf(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.valueOf(br.readLine());
			String[][] arr = new String[N + 2][N + 2];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					arr[i][j] = st.nextToken();
				}
			}
			
			int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
			int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

			int[][] cmp = new int[N + 2][N + 2];
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					int cnt_G = 0, cnt_W = 0;
					if (arr[r][c].equals("W")) {
						for (int k = 0; k < 8; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							
							if (arr[nr][nc] != null && arr[nr][nc].equals("G")) {
								cnt_G++;
							} else if(arr[nr][nc] != null && arr[nr][nc].equals("W")){
								cnt_W++;
							}
						}
					}
					
					if (cnt_G == 8) {
						cmp[r][c] = 1;
					} else {
						cmp[r][c] = cnt_W;
					}
				}
			}

			int max = 0;
			for (int i = 0; i < cmp.length; i++) {
				for (int j = 0; j < cmp.length; j++) {
					if (max < cmp[i][j])
						max = cmp[i][j];
				}
			}
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		} // end of test_case
		System.out.println(sb);
	} // end of main
} // end of class