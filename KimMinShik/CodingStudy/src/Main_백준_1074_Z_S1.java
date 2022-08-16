import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1074_Z_S1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st =null;
	static int cnt = 0;
	static int n;
	static int posx;
	static int posy;
	static boolean pass = false;
	static void ja(int x,int y,int size) {
		if(x==posx&&y==posy){
			sb.append(cnt);
			return;
		}
		
		if(posx>=x+size||posx<x||posy>=y+size||posy<y) {
			cnt+=size*size;
		}else {
			ja(x,y,size/2);
			ja(x,y+size/2,size/2);
			ja(x+size/2,y,size/2);
			ja(x+size/2,y+size/2,size/2);
		}
			
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine()," ");
		n= Integer.parseInt(st.nextToken());
		posx= Integer.parseInt(st.nextToken());
		posy= Integer.parseInt(st.nextToken());
		int tmp=(int) Math.pow(2,n );
		ja(0,0,tmp);
		System.out.println(sb);
	}
}
