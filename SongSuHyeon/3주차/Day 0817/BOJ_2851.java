import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2851 {

	static int[] arr, sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		sum = new int[10];
		sum[0] = arr[0];
		for (int i = 1; i < 10; i++) {
			sum[i] = sum[i - 1] + arr[i];
		}

		boolean flag = false;
		int index = 0;
		for (int i = 0; i < 10; i++) {
			if (sum[i] >= 100) {
				flag = true;
				index = i;
				break;
			} else {
				index = i;
			}
		}

		if (flag = true) {
			if (sum[index] == 100) {
				System.out.println(100);
			} else if (index != 0 && Math.abs(100 - sum[index]) == Math.abs(100 - sum[index - 1])) {
				System.out.println(sum[index]);
			} else {
				if (Math.abs(100 - sum[index]) < Math.abs(100 - sum[index - 1])) {
					System.out.println(sum[index]);
				} else {
					System.out.println(sum[index - 1]);
				}
			}
		} else {

			System.out.println(sum[index]);
		}
	}

}
