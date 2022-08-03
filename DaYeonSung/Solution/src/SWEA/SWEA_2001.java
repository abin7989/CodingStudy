package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 2001. 파리 퇴치
public class SWEA_2001 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine()); 
			int N = Integer.parseInt(st.nextToken()); // 배열 크기
			int M = Integer.parseInt(st.nextToken()); // 파리채 크기
			int[][] arr = new int[N][N]; // N * N 배열 선언
//			2차원 배열 입력 받기
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}

//			M * M 배열 크기의 파리채로 N * N 배열 범위 벗어나지 않도록 훑으면서
//			잡을 수 있는 파리의 최대값 구하기			
			int max = 0; // 파리 최대값의 초기값
			for (int j = 0; j < N - M + 1; j++) {
				for (int k = 0; k < N - M + 1; k++) {
					int cnt = 0;
					for (int p1 = 0; p1 < M; p1++) {
						for (int p2 = 0; p2 < M; p2++) {
							cnt += arr[j + p1][k + p2];
						}
					}
					if (cnt > max) {
						max = cnt;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
