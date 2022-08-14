import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725 {
	static int N; // 노드의 개수
	static boolean[] visited; // 방문 기록 저장 배열
	static ArrayList<Integer> tree[]; // 그래프 데이터 저장 인접 리스트
	static int answer[]; // 부모 노드 저장 정답 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		visited = new boolean[N + 1];
		tree = new ArrayList[N + 1];
		answer = new int[N + 1];

		// tree 인접 리스트의 각 ArrayList 초기화
		for (int i = 0; i < N + 1; i++) {
			tree[i] = new ArrayList<>();
		}

		// tree에 그래프 데이터 저장
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			tree[n1].add(n2);
			tree[n2].add(n1);
		}

		DFS(1);

		for (int i = 2; i <= N; i++) {
			System.out.println(answer[i]);
		}
	} // end of main

	private static void DFS(int number) {
		// 현재 노드 방문 기록
		visited[number] = true;
		for (int i : tree[number]) {
			// 현재 노드의 연결 노드 중 방문 하지 않은 노드로
			if (!visited[i]) {
				// 부모 노드 저장하기
				answer[i] = number;
				DFS(i);
			}
		}
	} // end of DFS

} // end of class
