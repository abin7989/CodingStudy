package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SWEA 2005. 파스칼의 삼각형
public class SWEA_2005 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for (int tc = 1; tc <= T; tc++) { // 테스트 케이스 수만큼 반복
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				arr[i][i] = 1;
			}
			for (int i = 0; i < N; i++) {
				arr[i][0] = 1;
			}
			
			for (int i = 2; i < N; i++) {
				for (int j = 1; j < i; j++) {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
				
			}
			sb.append("#").append(tc).append("\n");
			for (int i = 0; i < N; i++) { // N줄 만큼 출력
				for (int j = 0; j < i + 1; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");				
			}
		}
		System.out.println(sb);
	}
}
