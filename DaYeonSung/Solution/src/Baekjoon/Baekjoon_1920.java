package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// ���� 1920. �� ã��
public class Baekjoon_1920 {

	static int N;
	static int[] A;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A); // �̺� Ž���ϱ� �� �迭 ����

		int M = Integer.parseInt(br.readLine());
				
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (search(num) >= 0) {
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}
		}

		System.out.println(sb);
	}
	
	private static int search(int num) {
		int low = 0; // ã�ƺ� ������ ù idx
		int high = A.length - 1; // ã�ƺ� ������ ������ idx
		
		while(low <= high) {
			int mid = (low + high) / 2;
			// num�� �߰� idx ������ ������
			if (num < A[mid]) {
				high = mid - 1;
			} else if (num > A[mid]) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
}
