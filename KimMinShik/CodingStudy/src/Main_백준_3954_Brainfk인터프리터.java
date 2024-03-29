import java.io.*;
import java.util.*;

public class Main_백준_3954_Brainfk인터프리터 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(3000);
	static StringTokenizer st = null;
	static int sm;
	static int sc;
	static int si;
	static int map[];
	static char oper[];
	static char str[];
	static int find[];
	static int stack[];
	static int stack_pos[];
	static int sp;
	static int pointer = 0;
	static int strpoint = 0;
	static int cptr = 0;

	public static void fa() {
		sp = 0;
		for (int i = 0; i < sc; i++) {
			if (oper[i] == '[') {
				sp++;
				stack[sp] = i;
			}
			if (oper[i] == ']') {
				find[stack[sp]] = i;
				find[i] = stack[sp];
				sp--;
			}
		}
	}
	public static int move(int i) {
		int temp = i+1;
		switch (oper[i]) {
		case '-':
			map[pointer] = (map[pointer] + 255) % 256;
			break;
		case '+':
			map[pointer] = (map[pointer] + 1) % 256;
			break;
		case '<':
			pointer = (pointer+(sm-1))%sm;
			break;
		case '>':
			pointer = (pointer+(sm+1))%sm;
			break;
		case ',':
			if (strpoint == si)
				map[pointer] = 255;
			else
				map[pointer] = str[strpoint++];
			break;
		case '[':
			if (map[pointer] == 0) {
				temp = find[i]+1;
			}				
			else {
				stack_pos[sp] = cptr;
				stack[sp] = i;
				sp++;
			}
			break;

		case ']':
			if(map[pointer]!=0) {
				temp=find[i]+1;
				stack_pos[sp - 1] = cptr;
			}else {
				sp--;
			}
			break;
		}
		return temp;
	}
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		bf:for (int test = 0; test < T; test++) {
			st = new StringTokenizer(br.readLine(), " ");
			sm = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			si = Integer.parseInt(st.nextToken());
			map = new int[sm];
			oper = new char[sc];
			find = new int[sc];
			stack = new int[5000];
			stack_pos = new int[5000];
			
			str = new char[si];
			String temps = br.readLine();
			for (int i = 0; i < sc; i++) {
				oper[i] = temps.charAt(i);
			}
			temps = br.readLine();

			for (int i = 0; i < si; i++) {
				str[i] = temps.charAt(i);
			}
			pointer = 0;
			strpoint = 0;
			cptr=0;
			sp = 0;
			fa();
			int cnt = 50000001;
			int i=0;
			while (cnt--!=0) {
				if (i >= sc) {
					sb.append("Terminates\n");
					continue bf;
				}
				i = move(i);
				cptr++;
			}
			cnt = 50000001;
			while (cnt--!=0) {
				i = move(i);
				cptr++;
			}
			for (i = 0; i < sp; i++) {
				if (cptr-1-stack_pos[i] <= 50000000) {
					sb.append("Loops ").append(stack[i]).append(" ").append(find[stack[i]]).append("\n");
					break;
				}
			}

		}
		System.out.println(sb);
	}
}
