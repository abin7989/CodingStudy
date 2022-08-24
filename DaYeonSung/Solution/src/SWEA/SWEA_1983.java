package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * 총점 = 중간고사(35%) + 기말고사(45%) + 과제(20%)
 *
 */

// SWEA 1983. 조교의 성적 매기기
public class SWEA_1983 {
	
	static String[] grades = { "D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+" };
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 학생수
			int K = Integer.parseInt(st.nextToken()); // 학점을 알고싶은 학생의 번호
		
			double[] arr = new double[N];
			int dist = N / 10;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int mid = Integer.parseInt(st.nextToken());
				int fin = Integer.parseInt(st.nextToken());
				int ass = Integer.parseInt(st.nextToken());
				
				// 학생들의 최종 성적 배열에 추가
				arr[i] = (mid * 0.35 + fin * 0.45 + ass * 0.2);
			}
			double gradeK = arr[K - 1];			
			Arrays.sort(arr); // 오름차순 정렬
			
			int idx = 0;
			
			for (int i = 0; i < N; i++) {
				if (arr[i] == gradeK) {
					idx = i;
					break;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(grades[idx / dist]).append("\n");
		}
		System.out.println(sb);
	}
	
}
