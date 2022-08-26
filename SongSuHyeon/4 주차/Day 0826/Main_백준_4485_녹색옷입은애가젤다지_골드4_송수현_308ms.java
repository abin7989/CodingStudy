import java.util.*;
import java.io.*;

public class Main_백준_4485_녹색옷입은애가젤다지_골드4_송수현_308ms {
	static int[][] map, cost;
	static int N;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static StringTokenizer st;
	static StringBuilder sb =new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = 1;
		
		while (true) {
			
			N = Integer.parseInt(br.readLine());
			
			if (N == 0)
				break;
			
			map = new int[N][N];
			cost = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
			
			cost[0][0] = map[0][0];
			
			bfs();
			
			sb.append("Problem ").append(testCase).append(": ").append(cost[N - 1][N - 1]).append("\n");
			testCase++;
		}
		System.out.println(sb);
	}

	private static void bfs() {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0, 0});
		
		while (!queue.isEmpty()) {
			
			int nr, nc;		
			int[] pos = queue.poll();
			
			int r = pos[0];
			int c = pos[1];
			
			for (int i = 0; i < 4; i++) {
				nr = r + dx[i];
				nc = c + dy[i];
				
				if (!isRange(nr, nc))
					continue;
				
				if (cost[nr][nc] <= cost[r][c] + map[nr][nc])
					continue;
				
				cost[nr][nc] = cost[r][c] + map[nr][nc];
				queue.add(new int[] {nr, nc});
			}
		}
	}

	private static boolean isRange(int x, int y) {
		return x < 0 || y < 0 || x >= N || y >= N ? false : true;
	}

}