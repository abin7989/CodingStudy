package Baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 3197. 백조의 호수
public class Baekjoon_3197 {
	
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static Point[] swan;
	static Queue<int[]> swanQ;
    static Queue<int[]> waterQ;
    
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		swan = new Point[2];
		
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		swanQ = new LinkedList<>();
		waterQ = new LinkedList<>();
		visited = new boolean[R][C];
		
		
		int idx = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'L') {
					map[r][c] = '.';
					swan[idx++] = new Point(r, c);
				}
				if (map[r][c] == '.') {
					waterQ.offer(new int[] {r, c});
				}
			}
		}
		
		swanQ.offer(new int[] {swan[0].x, swan[0].y});
		visited[swan[0].x][swan[0].y] = true;
				
		int days = 0;
		
		while(true) {
			boolean meet = go();
			if (meet) break;
			melt();
			days++;
		}

		System.out.println(days);
	}
	
	private static void melt() {
		int size = waterQ.size();
		for (int i = 0; i < size; i++) {
			int[] poll = waterQ.poll();
			int pollR = poll[0];
			int pollC = poll[1];
			
			for (int j = 0; j < 4; j++) {
				int nr = pollR + dr[j];
				int nc = pollC + dc[j];
				
				if (nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] == 'X') {
					map[nr][nc] = '.';
					waterQ.offer(new int[] {nr, nc});
				}
			}
				
		}
	}
	
	private static boolean go() {
		Queue<int[]> nextQ = new LinkedList<>();
		
		while (!swanQ.isEmpty()) {
			int[] poll = swanQ.poll();
			int pollR = poll[0];
			int pollC = poll[1];
			
			if (pollR == swan[1].x && pollC == swan[1].y) return true;
			
			for (int i = 0; i < 4; i++) {
				int nr = pollR + dr[i];
				int nc = pollC + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
								
				if (map[nr][nc] == '.') {
					swanQ.offer(new int[] {nr, nc});
				} else { // 다음 날 얼음이 녹아 백조가 지나갈 수도 있다
					nextQ.offer(new int[] {nr, nc});
				}
			}
		}
		
		swanQ = nextQ; // swanQ를 다음날 탐색할 지역이 담긴 nextQ로 바꿈
		return false;
	}

}