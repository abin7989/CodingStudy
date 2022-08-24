import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class Main_최소스패닝트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder(1000);
	static PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
	static ArrayList<ArrayList<Edge>> aal = new ArrayList<ArrayList<Edge>>();
	static boolean v[];

	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(br.readLine());
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			for (int i = 0; i <= n; i++) {
				aal.add(new ArrayList<Edge>());
			}
			v = new boolean[n + 1];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				aal.get(A).add(new Edge(B, C));
				aal.get(B).add(new Edge(A, C));
			}
			int sum = 0;
			pq.clear();
			sb.append("#").append(test_case).append(" ").append(prim(n, sum)).append("\n");
		}
		System.out.println(sb);
	}

	static int prim(int n, int sum) {
		int cnt = 1;
		v[1] = true;
		pq.addAll(aal.get(1));
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (v[edge.v])
				continue;

			v[edge.v] = true;
			sum += edge.w;
			cnt++;
			if (cnt == n)
				break;
			pq.addAll(aal.get(edge.v));
		}
		return sum;
	}

	static class Edge {
		int v, w;

		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

	}
}
