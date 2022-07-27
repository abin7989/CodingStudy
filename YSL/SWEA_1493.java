package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 배열 연산 없애니까 0.28s -> 0.16s 됨 */
public class SWEA_1493 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int[] idxP = new int[2];	// &p의 좌표 저장 배열
			int[] idxQ = new int[2];	// &q의 좌표 저장 배열
			int nextI = 1;				// 다음 진행할 i 좌표
			int nextJ = 1;				// 다음 진행할 j 좌표
			int height = 1;				// i의 높이(i의 현재까지 최댓값)
			int cnt = 0;				// 배열에 순차적으로 값을 넣기 위한 변수
			
			/* &p와 &q의 좌표를 모두 찾을 때까지 while문 진행 */
			while(idxP[0] == 0 || idxQ[0] == 0) {
				
				cnt++;
				
				/* 좌표의 값 확인 */
				if(cnt == p) {
					
					idxP[0] = nextI;
					idxP[1] = nextJ;
					
				}
				if(cnt == q) {

					idxQ[0] = nextI;
					idxQ[1] = nextJ;
					
				} /* 좌표의 값 확인 끝 */
				
				/* 다음 좌표 계산 */
				nextI -= 1;
				nextJ += 1;
				
				/* i가 배열 밖으로 나가면 위치 조정 */
				if(nextI < 1) {
					
					height++;
					nextI = height;
					nextJ = 1;
					
				} 
				
			} /* while end */

			/* &p + &q 의 좌표를 findI, findJ에 저장 */
			int findI = idxP[0] + idxQ[0];
			int findJ = idxP[1] + idxQ[1];
			int answer = 0;
			
			/* 찾는 좌표의 값 계산 */
			for (int j = 1; j <= findJ; j++) {
				
				answer += j;
				
			}
			for (int i = 0; i < findI - 1; i++) {
				
				answer += findJ + i;
				
			}
			
			System.out.println("#" + testCase + " " + answer);
			
		}
		
	}
	
}

/*

2
1 5
3 9

5
6679 9828
4879 120
2478 7718
1383 3648
792 7548

#(1, 1) = 1
#(2, 1) = 3
#(2, 2) = 5
#(4, 4) = 25

&1  = (1, 1)
&3  = (2, 1)
&5  = (2, 2)
&25 = (4, 4)

(x, y) + (z, w) = (x + z, y + w)

p★q = #(&p + &q)

    1  2  3  4  5  6
   
1   1  3  6 10 15 21
2   2  5  9 14 20 27
3   4  8 13 19 26
4   7 12 18 25 
5  11 17 24
6  16 23
7  22

0.16659s

*/