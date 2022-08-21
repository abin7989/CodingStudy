package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 10974. 모든 순열
public class Baekjoon_10974 {
	
	static int N;
	static int[] numbers;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N];
		isSelected = new boolean[N+1];
		
		perm(0);
		
		System.out.println(sb);
	}
	
	private static void perm(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
			perm(cnt + 1);
			
			isSelected[i] = false;
		}
	}
	
}
