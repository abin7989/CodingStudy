import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953 {

	static long A, B, num;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		System.out.println(bfs());

	}

	private static long bfs() {
		Queue<Long> q = new LinkedList<>();
		q.offer(A);

		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) {
				Long cur = q.poll();

				if (cur == B)
					return num+1;

				long num1 = cur * 2;
				if(num1 <= B)
					q.offer(num1);

				long num2 = cur * 10 + 1;
				if(num2 <= B)
					q.offer(num2);

			}
			num++;

		}
		return -1;
	}

}
