import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {

	static int N, K, cnt;
	static int[] arr = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		search(N);
		System.out.println(cnt);
	}

	private static void search(int n) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(n);

		int current = 0;
		while (!q.isEmpty()) {

			int length = q.size();
			for (int i = 0; i < length; i++) {
				current = q.poll();

				if (current == K)
					return;

				if (arr[current] == 0)
					arr[current] = 1;

				int next1 = current - 1;
				int next2 = current + 1;
				int next3 = current * 2;
				
				if (next1 >= 0 && next1 <= 100000 && arr[next1] == 0)
					q.offer(next1);
				if (next2 >= 0 && next2 <= 100000 && arr[next2] == 0)
					q.offer(next2);
				if (next3 >= 0 && next3 <= 100000 && arr[next3] == 0)
					q.offer(next3);
			}
			cnt++;

		}

	} // end of search

} // end of class
