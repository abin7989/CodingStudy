import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289 {

	static int T, V, E, N, M, cmd, A, B;
	static int[] parents;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수 T

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken()); // 집합 원소의 개수
			M = Integer.parseInt(st.nextToken()); // 연산의 개수

			// 서로소 집합 생성
			parents = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parents[i] = i; // 모든 노드가 자신을 부모로하는 (대표자) 집합으로 만듦
			}

			sb.append("#").append(testCase).append(" ");
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				cmd = Integer.parseInt(st.nextToken());
				A = Integer.parseInt(st.nextToken());
				B = Integer.parseInt(st.nextToken());

				// cmd = 0 : 합집합
				// cmd = 1 : 두 원소가 같은 집합에 포함되어 있는지를 확인
				switch (cmd) {
				case 0: {
					union(A, B);
					break;
				}
				case 1: {
					if (isSameParent(A, B))
						sb.append(1);
					else
						sb.append(0);
					break;
				}

				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
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

	// 같은 부모 노드를 가지는지 확인
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return true;
		else
			return false;
	}

}