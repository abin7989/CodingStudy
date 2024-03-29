import java.io.*;
import java.util.*;

public class Main_백준_1260_DFS와BFS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st;
	static boolean v[];
	static Node al[];

	public static void DFS(int num) {
		if (v[num])
			return;
		v[num] = true;
		sb.append(num).append(" ");
		for (int i = 0, size = al[num].nl.size(); i < size; i++) {
			DFS(al[num].nl.get(i).is);
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		v = new boolean[1001];
		al = new Node[1001];
		for (int i = 0; i < 1001; i++) {
			al[i] = new Node(i);
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			al[x].nl.add(al[y]);
			al[y].nl.add(al[x]);
		}
		for (int i = 1; i <= n; i++) {
			if (al[i] == null)
				continue;
			Collections.sort(al[i].nl);
		}
		DFS(start);
		sb.append("\n");
		Queue<Node> q = new ArrayDeque<Main_백준_1260_DFS와BFS.Node>();
		q.offer(al[start]);
		v = new boolean[n + 1];
		while (!q.isEmpty()) {
			Node temp = q.poll();
			int ns = temp.is;
			if (v[ns])
				continue;
			sb.append(ns).append(" ");
			v[ns] = true;
			List<Node> al = temp.nl;
			for (int i = 0; i < al.size(); i++) {
				q.add(al.get(i));
			}
		}
		System.out.println(sb);
	}

	static class Node implements Comparable<Node> {

		List<Node> nl = new ArrayList<Main_백준_1260_DFS와BFS.Node>();
		int is;

		public Node(int is) {
			this.is = is;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return is - o.is;
		}

	}
}
