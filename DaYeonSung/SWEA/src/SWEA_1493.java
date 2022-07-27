import java.util.Scanner;

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
			
			int num = 1;
			boolean p_flag = false;
			boolean q_flag = false;
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
			
			for (int x = 1; x <= num; x++) {
				for (int y = num++; y >= 1; y--) {
				if (p == num) {
					p_flag = true;
					px = x;
					py = y;
				}
				if (q == num) {
					q_flag = true;
					qx = x;
					qy = y;
				}
//				num++;
				System.out.println(px + " " + py + " " + qx + " " + qy);
				if (p_flag == true && q_flag == true) break;
				}
			
			}

		}
	}

}
