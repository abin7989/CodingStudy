package SWEA;

import java.util.Scanner;

class SWEA_1289 {
	
	public static void main(String args[]) throws Exception {
		
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int testCase, j;

		for(testCase = 1; testCase <= T; testCase++) {
			
			String str = s.next();
			int sum = 0;
			
			if(str.charAt(0) == '1') {
				
				sum++;
				
			}
			
			for(j = 0; j < str.length() - 1; j++) {
				
				if(str.charAt(j) != str.charAt(j + 1)) {
					
					sum++;
					
				}
				
			}
			
			System.out.println("#" + testCase + " " + sum);
			
		}
		
	}
	
}