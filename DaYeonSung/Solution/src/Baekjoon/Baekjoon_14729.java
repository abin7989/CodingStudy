package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 백준 14729. 칠무해
public class Baekjoon_14729 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		double[] grades = new double[N];
		
		for (int i = 0; i < N; i++) {
			grades[i] = Double.parseDouble(br.readLine());
		}
		
		Arrays.sort(grades);
		
		for (int i = 0; i < 7; i++) {
			sb.append(String.format("%.3f",grades[i])).append("\n");
		}
		
		System.out.println(sb);

	}

}
