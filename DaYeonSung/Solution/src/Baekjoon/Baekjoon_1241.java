package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1241. 머리 톡톡
public class Baekjoon_1241 {

	static int N, max = Integer.MIN_VALUE;
	static int[] headNums, numsCnt, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 학생 수
		
		headNums = new int[N + 1]; // 1번부터 N번까지 각각 학생의 머리에 쓰여진 숫자들
		ans = new int[N + 1]; // 정답 출력할 배열
		
		for (int i = 1; i <= N; i++) {
			headNums[i] = Integer.parseInt(br.readLine()); // 머리에 쓰일 숫자 입력 받기
			max = Math.max(max, headNums[i]); // 머리 숫자들의 최댓값 구하기
		}
		
		numsCnt = new int[max + 1]; // 머리 숫자 개수 배열
		
		// 머리 숫자들의 개수 구하기
		for (int i = 1; i <= N; i++) {
			numsCnt[headNums[i]]++;
		}
		
		// 약수 구하기
		for (int i = 1; i <= N; i++) { // 머리 숫자 배열 인덱스
			for (int j = 1; j * j <= headNums[i]; j++) { // 자기의 제곱근보다 작거나 같은 인덱스까지 반복
				if (headNums[i] % j == 0) { // 머리 숫자가 j로 나눠 떨어지고
					if (headNums[i] / j != j) { // j로 나눴을 때 몫이 자기 자신이 아니라면
						ans[i] += numsCnt[j] + numsCnt[headNums[i] / j]; // j로 나눈 값 인덱스의 개수와 j인덱스의 개수 더하기
					} else { // j로 나눴을 때 몫이 자기 자신이라면
						ans[i] += numsCnt[j]; // j인덱스의 개수만 더해주기
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(ans[i] - 1).append("\n");
		}
		
		System.out.println(sb);

	}

}
