package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 1936. 1대1 가위바위보
public class SWEA_1936 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		/**
		 * 가위: 1
		 * 바위: 2
		 * 보: 3
		 * 1 < 2 < 3
		 * 3 < 1
		 */
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		if (A == 3 && B == 1) System.out.println("B");
		else if (A == 1 && B == 3) System.out.println("A");
		else if (A < B) System.out.println("B");
		else System.out.println("A");
	}

}
