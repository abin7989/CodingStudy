package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 
 * 유효성 검사
 * 사칙연산과 양의 정수로 구성된 임의의 식이
 * 적절한 식인지 확인하는 것
 * 계산이 가능하면 1, 불가능한 경우에 0 출력
 *
 */
public class SWEA_1233 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int result = 1 ; // 처음 초기값 설정 : 계산 가능(1)
			int N = Integer.parseInt(br.readLine());
			
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken(); // 루트 노드
				char oper = st.nextToken().charAt(0);
				if (st.hasMoreTokens()) { // 단말 노드가 아닌데
					if (oper >= '0' && oper <= '9') { // 숫자가 들어온다면
						result = 0; // 계산 불가능
					}
				} else { // 단말 노드인데
					if (oper == '+' || oper == '-' || oper == '*' || oper == '/') { // 연산자가 들어온다면
						result = 0; // 계산 불가능
					}
				}
			}
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.flush();
		br.close();
		bw.close();

	}

}
