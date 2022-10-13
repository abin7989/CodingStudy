package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 17281. 야구
public class Baekjoon_17281 {
	/*
	 * 한 이닝에 3아웃이 발생하면 이닝이 종료되고, 두 팀이 공격과 수비를 서로 바꾼다.
	 * 9번 타자까지 공을 쳤는데 3아웃이 발생하지 않은 상태면 이닝은 끝나지 않고, 1번 타자가 다시 타석에 선다.
	 * 예를 들어, 2이닝에 6번 타자가 마지막 타자였다면, 3이닝은 7번 타자부터 타석에 선다.
	 * 타자가 공을 쳐서 얻을 수 있는 결과는 안타, 2루타, 3루타, 홈런, 아웃 중 하나
	 * 안타: 타자와 모든 주자가 한 루씩 진루한다.
	 * 2루타: 타자와 모든 주자가 두 루씩 진루한다.
	 * 3루타: 타자와 모든 주자가 세 루씩 진루한다.
	 * 홈런: 타자와 모든 주자가 홈까지 진루한다.
	 * 아웃: 모든 주자는 진루하지 못하고, 공격 팀에 아웃이 하나 증가한다.
	 */

	static int N;
	static int maxScore; // 최대 점수
	static int[][] result;
	static boolean[] selected;
	static int[] lineup;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		result = new int[N][9]; // 이닝에서의 타자 결과
		
		selected = new boolean[9]; // 방문 배열
		lineup = new int[9]; // 타순 배열
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());		
			}
		}
		
		// 4번 타자는 항상 1번으로 고정이기 때문에
		selected[3] = true;
		lineup[3] = 0;
		
		maxScore = 0;
		perm(1);
		
		System.out.println(maxScore);

	}
	
	private static void perm(int num) {
		if (num == 9) {
			play();
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (selected[i]) {
				continue;
			}
			selected[i] = true;
			lineup[i] = num;
			perm(num + 1);
			selected[i] = false;
		}
	}
	
	private static void play() {
		int score = 0;
		int start = 0; // 시작 타자 idx
		boolean[] base; // 홈, 1루, 2루, 3루
		
		for (int i = 0; i < N; i++) {
			int out = 0;
			base = new boolean[4];
			
			outer: while(true) {
				for (int j = start; j < 9; j++) {
					int hit = result[i][lineup[j]];
					
					switch(hit) {
					case 0: // 아웃일 경우
						out++;
						break;
					case 1: // 1루타일 경우
						for (int k = 3; k >= 1; k--) {
							if (base[k]) { // 베이스에 선수가 존재하면
								if (k == 3) { // 3루일 경우엔
									score++; // 홈으로 들어온 뒤 점수 추가
									base[k] = false; // 기존 위치 초기화
									continue;
								}
								// 이외의 경우엔
								base[k] = false;
								base[k + 1] = true; // 1루씩 진출
							}
						}
						base[1] = true; // 현재 타자 홈에서 1루 진출
						break;
					case 2: // 2루타일 경우
						for (int k = 3; k >= 1; k--) {
							if (base[k]) { // 베이스에 선수가 존재하면
								if (k == 3 || k == 2) { // 3루일 경우엔
									score++; // 홈으로 들어온 뒤 점수 추가
									base[k] = false; // 기존 위치 초기화
									continue;
								}
								// 이외의 경우엔
								base[k] = false;
								base[k + 2] = true; // 1루씩 진출
							}
						}
						base[2] = true; // 현재 타자 홈에서 2루 진출
						break;
					case 3: // 3루타일 경우
						for (int k = 3; k >= 1; k--) {
							if (base[k]) { // 어떤 자리든지 간에 선수 존재하면 무조건 홈으로 들어오기 때문에
								score++; // 점수 1점씩 추가
								base[k] = false;
							}
						}
						base[3] = true;
						break;
					case 4: // 홈런일 경우
						for (int k = 1; k <= 3; k++) {
							if (base[k]) {
								score++;
								base[k] = false;
							}
						}
						score++; // 현재 타자도 점수 추가
						break;
					}
					
					if (out == 3) { // 쓰리 아웃이라면
						start = j + 1;
						if (start == 9) start = 0;
						break outer;
					}
				}
				start = 0;
			}
		}
		
		maxScore = Math.max(maxScore, score);
		
	}

}
