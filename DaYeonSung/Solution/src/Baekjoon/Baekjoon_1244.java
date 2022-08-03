package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1244 스위치 켜고 끄기
public class Baekjoon_1244 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		 스위치 ON : 1
//		스위치 OFF : 0
		
//		학생 뽑아서 1 이상 스위치 개수 이하인 자연수 나눠줌
//		남학생 -> 받은 수의 배수가 되는 스위치 번호 -> 상태 바꾼다.
//		여학생 -> 받은 수와 같은 번호의 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간 -> 상태 바꾼다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 스위치 개수
		int[] switches = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			switches[i] = Integer.parseInt(st.nextToken()); // 스위치 N개 상태 입력 받기
		}
		
		int num = Integer.parseInt(br.readLine()); // 학생 수 입력 받기
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int s_num = Integer.parseInt(st.nextToken());
			
			if (gender == 1) { // 성별이 남성이라면
				for (int j = s_num; j <= N; j += s_num) {
					switches[j] ^= 1;
				}
			} else { // 성별이 여성이라면
				switches[s_num] ^= 1;
				int l = s_num - 1;
				int r = s_num + 1;
				while (true) {
					if (l >= 1 && r <= N && switches[l] == switches[r]) {
						switches[l] ^= 1;
						switches[r] ^= 1;
						l--;
						r++;
					} else break;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(switches[i] + " ");
			if (i % 20 == 0) System.out.println();
		}
	}

}
