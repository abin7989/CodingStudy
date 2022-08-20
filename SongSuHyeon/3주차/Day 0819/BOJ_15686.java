import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 도시의 치킨 거리(모든 집의 치킨 거리의 합)가 가장 작게 될지 구하는 프로그램 
 * 치킨 거리 = (r1, c1)과 (r2, c2) 사이의 거리 = |r1-r2| + |c1-c2| 
 *
 * 1. ArrayList에 집 좌표와 치킨집 좌표 저장
 * 2. 치킨집 M개를 선택할 경우의 수 구하기 -> 조합
 * 3. 선택한 치킨집 과 집 사이의 최소 치킨거리 구하기
 */
public class BOJ_15686 {

	static int N, M, res = Integer.MAX_VALUE;
	static int[] numbers;
	static ArrayList<int[]> shopList, houseList;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 도시의 크기
		M = Integer.parseInt(st.nextToken()); // 치킨집의 개수는 최대 M개

		shopList = new ArrayList<int[]>();
		houseList = new ArrayList<int[]>();

		// 0은 빈 칸, 1은 집, 2는 치킨집
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				// 집이라면 치킨집 위치 리스트에 저장
				if (num == 1) {
					houseList.add(new int[] { i, j });
				}
				// 치킨집이라면 치킨집 위치 리스트에 저장
				else if (num == 2) {
					shopList.add(new int[] { i, j });
				}
			}
		}

		numbers = new int[M];
		comb(0, 0);
		System.out.println(res);

	}

	private static void comb(int cnt, int start) {
		if (cnt == M) {

			int house = 0;
			int[] tmp = new int[houseList.size()];
			for (int[] is : houseList) {
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < M; i++) {
					min = Math.min(min, Math.abs(is[0] - shopList.get(numbers[i])[0])
							+ Math.abs(is[1] - shopList.get(numbers[i])[1]));
				}
				tmp[house] = min;
				house++;
			}

			int sum = 0;
			for (int i = 0; i < tmp.length; i++) {
				sum += tmp[i];
			}
			res = Math.min(res, sum);

			return;
		}

		for (int i = start; i < shopList.size(); i++) {
			numbers[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

}
