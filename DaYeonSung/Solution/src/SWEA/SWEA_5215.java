package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 5215. 햄버거 다이어트
public class SWEA_5215 {
	static int N, L;
	static int[][] ingr;
	static int maxScore;
	
	static void hamburger(int idx, int score, int cal) {
		if (cal > L) return;
		if (cal <= L) {
			maxScore = Math.max(score, maxScore);
		}
		if (idx == N) return;
		hamburger(idx + 1, score + ingr[idx][0], cal + ingr[idx][1]); // 이 재료 사용
		hamburger(idx + 1, score, cal); // 이 재료 사용 X
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			
			ingr = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ingr[i][0] = Integer.parseInt(st.nextToken()); // 재료에 대한 민기의 맛에 대한 점수
				ingr[i][1] = Integer.parseInt(st.nextToken()); // 재료 칼로리
			}
			
			maxScore = 0;
			hamburger(0, 0, 0);
			
			sb.append("#").append(tc).append(" ").append(maxScore).append("\n");
		}
		System.out.println(sb);
	}
}
