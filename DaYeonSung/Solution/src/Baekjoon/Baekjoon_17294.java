package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 17294. 귀여운 수~ε٩(๑> ₃ <)۶з
public class Baekjoon_17294 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String k = br.readLine();
		int len = k.length();
		
		boolean flag = true;
		int diff = 0;
		if (k.length() >= 2) {
			diff = (int)(k.charAt(1)) - (int)(k.charAt(0));
			
			for (int i = 1; i < len - 1; i++) {
				if ((int)(k.charAt(i + 1)) - (int)(k.charAt(i)) != diff) {
					flag = false;
					System.out.println("흥칫뿡!! <(￣ ﹌ ￣)>");
					break;
				}
			}
		}
		
		if (flag) System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");

	}

}
