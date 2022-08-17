package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1541. 잃어버린 괄호
public class Baekjoon_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(),"-");
		
		int result = 0;
		for (StringTokenizer st = new StringTokenizer(str.nextToken(), "+"); st.hasMoreTokens();) {
			result += Integer.parseInt(st.nextToken());
		}
		
		while (str.hasMoreTokens()) {
			int sum = 0;
			for (StringTokenizer st = new StringTokenizer(str.nextToken(), "+"); st.hasMoreTokens();) {
				sum += Integer.parseInt(st.nextToken());
			}
			result -= sum;
		}

		System.out.println(result);
	}

}
