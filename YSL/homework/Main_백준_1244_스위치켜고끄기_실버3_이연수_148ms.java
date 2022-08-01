package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 남학생 : 받은 번호 배수의 스위치를 모두 토글
 * 여학생 : 받은 번호 기준 좌우로 계속 대칭이면 모두 토글
 */
public class Main_백준_1244_스위치켜고끄기_실버3_이연수_148ms {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());		// 스위치 수
		int[] arr = new int[size + 2];					// 스위치 배열
		String line = br.readLine();					// 배열에 값 넣기
		StringTokenizer st = new StringTokenizer(line);	
		for (int i = 1; i < arr.length - 1; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		/* 배열의 크기를 N + 2로 설정했기 때문에 양 끝은 21억을 넣어 
		   앞으로 할 계산에 방해 안 되게                             */
		arr[0] = Integer.MAX_VALUE;
		arr[arr.length - 1] = Integer.MAX_VALUE;;
		
		int N = Integer.parseInt(br.readLine());	// 학생 수 N
		for (int i = 0; i < N; i++) {
			
			line = br.readLine();
			st = new StringTokenizer(line);
			int sex = Integer.parseInt(st.nextToken());	// 성별
			int num = Integer.parseInt(st.nextToken());	// 스위치 번호
			
			/* 남학생일 때 */
			if(sex == 1) {
				
				int temp = num;
				
				while(temp < arr.length) {
					
					arr[temp] = Math.abs(arr[temp] - 1);
					temp += num;
					
				}
				
			/* 여학생일 때 */
			} else if(sex == 2) {
				
				int temp = 1;
				arr[num] = Math.abs(arr[num] - 1);
				
				/* 양쪽으로 뻗으며 대칭이면 스위치 토글 */
				while(true) {
					
					if(arr[num - temp] == arr[num + temp]) {
						
						arr[num - temp] = Math.abs(arr[num - temp] - 1);
						arr[num + temp] = Math.abs(arr[num + temp] - 1);
						temp++;
						
					} else {
						
						break;
						
					}
					
				}
				
			}
			
		}
		
		/* 출력 */
		for (int i = 1; i < arr.length - 1; i++) {
			
			System.out.print(arr[i] + " ");
			
			if(i % 20 == 0) {
				
				System.out.println();
				
			}
			
		}
		
	}
	
}

/*

8
0 1 0 1 0 0 0 1
2
1 3
2 3


1 0 0 0 1 1 0 1

*/