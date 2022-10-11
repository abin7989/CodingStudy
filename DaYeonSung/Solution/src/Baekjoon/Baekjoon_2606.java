package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2606. 바이러스
public class Baekjoon_2606 {

	static int[][] node;
	static boolean[] visited;
	static int N, cnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		int pair = Integer.parseInt(br.readLine()); // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수
		
		node = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < pair; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			node[x][y] = 1;
			node[y][x] = 1;
		}
		
		dfs(1); // 1번 컴퓨터가 루트노드이기 때문
		
		System.out.println(cnt - 1); // 1번 컴퓨터는 빼줘야 함
	}
	
	private static void dfs(int idx) {
		visited[idx] = true;
		cnt++;
		
		for (int i = 1; i <= N; i++) {
			if (node[idx][i] == 1 && !visited[i])
				dfs(i);
		}
	}

}
