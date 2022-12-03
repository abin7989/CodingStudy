package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 16928. 뱀과 사다리 게임
public class Baekjoon_16928 {
	
	static int N, M;
	static int[] board, cnt;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 사다리 수
		M = Integer.parseInt(st.nextToken()); // 뱀 수
		
		board = new int[101]; // 1부터 100까지 칸
		cnt = new int[101]; // 주사위 굴리는 횟수 누적 배열
		visited = new boolean[101]; // 방문 배열
		
		// 사다리와 뱀 정보 입력 받기 
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			board[a] = b; // a에 도착하면 b로 간다는 뜻
		}
		
		bfs();
		
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1); // 1번 칸부터 시작
		cnt[1] = 0; // 처음엔 주사위 안굴린 상태에서 시작하기 때문
		visited[1] = true; // 1번 칸 방문 처리
		
		while(!queue.isEmpty()) {
			int poll = queue.poll();
			if (poll == 100) { // 100번 칸에 도착했다면
				System.out.println(cnt[poll]); // 누적된 주사위 칸 수 출력
				return;
			}
			
			// 주사위에는 1부터 6까지의 수가 있음
			for (int i = 1; i < 7; i++) { // 1 ~ 6
				int x = poll + i;
				if (100 < x) continue; // 100보다 커지면 무시
				if (visited[x]) continue; // 이미 방문했다면 무시
				visited[x] = true; // 방문 처리
				
				if (board[x] != 0) { // board 배열에서 해당 칸이 0이 아니라면
					if (!visited[board[x]]) { // 그리고 방문하지 않은 칸이라면
						queue.offer(board[x]); // board[x] 값 큐에 추가
						visited[board[x]] = true; // 그리고 그 칸 방문 처리
						cnt[board[x]] = cnt[poll] + 1; // poll칸에서보다 1칸 더 추가해서 board[x]칸에  입력
					}
				} else { // board 배열에서 해당 칸이 0이라면
					queue.offer(x); // 그 x칸 추가
					cnt[x] = cnt[poll] + 1; // poll칸에서보다 1칸 더 추가해서 x칸에  입력
				}
			}
		}
	}

}
