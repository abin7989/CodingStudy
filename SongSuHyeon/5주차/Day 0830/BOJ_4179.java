import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179 {

	static int R, C, num;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static char[][] arr;
	static Queue<int[]> fire = new LinkedList<>();
	static Queue<int[]> jh = new LinkedList<>();

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		// 입력
		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);

				if (arr[i][j] == 'F') {
					fire.offer(new int[] { i, j });
				}

				else if (arr[i][j] == 'J') {
					jh.offer(new int[] { i, j });
				}

			}
		}

		// 탈출하면 true, 아니면 false
		if (!bfs())
			sb.append("IMPOSSIBLE");
		else
			sb.append(num);

		System.out.println(sb);
	} // end of main

	private static boolean bfs() {

		// 사람이 갇혀 있으면
		while (!jh.isEmpty()) {
			
			num++;

			// 1. 불 먼저 이동
			int size = fire.size();

			for (int t = 0; t < size; t++) { // 불 개수만큼 불 이동
				int[] curF = fire.poll(); // 현재 불 위치 꺼내서

				for (int i = 0; i < 4; i++) { // 4방 탐색

					int nr1 = curF[0] + dr[i];
					int nc1 = curF[1] + dc[i];

					if (check(nr1, nc1)) // arr = map 범위 넘어가면
						continue;

					// 불이 아니고 벽이 아니면, 불 이동
					if (arr[nr1][nc1] != 'F' && arr[nr1][nc1] != '#') {
						arr[nr1][nc1] = 'F';
						fire.offer(new int[] { nr1, nc1 });
					}
				}
			}

			size = jh.size();
			for (int t = 0; t < size; t++) { // 지훈이 위치
				int[] curJ = jh.poll();
				
				// arr = map 테두리면 탈출!
				if (curJ[0] == 0 || curJ[0] == R - 1 || curJ[1] == 0 || curJ[1] == C - 1) {
					return true; // 테두리에 오면 탈출 -> true
				}

				for (int i = 0; i < 4; i++) { // 4방 탐색

					int nr2 = curJ[0] + dr[i];
					int nc2 = curJ[1] + dc[i];

					if (check(nr2, nc2)) { // 범위 체크
						continue;
					}

					if (arr[nr2][nc2] == '.') { // . 이면 bfs 너비? 레벨? 만큼 cnt 증가
						arr[nr2][nc2] = 'J';
						jh.offer(new int[] { nr2, nc2 });
					}

				}
			}
		}
		return false; // 탈출하지 못하면 -> false
	}

	private static boolean check(int nr, int nc) { // 범위 체크
		return nr < 0 || nr >= R || nc < 0 || nc >= C;
	}

} // end of class