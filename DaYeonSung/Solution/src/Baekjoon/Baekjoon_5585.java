package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준 5585. 거스름돈
public class Baekjoon_5585 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int price = Integer.parseInt(br.readLine());
		
		price = 1000 - price;
				
		int cnt = 0;
		
		while (price / 500 != 0) {
			int tmpCnt = price / 500;
			cnt += tmpCnt;
			price -= 500 * tmpCnt;
		}
				
		while (price / 100 != 0) {
			int tmpCnt = price / 100;
			cnt += tmpCnt;
			price -= 100 * tmpCnt;
		}
				
		while (price / 50 != 0) {
			int tmpCnt = price / 50;
			cnt += tmpCnt;
			price -= 50 * tmpCnt;
		}
				
		while (price / 10 != 0) {
			int tmpCnt = price / 10;
			cnt += tmpCnt;
			price -= 10 * tmpCnt;
		}
				
		while (price / 5 != 0) {
			int tmpCnt = price / 5;
			cnt += tmpCnt;
			price -= 5 * tmpCnt;
		}
				
		cnt += price;
		
		System.out.println(cnt);

	}

}
