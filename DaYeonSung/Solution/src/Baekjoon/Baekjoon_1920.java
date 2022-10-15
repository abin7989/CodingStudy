package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 1920. 수 찾기
public class Baekjoon_1920 {

	static int N;
	static int[] A;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A); // 이분 탐색하기 전 배열 정렬

		int M = Integer.parseInt(br.readLine());
				
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (search(num) >= 0) {
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}
		}

		System.out.println(sb);
	}
	
	private static int search(int num) {
		int low = 0; // 찾아볼 범위의 첫 idx
		int high = A.length - 1; // 찾아볼 범위의 마지막 idx
		
		while(low <= high) {
			int mid = (low + high) / 2;
			// num이 중간 idx 값보다 작으면
			if (num < A[mid]) {
				high = mid - 1;
			} else if (num > A[mid]) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
}
