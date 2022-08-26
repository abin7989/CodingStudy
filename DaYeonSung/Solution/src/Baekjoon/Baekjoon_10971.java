package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 10971. 외판원 순회 2
public class Baekjoon_10971 {
	
	static int[][] W;
	static int N, R;
	static int min = Integer.MAX_VALUE;
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		R = N;
		W = new int[N+1][N+1]; // 비용행렬
				
		numbers = new int[R];
		isSelected = new boolean[N+1]; // 수가 1부터 시작해서 인덱스도 1부터 논리적 매칭 사용 (0 인덱스는 사용 X)
		
		// 도시 i에서 도시 j로 가기 위한 비용 입력 받기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(0);
		
		System.out.println(min);

	}
	
	private static void perm(int cnt) {
		
		if (cnt == R) {
//			System.out.println(Arrays.toString(numbers));
			minPrice(numbers);
			return;
		}
		
		// 가능한 모든 수에 대해 시도
		for (int i = 1; i <= N; i++) {
			// 시도하는 수가 선택되었는지 판단
			if (isSelected[i]) continue;
			// 선택되지 않았다면 수를 사용하고
			numbers[cnt] = i; // cnt를 idx로 사용하는 이유: 예를 들어, 두번째 수를 뽑을 때 1 인덱스를 활용하기 때문
			isSelected[i] = true;
			// 다음수 뽑으러 가기
			perm(cnt + 1);
			// 사용했던 수에 대해 선택 되돌려놓기
			isSelected[i] = false;
		}
	}
	
	// 외판원의 순회에 필요한 최소 비용 구하기
	private static void minPrice(int[] route) {
		int sum = 0;
		for (int i = 0; i < N - 1; i++) {
			if (W[route[i]][route[i+1]] == 0) return;
			sum += W[route[i]][route[i+1]];
		}
		if (W[route[N-1]][route[0]] == 0) return;
		sum += W[route[N-1]][route[0]];
		
		if (sum < min) {
			min = sum;
		}
	}
}
