package SWEA;

import java.util.Scanner;

class SWEA_1974 {
	public static void main(String args[]) throws Exception {
		
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int i, j, k, l;
		int[][] arr = new int[9][9];
		int[] num = new int[9];
		int flag = 1;
		
		for(i = 0; i < T; i++) {
			
			/* 입력 */
			for(j = 0; j < 9; j++)
				for(k = 0; k < 9; k++)
					arr[j][k] = s.nextInt();
			
			for(j = 0; j < 9; j++) {
				flag = 1;
				
				for(k = 0; k < 9; k++)
					num[k] = 0;
				
				for(k = 0; k < 9; k++) {
					num[arr[j][k] - 1]++;
				}
				
				for(k = 0; k < 9; k++) 
					if(num[k] != 1) 
						flag = 0;
					
				if(flag == 0) 
					break;
				
				for(k = 0; k < 9; k++)
					num[k] = 0;
				
				for(k = 0; k < 9; k++) {
					num[arr[k][j] - 1]++;
				}
				
				for(k = 0; k < 9; k++) 
					if(num[k] != 1) 
						flag = 0;
					
				if(flag == 0) 
					break;
				
				for(k = 0; k < 9; k++)
					num[k] = 0;
				
				for(k = 0; k < 3; k++)
					for(l = 0; l < 3; l++)
						num[arr[k][l] - 1]++;

				for(k = 0; k < 9; k++) 
					if(num[k] != 1) 
						flag = 0;
					
				if(flag == 0) 
					break;
			}
			
			System.out.println("#" + (i + 1) + " " + flag);
		}
	}
}

/*

1 1 1 5 5 5 9 9 9
5 5 5 9 9 9 1 1 1
9 9 9 1 1 1 5 5 5
1 1 1 5 5 5 9 9 9
5 5 5 9 9 9 1 1 1
9 9 9 1 1 1 5 5 5
1 1 1 5 5 5 9 9 9
5 5 5 9 9 9 1 1 1
9 9 9 1 1 1 5 5 5

*/