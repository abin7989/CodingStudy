import java.util.Scanner;

public class SWEA_1859 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1;t<=tc;t++) {
			
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			
			long answer = 0;
			int max = arr[n-1];
			for(int i = n-2;i>=0;i--) {
				if(arr[i]>max)
					max = arr[i];
				else
					answer+=max-arr[i];
			}
			System.out.printf("#%d %d\n",t,answer);
		}
	}

}
