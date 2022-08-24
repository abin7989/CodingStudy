package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1926 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			int num = i;
			boolean flag = false;
			String numString = String.valueOf(num);
			char[] numArr = numString.toCharArray();
			int cnt = 0;
			for (int j = 0; j < numArr.length; j++) {
				if (numArr[j] % 3 == 0 && numArr[j] != '0') {
					flag = true;
					cnt++;
				} else if (numArr[j] % 3 != 0 && !flag) {
					flag = false;
				}
			}
			if (flag) {
				for (int j = 1; j <= cnt; j++) {
					sb.append("-");
				}
			} else {
				sb.append(num);
			}
			sb.append(" ");
		}
		
		System.out.println(sb);
	}

}