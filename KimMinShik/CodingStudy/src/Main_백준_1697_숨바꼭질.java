import java.io.*;
import java.util.*;

public class Main_백준_1697_숨바꼭질 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st;
	static Queue<Integer> q = new ArrayDeque<Integer>();

	static boolean v[] = new boolean[100001];
	static int cnt = 0;

	static void BFS(int start, int end) {
		q.offer(start);
		int size = 0;
		int dpos[] = { -1, 1 };
		br: while (!q.isEmpty()) {
			size = q.size();
			while (size-- > 0) {
				int now = q.poll();
				if (v[now])
					continue;
				v[now] = true;
				if (now == end) {
					break br;
				}
				if (now + 1 <= 100000) {
					q.offer(now + 1);
				}
				if (now *2 <= 100000) {
				q.offer(now * 2);
				}
				if (now - 1 >= 0)
					q.offer(now - 1);
			}
			cnt++;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		BFS(start, end);

		System.out.println(cnt);
	}
}
