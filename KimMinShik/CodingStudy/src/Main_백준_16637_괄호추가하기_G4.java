import java.io.*;
import java.util.*;

public class Main_백준_16637_괄호추가하기_G4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st = null;
	static int arrn[];
	static int arrm[];
	static int n;
	static int ndiv2;
	static int max = Integer.MIN_VALUE;
	static int oper(int a,int pos,int b) {
		switch (arrm[pos]) {
		case '+':
			return a+b;
		case '-':
			return a-b;
			
		case '*':
			return a*b;
		}
		return 0;
	}
	static void com(int cnt,int num) {
		if(cnt==ndiv2) {
			max = Math.max(num, max);
			return;
		}
		com(cnt+1,oper(num,cnt,arrn[cnt+1]));
		if(cnt+2<=ndiv2) {
			int temp = oper(arrn[cnt+1],cnt+1,arrn[cnt+2]);
			com(cnt+2,oper(num,cnt,temp));
		}
	}
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		ndiv2 =n/2;
		String s = br.readLine();
		arrn = new int[ndiv2+1];
		arrm = new int[ndiv2];
		for(int i = 0,nindex=0,index=1 ; i < ndiv2;i++,nindex+=2,index+=2) {
			arrn[i] = s.charAt(nindex)-'0';
			arrm[i] = s.charAt(index);
		}
		arrn[ndiv2]=s.charAt(n-1)-'0';
		com(0,arrn[0]);
		System.out.println(max);
	}

}
