import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2581 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int MAX_SIZE = 10000;
		int[] arr = new int[N-M+1];
		for (int i = 0, num = M; num <= N; i++, num++) {
			arr[i] = num;
		}

		// 소수 판정
		int[] isPrime = new int[MAX_SIZE + 1];
		isPrime[0] = 1;
		isPrime[1] = 1;
		for (int i = 2; i <= Math.sqrt(MAX_SIZE); i++) {
			for (int j = i * 2; j <= MAX_SIZE; j += i) {
				isPrime[j] = 1;
			}
		}

		int sum = 0, min = 10000;
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			if(isPrime[arr[i]] == 0) {
				flag = true;
				sum += arr[i];
				
				if(min > arr[i])
					min = arr[i];
			}
		}
		
		if(flag == false) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(min);
			
		}
	}

}
