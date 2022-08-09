import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1233 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {

			int node_cnt = Integer.valueOf(br.readLine()); // 노드의 개수 - 171
			int[] arr = new int[node_cnt + 1]; // 부모가 있는지 체크할 배열
			Arrays.fill(arr, 0);
			arr[0] = '1';
			for (int i = 1; i <= node_cnt; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 입력 받기 1 - 2 3
				int N = Integer.valueOf(st.nextToken()); // 1
				int s = st.nextToken().charAt(0); // 연산자 or 숫자
				arr[N] = s; // 해당 정점에 넣기
				if (st.countTokens() != 0 && (s == '+' || s == '-' || s == '/' || s == '*')) {
					if (st.countTokens() == 1) {
						arr[2 * N] = Integer.valueOf(st.nextToken());
					} else {
						arr[2 * N] = Integer.valueOf(st.nextToken());
						arr[2 * N + 1] = Integer.valueOf(st.nextToken());

					}
				}
			}

			int flag = 1;
			for (int i = node_cnt; i >= 2; i--) {
				// 자식이 연산자이고 부모가 숫자인 경우 연산 불가
				if ((arr[i] < '0' && arr[i] > '9') || (arr[i / 2] >= '0' && arr[i / 2] <= '9')) {
					flag = 0;
					break;
				}
			}
			sb.append("#").append(test_case).append(" ").append(flag).append("\n");
		} // end of test_case
		System.out.println(sb);
	}
} // end of class
