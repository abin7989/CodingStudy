import java.io.*;
import java.util.*;

public class Solution_최소스패닝트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder(1000);
	static PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
	static boolean v[];
	static int pr[];

	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			pr = new int[n+1];
			v = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				pr[i] = i;
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				pq.add(new Edge(A, B, C));
			}
			long re = 0;
			int cnt =0;
			while(!pq.isEmpty()) {
				Edge edge = pq.poll();
				if(union(edge.from, edge.to)) {
					re+=edge.w;
					if(++cnt==n-1) break;
				}
			}
			sb.append("#").append(test_case).append(" ").append(re).append("\n");
		}
		System.out.println(sb);
	}
	static int find(int a) {
		if(pr[a]==a) return a;
		return pr[a] = find(pr[a]);
	}
	static boolean union(int a,int b) {
		int aR = find(a);
		int bR = find(b);
		if(aR==bR) return false;
		pr[bR] = aR;
		return true;
	}

	static class Edge {
		int from,to, w;

		public Edge(int from,int v, int w) {
			super();
			this.from = from;
			this.to = v;
			this.w = w;
		}

	}
}
