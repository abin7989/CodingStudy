

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOj_1197 {

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
			// Integer.compar(this.weight, o.weight);
			return this.weight - o.weight;
		}
	}

	static int V, E;
	static int[] parents;
	static Edge[] edgeList;

	static void make() { // 크기가 1인 서로소 집합 생성

		parents = new int[V];

		for (int i = 0; i < V; i++) { // 모든 노드가 자신을 부모로하는 (대표자) 집합으로 만듦
			parents[i] = i;
		}
	}

	static int find(int a) { // a의 대표자 찾기
		if (parents[a] == a)
			return a;

		return parents[a] = find(parents[a]); // 우리의 대표자를 나의 부모로 : path compression
	}

	static boolean union(int a, int b) { // 리턴값 : true - > union 성공, 실패하면 false

		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken())+1;
		E = Integer.parseInt(st.nextToken());

		edgeList = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		make();
		
		Arrays.sort(edgeList);

		int result = 0;
		int count = 0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				result += edge.weight;
				if (++count == V - 1)
					break;
			}
		}
		System.out.println(result);
	}

}
