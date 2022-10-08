package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1068. 트리
public class Baekjoon_1068 {
	
	static int N, deleteN;
	static int[] parents;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		parents = new int[N];
		visited = new boolean[N];
		
		int root = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			parents[i] = Integer.parseInt(st.nextToken());
			if (parents[i] == -1) root = i; // -1 만나면 루트 노드로 설정
		}
		
		deleteN = Integer.parseInt(br.readLine());
		deleteNode(deleteN);
		
		int ans = countLeaf();
		
		System.out.println(ans);
		
	}
	
	private static void deleteNode(int n) {
		visited[n] = true;
		parents[n] = -2;
		
		for (int i = 0; i < N; i++) { // 노드들의 부모 번호 배열을 돌면서
			if (parents[i] == n) { // n이 존재하면
				deleteNode(i); // 그 노드는 n의 자식 노드이기 때문에 삭제 해준다
			}
		}
	}
	
	private static int countLeaf() {
		int cnt = 0;
		
		for (int i = 0; i < N; i++) { // 전체 노드를 돌면서
			if (visited[i]) continue;
			if (isLeaf(i)) cnt++; // 리프노드 판별이 true라면 cnt++
		}
		
		return cnt;
	}
	
	private static boolean isLeaf(int idx) {
		visited[idx] = true; // 현재 노드 방문 처리
		
		boolean flag = true; // 초기 불린값 true로 설정
		for (int i = 0; i < N; i++) { // parents 배열을 돌면서
			if (parents[i] == idx) { // 부모 요소가 존재한다면
				flag = false; // 리프 노드가 아니다(false 처리)
				break; // 반복문 빠져나오기
			}
		}
		
		return flag;
	}

}
