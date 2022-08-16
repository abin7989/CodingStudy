package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 2839. 설탕 배달
public class Baekjoon_2839 {

	static int min = 1667;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < 1667; i++) {
			for (int j = 0; j < 1001; j++) {
				if (3 * i + 5 * j == N) {
					if (i + j < min) {
						min = i + j;
					}
				}
				
			}
		}
		if (min == 1667) System.out.println(-1);
		else System.out.println(min);
	}

}
