import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_1244 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switch_cnt = Integer.valueOf(br.readLine());
		int[] arr = new int[switch_cnt + 2];
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		for (int i = 1; i < arr.length - 1; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		arr[0] = Integer.MIN_VALUE;
		arr[arr.length - 1] = Integer.MAX_VALUE;

		int student_cnt = Integer.valueOf(br.readLine());
		for (int i = 0; i < student_cnt; i++) {
			String s2 = br.readLine();
			StringTokenizer st2 = new StringTokenizer(s2);
			int gender = Integer.valueOf(st2.nextToken());
			int num = Integer.valueOf(st2.nextToken());

			if (gender == 1) { // 남학생인 경우
				for (int j = 1; j < arr.length - 1; j++) {
					if ((j % num) == 0) {
						arr[j] = arr[j] == 0 ? 1 : 0;
					}
				}
			} else if (gender == 2) { // 여학생인 경우
				arr[num] = arr[num] == 0 ? 1 : 0;
				for (int j = 1; j < (arr.length - 2) / 2; j++) {
					if (arr[num - j] == arr[num + j]) {
						arr[num - j] = arr[num - j] == 0 ? 1 : 0;
						arr[num + j] = arr[num + j] == 0 ? 1 : 0;
					} else {
						break;
					}
				}
			}
		}
		for (int i = 1; i < arr.length - 1; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}
	} // end of main
} // end of class