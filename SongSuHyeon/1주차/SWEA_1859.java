import java.util.Scanner;

public class SWEA_1859 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			long[] arr = new long[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextLong();
			}
			
			long max = arr[arr.length - 1];
			long sum = 0;
			for (int i = arr.length - 2; i >= 0; i--) {
				if (arr[i] <= max) {
					sum += max - arr[i];
				} else {
					max = arr[i];
				}
			}
			System.out.println("#" + test_case + " " + sum);
		} // end of test_case
	} // end of main
} // end of class
