import java.util.*;
import java.io.*;

public class Main_백준_14888_연산자끼워넣기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st;
	static int n;
	static int num[];
	static char op[];
	static boolean v[];
	static int operSize;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int oper(int n,int m,int next) {
		switch (op[n]) {
		case '+':
			return m + num[next];
		case '-':
			return m - num[next];
		case '*':
			return m * num[next];
		case '/':
			return m / num[next];
		}

		return 0;
	}
	static void perm(int cnt,int num) {
		if(cnt==n) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		for(int i = 0 ; i<operSize;i++) {
			if(v[i])
				continue;
			v[i]=true;
			perm(cnt+1,oper(i,num,cnt));
			v[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		operSize = n-1;
		num = new int[n];
		op = new char[n - 1];
		v = new boolean[n - 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;
		for (int i = 0, size = Integer.parseInt(st.nextToken()); i < size; i++) {
			op[cnt++] = '+';
		}
		for (int i = 0, size = Integer.parseInt(st.nextToken()); i < size; i++) {
			op[cnt++] = '-';
		}
		for (int i = 0, size = Integer.parseInt(st.nextToken()); i < size; i++) {
			op[cnt++] = '*';
		}
		for (int i = 0, size = Integer.parseInt(st.nextToken()); i < size; i++) {
			op[cnt++] = '/';
		}
		perm(1, num[0]);
		System.out.println(max);
		System.out.println(min);
	}
}
