package day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());

		int cnt = 0;
		while (N >= 0) {
			if (N % 5 == 0) {
				cnt += N / 5;
				System.out.println(cnt);
				break;
			}
			N -= 3;
			cnt += 1;  // 5의 배수가 될 때까지 설탕-3, 봉지+1
		}
		if (N < 0)
			System.out.println(-1);
	}
}
