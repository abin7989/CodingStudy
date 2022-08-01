package SWEA;

import java.util.Scanner;

class SWEA_1940 {
	public static void main(String args[]) throws Exception {
		
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int i, j, k;
		
		for(i = 0; i < T; i++) {
			
			int N = s.nextInt();
			int[][] arr = new int[N][2];
			int speed = 0;
			int distance = 0;
			
			for(j = 0; j < N; j++) {
				
				for(k = 0; k < 2; k++) {
					
					arr[j][k] = s.nextInt();
					
					if(arr[j][k] == 0) {
						
						break;
						
					}
					
				}
				
			}
			
			for(j = 0; j < N; j++) {
				
				if(arr[j][0] == 1) {
					
					speed += arr[j][1];
					
				}
				else if(arr[j][0] == 2) {
					
					if(arr[j][0] > speed) {
						
						speed = 0;
						
					}
					else {
						
						speed -= arr[j][1];
						
					}
					
				}
				
				distance += speed;
			}
			
			System.out.println("#" + (i + 1) + " " + distance);
			
		}
		
	}
	
}