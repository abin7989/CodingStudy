package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준 1436. 영화감독 숌
public class Baekjoon_1436 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int num = 666;
		int cnt = 1;
		
		while(cnt != N) {
			num++;
			if (String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		
		System.out.println(num);
		
	}

}
