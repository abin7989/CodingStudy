import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_4012 {
	static int N, R;
	static int[] comb_numbers, comb_part_numbers, comb_input, perm_numbers;
	static int[][] add_score;
	static boolean[] comb_isSelected, perm_isSelected; // 인덱스에 해당하는 숫자가 사용중인지 저장하는 배열
	static StringTokenizer st;
	static int acnt;
	static int bcnt;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.valueOf(br.readLine());
		
		for (int test_case = 1; test_case <=T; test_case++) {
			N = Integer.valueOf(br.readLine());
			R = N / 2;

			comb_input = new int[N];
			comb_numbers = new int[R]; // 뽑힌 수 저장
			comb_part_numbers = new int[R];
			for (int i = 1; i <= N; i++) {
				comb_input[i - 1] = i;
			}

			add_score = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					add_score[i][j] = Integer.valueOf(st.nextToken());
				}
			}

			comb(0, 0);

			sb.append("#").append(test_case).append(" ").append(min).append("\n");
			
			min = Integer.MAX_VALUE;
		}
		System.out.println(sb);

	} // end of main

	// cnt+1번째 해당하는 조합에 포함될 수를 뽑기
	// cnt : 직전까지 뽑은 조합에 포함된 수의 개수 (현재까지 몇 개를 뽑았는지)
	// start : 시도할 수의 시작 위치
	private static void comb(int cnt, int start) {

		// 기저 조건
		if (cnt == R) {

			List<Integer> tmp = new ArrayList<Integer>();
			tmp.add(0);
			for (int i = 1; i <= N; i++) {
				tmp.add(i);
			}
			for (int i = 0; i < R; i++) {
				tmp.set(comb_numbers[i], 0);
			}
			int idx = 0;
			for (int i = 0; i < tmp.size(); i++) {
				if (tmp.get(i) != 0)
					comb_part_numbers[idx++] = tmp.get(i);
			}

			perm_isSelected = new boolean[R];
			perm_numbers = new int[2];

			perm(comb_numbers, 0);
			bcnt = acnt;
			acnt = 0;
			perm(comb_part_numbers, 0);
			min = Math.min(min, Math.abs(acnt - bcnt));
			acnt = 0;
			return;
		}

		// 가능한 모든 수에 대해 시도 (input 배열의 모든 수 시도)
		// start부터 처리 시 중복 수 추출 방지 및 순서가 다른 조합 추출 방지
		for (int i = start; i < N; i++) {
			// start 위치부터 처리했으므로 중복체크 필요 없음!
			// 앞쪽에서 선택되지 않았다면 수 사용
			comb_numbers[cnt] = comb_input[i];
			// 다음 수 뽑으러 가기
			comb(cnt + 1, i + 1); // start + 1 아님 : start는 시작 위치만 결정함
		}
	}

	// cnt : 직전까지 뽑은 순열에 포함된 수의 개수 (현재까지 몇 개를 뽑았는지)
	private static void perm(int[] arr, int cnt) { // cnt+1번째 해당하는 순열에 포함될 수를 뽑기

		// 기저 조건
		if (cnt == 2) {
			acnt += add_score[perm_numbers[0] - 1][perm_numbers[1] - 1];
			return;
		}

		// 가능한 모든 수에 대해 시도
		for (int i = 0; i < arr.length; i++) { // 선택지
			// 시도하는 수가 선택되었는지 판단
			if (perm_isSelected[i])
				continue;
			// 선택되지 않았다면 수를 사용
			perm_numbers[cnt] = arr[i];
			perm_isSelected[i] = true;
			// 다음 수 뽑으러 가기
			perm(arr, cnt + 1);
			// 사용했던 수에 대한 선택 되돌리기
			perm_isSelected[i] = false;
		}
	}

} // end of class
