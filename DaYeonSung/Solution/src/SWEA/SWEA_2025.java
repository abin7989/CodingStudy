package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SWEA 2025. N줄덧셈
public class SWEA_2025 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for (int i = 1; i <= N; i++) {
			sum += i;
		}
		
		System.out.println(sum);

	}

}
