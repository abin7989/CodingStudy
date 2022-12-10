package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 5014. 스타트링크
public class Baekjoon_5014 {

	static int F, S, G, U, D;
	static int[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		F = Integer.parseInt(st.nextToken()); // 건물 전체 높이
		S = Integer.parseInt(st.nextToken()); // 강호가 지금 있는 층
		G = Integer.parseInt(st.nextToken()); // 스타트링크가 있는 층
		U = Integer.parseInt(st.nextToken()); // U층 위로 가는 버튼
		D = Integer.parseInt(st.nextToken()); // D층 아래로 가는 버튼
		
		visited = new int[F + 1];
		
		useElevator(F, S, G, U, D);

	}
	
	private static void useElevator(int f, int s, int g, int u, int d) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(s);
		visited[s] = 1;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if (cur == g) {
				System.out.println(visited[cur] - 1);
				return;
			}
			
			if (cur + u <= f) { // 위로 이동했을 때 F층 이하이고
				if (visited[cur + u] == 0) { // 방문하지 않은 층이라면
					visited[cur + u] = visited[cur] + 1;
					queue.offer(cur + u);
				}
			}
			
			if (cur - d > 0) { // 아래로 이동했을 때 1층 이상이고
				if (visited[cur - d] == 0) { // 방문하지 않은 층이라면
					visited[cur - d] = visited[cur] + 1;
					queue.offer(cur - d);
				}
			}
		}
		
		System.out.println("use the stairs");
	}

}
