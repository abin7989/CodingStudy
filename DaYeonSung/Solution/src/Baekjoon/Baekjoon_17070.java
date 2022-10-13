package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 17070. 파이프 옮기기 1
public class Baekjoon_17070 {

	static int N;
	static int cnt = 0;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 집의 크기
		
		map = new int[N][N];
		
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 파이프는 총 3가지 방향이 가능
		// 가로로 2개 → (이동 방법 2가지)
		// 세로로 2개  (이동 방법 2가지)
		// 가로 세로 2개씩 총 4개 ↘ (이동 방법 3가지)
		// 회전은 45도만 회전시킬 수 있으며, 미는 방향은 오른쪽, 아래, 또는 오른쪽 아래 대각선 방향이어야 한다.
		
		int direction = 1; // 초기 상태 가로로 되어 있으니 1이라 한다. 세로, 대각선은 각각 2, 3
		dfs(0, 1, direction);
		
		System.out.println(cnt);

	}

	private static void dfs(int r, int c, int direction) {
		if (r == N-1 && c == N-1) {
			cnt++; // 목적지 도달했다면 true 리턴
			return;
		}
		if (direction == 1) { // 현재 가로로 놓여있다면
			if (c + 1 <= N - 1 && map[r][c + 1] == 0) dfs(r, c + 1, 1); // →
		} else if (direction == 2) { // 현재 세로로 놓여있다면
			if (r + 1 <= N - 1 && map[r + 1][c] == 0) dfs(r + 1, c, 2); // ↓
		} else { // 현재 대각선으로 놓여있다면
			if (c + 1 <= N - 1 && map[r][c + 1] == 0) dfs(r, c + 1, 1); // →
			if (r + 1 <= N - 1 && map[r + 1][c] == 0) dfs(r + 1, c, 2); // ↓
		}
		
		// 어떤 경우에서든지 대각선 검사는 해야해서 따로 빼줌
		if (r + 1 <= N - 1 && c + 1 <= N - 1 && map[r][c + 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0)
			dfs(r + 1, c + 1, 3);
	}
	
}
