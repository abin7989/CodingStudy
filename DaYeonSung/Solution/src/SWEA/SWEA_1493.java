package SWEA;

import java.util.Scanner;

// SWEA 1493. 수의 새로운 연산
public class SWEA_1493 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수
			
		for (int tc = 1; tc <= T; tc++) { // 테스트 케이스 수 만큼 반복
			int p = sc.nextInt(); // p 입력 받기
			int q = sc.nextInt(); // q 입력 받기
//			p★q = #(&(p) + &(q))
//			&(p) = p가 붙은 좌표
//			(x,y) + (z,w) = (x+z, y+w)
//			#(x,y) = x,y 좌표의 수
			
//			(1, 1) / (1, 2) (2, 1) / (1, 3) (2, 2) (3, 1) / ...
			
			int px = 0;
			int py = 0;
			int qx = 0;
			int qy = 0;
			
//			int sum = 0;
//			while (sum <= 10000) {
//				sum += num++;
//			}
//			System.out.println(num);
//			
//			sum = 0;
//			for (int i = 1; i <= 141; i++) {
//				sum += i;
//			}
//			System.out.println(sum);
			
			
			int num = 1;
			int add_x = 2;
			int add_y = 1;
			
//			격자점에 수 붙이기
			int[][] arr = new int[283][283];
			
			for (int x = 1; x <= 282; x++) {
				for (int y = 1; y <= 282; y++) {
					arr[x][y] = num;
					num += add_x;
					add_x++;
				}
				num += add_y;
				add_y++;
			}
			
			for (int x = 1; x <= 282; x++) {
				for (int y = 1; y <= 282; y++) {
					if (arr[x][y] == p) {
						px = x;
						py = y;
					}
					if (arr[x][y] == q) {
						qx = x;
						qy = y;
					}
				}
			}
			
			System.out.println(px + " " + py + " " + qx + " " + qy);

		}
	}

}
