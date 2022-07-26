import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7465_창용마을무리의개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(3000);
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(br.readLine(), " ");

			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			boolean ch[] = new boolean[v + 1];
			int pe[] = new int[v + 1];
			for (int i = 1; i <= v; i++) {
				pe[i] = i;
			}
			int cnt = 0;
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				while (pe[to] != to) {
					to = pe[to];
				}
				while (pe[from] != from) {
					from = pe[from];
				}
				if (from != to)
					pe[to] = from;

			}
			for(int i = 1 ; i<= v;i++) {
				if(pe[i]==i)
					cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	static class Node {
		Node p;
	}
}
