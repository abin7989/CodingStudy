package day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_18406 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int sum1 = 0, sum2 = 0;
		int half = s.length() / 2;

		for (int i = 0; i < half; i++) {
			sum1 += s.charAt(i) - '0';
		}
		
		for (int i = half; i < s.length(); i++) {
			sum2 += s.charAt(i) - '0';
		}
		
		if(sum1 == sum2) 
			System.out.println("LUCKY");
		else 
			System.out.println("READY");
	}

}
