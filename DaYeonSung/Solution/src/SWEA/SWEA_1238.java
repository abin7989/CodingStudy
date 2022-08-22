package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// SWEA 1238. Contact
public class SWEA_1238 {

	static int[][] graph;
	static boolean[] visited;
	static int len, start;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			len = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			graph = new int[101][101]; // from, to 2차원 배열
			visited = new boolean[101];
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < len / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph[from][to] = 1;
			}
			
			sb.append("#").append(tc).append(" ").append(bfs(start)).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int bfs(int s) {
		int ans = 0; // 리턴할 결과값
		int size = 0; // 큐의 크기
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start); // 시작점
		visited[start] = true;
		
		while (!q.isEmpty()) {
			size = q.size();
			int maxNode = 0;
			
			while (--size >= 0) {
				int cur = q.poll();
				for (int i = 1; i <= 100; i++) {
					if (graph[cur][i] == 1 && !visited[i]) {
						q.offer(i);
						if (maxNode < i) {
							maxNode = i;
						}
						visited[i] = true;
					}
					
				}
			}
			if(maxNode > 0) {
				ans = maxNode;	// 레벨 별 최대 노드번호 갱신
			}
		}
		return ans;
	}

}
