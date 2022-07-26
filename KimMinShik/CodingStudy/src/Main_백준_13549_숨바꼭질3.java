import java.io.*;
import java.util.*;

public class Main_백준_13549_숨바꼭질3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st;
	static PriorityQueue<Node> q = new PriorityQueue<Node>();

	static boolean v[] = new boolean[100001];
	static int max = 0;

	static class Node implements Comparable<Node> {
		int s;
		int cnt;

		public Node(int s, int cnt) {
			this.s = s;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			if (cnt == o.cnt)
				return s - o.s;
			else
				return cnt - o.cnt;
		}

	}

	static void BFS(int start, int end) {
		q.offer(new Node(start, 0));
		int size = 0;
		int now = 0;
		int cnt = 0;
		br: while (!q.isEmpty()) {
			size = q.size();
			while (size-- > 0) {
				now = q.peek().s;
				cnt = q.poll().cnt;
				if (v[now])
					continue;
				v[now] = true;
				if (now == end) {
					max = cnt;
					break br;
				}
				if (now + 1 <= 100000) {
					q.offer(new Node(now + 1, cnt + 1));
				}
				if (now * 2 <= 100000) {
					q.offer(new Node(now * 2, cnt));
				}
				if (now - 1 >= 0)
					q.offer(new Node(now - 1, cnt + 1));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		BFS(start, end);

		System.out.println(max);
	}
}
