package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// SWEA 3499. 퍼펙트 셔플
public class SWEA_3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] result = new String[N];
			String[] arr = new String[N];
			String[] arr1;
			String[] arr2;
			int idx1 = 0;
			int idx2 = 0;

//			카드 교대로 넣을 배열 2개 선언
			if (N % 2 == 0) {
				arr1 = new String[N/2];
				arr2 = new String[N/2];
			} else {
				arr1 = new String[N/2 + 1];
				arr2 = new String[N/2];
			}
			
//			원래 배열 입력 받기
			st = new StringTokenizer(br.readLine());			
			for (int i = 0; i < N; i++) {
				arr[i] = st.nextToken();
			}
			
//			배열 2개로 나누기
			if (N % 2 == 0) {
				arr1 = Arrays.copyOf(arr, N/2);
				arr2 = Arrays.copyOfRange(arr, N/2, N);
			} else {
				arr1 = Arrays.copyOf(arr, N/2 + 1);
				arr2 = Arrays.copyOfRange(arr, N/2 + 1, N);
			}
			
//			배열 교차로 집어넣기 (카드 셔플)
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					result[i] = arr1[idx1++];
				} else {
					result[i] = arr2[idx2++];
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
