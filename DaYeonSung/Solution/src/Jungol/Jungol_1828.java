package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 정올 1828. 냉장고
public class Jungol_1828 {
	static int maxDegree;
	static int cnt = 1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int chems[][] = new int[N][2];
		
		// 화학 물질 정보 입력 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				chems[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 최고 온도를 기준으로 배열 오름차순 정렬
		Arrays.sort(chems, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		// 총 최고 온도 배열 첫번째 값의 최고 온도로 초기화
		maxDegree = chems[0][1];
		
		// 배열의 최저 온도가 최고 온도보다 높으면 cnt++
		for (int i = 0; i < N; i++) {
			if (chems[i][0] > maxDegree) {
				maxDegree = chems[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
