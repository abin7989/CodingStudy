import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13251 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = 0, M, K; // T : 테스트 개수, M : 색의 종류, K : 선택된 조약돌 개수
		int[] arr = new int[51]; // 각 색깔별 조약돌 개수 저장하기 배열
		double[] probablity = new double[51]; // 색깔별 확률 저장하기 배열
		double ans;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 각 조약돌 개수 저장
			T += arr[i]; // T변수에 조약돌 개수 더하기
		}

		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());

		ans = 0.0;
		for (int i = 0; i < M; i++) {
			if (arr[i] >= K) { // 현재 색깔의 조약돌의 개수가 선택해야 할 개수보다 크면
				probablity[i] = 1.0;
				for (int j = 0; j < K; j++) {
					// i 색을 모두 뽑을 확률 = i 색을 모두 뽑을 확률 * 현재 색 개수 - K / 전체 색 개수 - K
					probablity[i] *= (double) (arr[i] - j) / (T - j);
				}
				ans += probablity[i];
			}
		}
		System.out.println(ans);

	}

}
