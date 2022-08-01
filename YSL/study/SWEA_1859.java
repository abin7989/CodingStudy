package SWEA;

import java.util.Scanner;

class SWEA_1859 {
	public static void main(String args[]) throws Exception {
		
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int i, j;

		for(i = 0; i < T; i++) {
			
			int N = s.nextInt();
			int[] arr = new int[N];
			long sum = 0;
			int n;
			int idx;
			
			for(j = 0; j < N; j++) 
				arr[j] = s.nextInt();
			
			idx = N - 1;
			n = arr[idx];
			
			for(j = N - 2; j >= 0; j--) {
				
				if(arr[j] > n) {
					
					idx = j;
					n = arr[j];
					
				}
				else {
					
					sum += arr[idx] - arr[j];
					
				}
				
			}
			
			System.out.println("#" + (i + 1) + " " + sum);
			
		}
		
	}
	
}