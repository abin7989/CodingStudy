package Baekjoon;

import java.io.*;
import java.util.*;

// 백준 1326. 폴짝폴짝
public class Baekjoon_1326 {
		
	static class Frog {
		int idx, jump;
		
		public Frog(int idx, int jump) {
			this.idx = idx; // 현재 위치
			this.jump = jump; // 누적 점프 횟수
		}
	}
	
	static int N, a, b;
	static int[] bridge;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 징검다리 개수
		bridge = new int[N+1];
		visited = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			bridge[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		int ans = bfs();
		
		System.out.println(ans);
	}
	
	private static int bfs() {
		Queue<Frog> queue = new LinkedList<>();
		queue.add(new Frog(a, 0));
		
		visited[a] = true;
		
		while(!queue.isEmpty()) {
			Frog f = queue.poll();
			if (f.idx == b) { // 목적지에 다다랐다면
				return f.jump; // 현재 누적 점프 횟수 반환
			}
			
			// 오른쪽으로 점프
			int n = 1;
			
			while(true) {
				int nn = n * bridge[f.idx];
				if (nn + f.idx > N) break; // 범위 벗어나버리면 break
				if(!visited[nn + f.idx]) {
					visited[nn + f.idx] = true;
					queue.add(new Frog(nn + f.idx, f.jump + 1));
				}
				n++;
			}
			
			// 왼쪽으로 점프
			n = 1;
			
			while(true) {
				int nn = n * bridge[f.idx];
				if (f.idx - nn <= 0) break; // 범위 벗어나버리면 break
				if(!visited[f.idx - nn]) {
					visited[f.idx - nn] = true;
					queue.add(new Frog(f.idx - nn, f.jump + 1));
				}
				n++;
			}
		}
		return -1;
	}

}