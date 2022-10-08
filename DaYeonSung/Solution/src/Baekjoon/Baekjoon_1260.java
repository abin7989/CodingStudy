package Baekjoon;

import java.io.*;
import java.util.*;

// 백준 1260. DFS와 BFS
public class Baekjoon_1260 {
	
	static int N, M, V;
	static int[][] nodes;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 루트 노드 번호
		
		nodes = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			nodes[n1][n2] = 1;
			nodes[n2][n1] = 1;
		}
		
		dfs(V);
		
		visited = new boolean[N + 1];
		
		bfs(V);
		
	}
	
	private static void bfs(int root) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(root);
		visited[root] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			
			sb.append(n).append(" ");
			
			for (int i = 1; i < N + 1; i++) {
				if (nodes[n][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		System.out.println(sb);
	}
	
	private static void dfs(int root) {
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			int n = stack.pop();
			if(visited[n]) continue;
			visited[n] = true;
			
			sb.append(n).append(" ");
			
			for (int i = N; i > 0; i--) {
				if (nodes[n][i] == 1 && !visited[i]) {
					stack.push(i);
				}
			}
		}
		System.out.println(sb);
	}

}