import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3124 {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	static int T, V, E;
	static int[] parents;
	static Edge[] edgeList;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static void make() { 
		parents = new int[V+1];

		for (int i = 0; i <= V; i++) { 
			parents[i] = i;
		}
	}

	static int find(int a) { 
		if (parents[a] == a)
			return a;

		return parents[a] = find(parents[a]); // path compression
	}

	static boolean union(int a, int b) { 

		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		T= Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());  // 정점의 개수 V(1≤V≤100,000)
			E = Integer.parseInt(st.nextToken());  // 간선의 개수 E(1≤E≤200,000)
			
			edgeList = new Edge[E];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}

			make();
			
			Arrays.sort(edgeList);

			long result = 0;
			long count = 0;
			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) {
					result += edge.weight;
					if (++count == V - 1)
						break;
				}
			}
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
			
		}
		System.out.println(sb);
	}

}