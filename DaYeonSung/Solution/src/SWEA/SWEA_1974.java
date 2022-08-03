package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for (int tc = 1; tc <= T; tc++) { // 테스트 케이스 수만큼 반복
			int[][] arr = new int[9][9];
			
//			스도쿠 숫자 입력 받기
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean flag = true;
//			가로로 조사
			for (int j = 0; j < 9; j++) {
				int[] nums = new int[9]; // 9의 크기를 가지고 초기값 0으로 채워진 배열 생성
				for (int k = 0; k < 9; k++) {
					nums[arr[j][k] - 1]++;
				}
				for (int k = 0; k < 9; k++) {
					if (nums[k] == 0) {
						flag = false;
						break;
					}
				}
			}
			
//			세로로 조사
			for (int j = 0; j < 9; j++) {
				int[] nums = new int[9]; // 9의 크기를 가지고 초기값 0으로 채워진 배열 생성
				for (int k = 0; k < 9; k++) {
					nums[arr[k][j] - 1]++;
				}
				for (int k = 0; k < 9; k++) {
					if (nums[k] == 0) {
						flag = false;
						break;
					}
				}
			}
			
//			사각형으로 조사
			for (int j = 0; j < 6; j+=3) {
				for (int k = 0; k < 6; k+=3) {
					int[] nums = new int[9]; // 9의 크기를 가지고 초기값 0으로 채워진 배열 생성
					for (int x = j; x < j + 3; x++) {
						for (int y = k; y < k + 3; y++) {
							nums[arr[x][y] - 1]++;
						}
					}
					for (int x = 0; x < 9; x++) {
						if (nums[x] == 0) {
							flag = false;
							break;
						}
					}
				}
			}
			
			if (flag) { // flag가 true면 (겹치는 숫자가 없다면)
				System.out.println("#"+ tc + " " + 1); // 정답
			} else { // flag가 false라면(겹치는 숫자가 있다면)
				System.out.println("#"+ tc + " " + 0); // 오답
			}
					
		}
		
	}
	
	
	
}
