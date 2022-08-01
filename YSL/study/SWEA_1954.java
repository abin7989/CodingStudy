package SWEA;

import java.util.Scanner;

class SWEA_1954 {
	
	public static void main(String args[]) throws Exception {
		
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int i, j, k;
		
		for(i = 0; i < T; i++) {
			
			int N = s.nextInt();
			int[][] arr = new int[N][N];
			int num = 1;
			int x = 0;
			int y = 0;
			int direction = 0;

			while(num <= N * N) {
				
				arr[x][y] = num++;
				
				if(direction % 4 == 0 && (y == N - 1 || arr[x][y + 1] > 0)) {
					
					direction++;
					
				}
				else if(direction % 4 == 1 && (x == N - 1 || arr[x + 1][y] > 0)) {
					
					direction++;
					
				}
				else if(direction % 4 == 2 && (y == 0 || arr[x][y - 1] > 0)) {
					
					direction++;
					
				}
				else if(direction % 4 == 3 && (x == 0 || arr[x - 1][y] > 0)) {
					
					direction++;
					
				}
				
				if(direction % 4 == 0)
					y++;
				else if(direction % 4 == 1)
					x++;
				else if(direction % 4 == 2)
					y--;
				else if(direction % 4 == 3)
					x--;
				
			}
			
			System.out.println("#" + (i + 1));
			
			for(j = 0; j < N; j++) {
				
				for(k = 0; k < N; k++)
					System.out.print(arr[j][k] + " ");
				
				System.out.println();
				
			}
			
		}
		
	}
	
}