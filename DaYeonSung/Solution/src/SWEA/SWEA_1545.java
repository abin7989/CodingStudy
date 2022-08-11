package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SWEA 1545. 거꾸로 출력해 보아요
public class SWEA_1545 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = N; i >= 0; i--) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	}

}
