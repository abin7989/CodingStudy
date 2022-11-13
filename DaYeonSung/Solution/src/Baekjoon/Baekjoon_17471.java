package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 17471. 게리맨더링
public class Baekjoon_17471 {
	static int N, ans;
	static int[] popul;
	static boolean[] isSelected, visited;
	static List<ArrayList<Integer>> graph;
	static ArrayList<Integer> group1, group2;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 구역의 개수
		
		st = new StringTokenizer(br.readLine(), " ");
		popul = new int[N]; // 각 구역 인구 수 담을 배열
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
		}
		
		// N개의 줄에 걸쳐 각 구역과 인접한 구역의 정보 입력 받기
		graph = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				int num = Integer.parseInt(st.nextToken());
				graph.get(i).add(num - 1);
			}
		}
		
		ans = Integer.MAX_VALUE;
		subset(0);
		
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);

	}
	
	// 부분집합 구하는 메소드
	private static void subset(int idx) {
		if (idx == N) {
			group1 = new ArrayList<>();
			group2 = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) group1.add(i);
				else group2.add(i);
			}
			
			// 둘 중 한 선거구에 몰렸다면
			if (group1.size() == 0 || group2.size() == 0)
				return;
			
			if(check(group1) && check(group2)) { // 두 구역이 모두 각각 연결되어있는 것이 확인되었다면
				calc();
			}
			return;
		}
		
		isSelected[idx] = true;
		subset(idx + 1);
		isSelected[idx] = false;
		subset(idx + 1);
		
	}
	
	// 선거구 2개 유효성 확인
	private static boolean check(ArrayList<Integer> group) {
		Queue<Integer> queue = new LinkedList<>();
		visited = new boolean[N];
		visited[group.get(0)] = true;
		queue.offer(group.get(0));
		
		int cnt = 1;
		while(!queue.isEmpty()) {
			int poll = queue.poll();
			for (int i = 0; i < graph.get(poll).size(); i++) {
				int el = graph.get(poll).get(i);
				if (group.contains(el) && !visited[el]) {
					queue.offer(el);
					visited[el] = true;
					cnt++;
				}
			}
		}
		if (cnt == group.size()) return true;
		else return false;
	}
	
	// 두 선거구 최소 인구 차 구하기
	private static void calc() {
		int sum1 = 0, sum2 = 0;
		for (int i = 0; i < group1.size(); i++) {
			sum1 += popul[group1.get(i)];
		}
		for (int i = 0; i < group2.size(); i++) {
			sum2 += popul[group2.get(i)];
		}
		ans = Math.min(ans, Math.abs(sum1 - sum2));
	}

}
