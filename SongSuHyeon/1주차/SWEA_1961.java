import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Python 코드 def degree_90(arr, n): tmp = [[0 for j in range(n)] for i in
 * range(n)] for i in range(n): for j in range(n): tmp[j][n-1-i] = arr[i][j]
 * return tmp
 * 
 * T = int(input())
 * 
 * for test_case in range(1, T+1): N = int(input())
 * 
 * arr = [] for i in range(N): arr.append(input().split())
 * 
 * arr_90 = degree_90(arr, N) arr_180 = degree_90(arr_90, N) arr_270 =
 * degree_90(arr_180, N) print("#{}".format(test_case)) for i in range(N):
 * print("{} {} {}".format(''.join(arr_90[i]), ''.join(arr_180[i]),
 * ''.join(arr_270[i])))
 */
public class SWEA_1961 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.valueOf(br.readLine());
			int[][] arr = new int[N][N];
			int[][] arr_90 = new int[N][N];
			int[][] arr_180 = new int[N][N];
			int[][] arr_270 = new int[N][N];

			for (int i = 0; i < arr.length; i++) {
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s);
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = Integer.valueOf(st.nextToken());
				}
			}

			arr_90 = degree_90(arr, N);
			arr_180 = degree_90(arr_90, N);
			arr_270 = degree_90(arr_180, N);

			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr_90[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr_180[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr_270[i][j]);
				}
				System.out.println();
			}
		}
	}

	public static int[][] degree_90(int[][] arr, int N) {
		int[][] tmp = new int[N][N];
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				tmp[j][N - 1 - i] = arr[i][j];
			}
		}
		return tmp;
	}
}
