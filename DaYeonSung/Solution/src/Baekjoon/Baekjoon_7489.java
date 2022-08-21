package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// 백준 7489. 팩토리얼
public class Baekjoon_7489 {
	
	static BigInteger fact (BigInteger n) {
		// 전달되는 값보다 크면 1, 같으면 0 그리고 작은 경우 -1을 반환
		if (n.compareTo(BigInteger.ONE) == 0)
			return n;
		else
			return fact(n.subtract(BigInteger.ONE)).multiply(n);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			BigInteger n = new BigInteger(br.readLine());
			BigInteger tmp = fact(n);
			String tmpStr = tmp.toString();

			for (int i = tmpStr.length() - 1; i >= 0; i--) {
				if (tmpStr.charAt(i) != '0') {
					sb.append(tmpStr.charAt(i)).append("\n");
					break;
				}
			}
		}
		
		System.out.println(sb);
	}
}
