import java.util.Scanner;

public class SWEA_1940 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1;t<=tc;t++) {
			int n = sc.nextInt();
			int answer = 0;
			int v = 0;
			for(int j = 0;j<n;j++) {
				int a = sc.nextInt();
				int b = 0;
				if(a!=0)
					b = sc.nextInt();
				if(a==1) {
					v+=b;
				}
				else
					v=v>=b?v-b:0;
				answer+=v;
			}
			System.out.printf("#%d %d\n",t,answer);
		}
	}

}
