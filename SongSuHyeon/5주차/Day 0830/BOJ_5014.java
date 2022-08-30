import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {

	static int F, S, G, U, D, num;
	static long[] arr;

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		F = Integer.parseInt(st.nextToken()); // F층으로 이루어진 고층 건물
		S = Integer.parseInt(st.nextToken()); // 강호가 지금 있는 곳
		G = Integer.parseInt(st.nextToken()); // 스타트링크가 있는 곳의 위치 : G층
		U = Integer.parseInt(st.nextToken()); // 위로 U층을 가는 버튼
		D = Integer.parseInt(st.nextToken()); // 아래로 D층을 가는 버튼

		arr = new long[F + 1];

		boolean flag = bfs();

		if(flag)
			System.out.println(num);
		else
			System.out.println("use the stairs");
	}

	private static boolean bfs() {

		Queue<Integer> q = new LinkedList<>();
		q.offer(S);

		while (!q.isEmpty()) {

			int size = q.size();
			
			for (int i = 0; i < size; i++) {

				int cur = q.poll();

				if(cur == G) return true;
				
				if (cur - D >=1 && arr[cur - D] == 0) {
					arr[cur - D] = 1;
					q.offer(cur - D);
				}

				if (cur + U <= F && arr[cur + U] == 0) {
					arr[cur + U] = 1;
					q.offer(cur + U);
				}
				
			}
			num++;

		}
		return false;

	}


}
