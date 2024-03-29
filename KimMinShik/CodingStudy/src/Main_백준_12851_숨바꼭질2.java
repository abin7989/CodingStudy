import java.io.*;
import java.util.*;

public class Main_백준_12851_숨바꼭질2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st;
	static Queue<Integer> q = new ArrayDeque<Integer>();

	static int v[] = new int[100002];
	static int cnt[] = new int[100002];
	static int oper(int i,int num){
		switch (i)
		{
		case 0:
			return num - 1;
		case 1:
			return num + 1;
		case 2:
			return num * 2;
		}
		return 0;
	}
	static void BFS(int pos) {
		q.offer(pos);
		v[pos] = 0;
		cnt[pos] = 1;

		while(!q.isEmpty())
		{
			pos = q.poll();
			for(int i =0; i < 3; i++)
			{
				int a = oper(i, pos);
				if(a<0|| a>100001) continue;
				if(v[a]==0)
				{
					q.offer(a);
					v[a] = v[pos] + 1;
					cnt[a] += cnt[pos];
				}else if(v[a] == v[pos]+1)
				{
					cnt[a] += cnt[pos];
				}

				
			}
		}
		return;
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		if(start==end)
		{
			System.out.println("0");
			System.out.println("1");
			return ;
		}
		BFS(start);

		System.out.println(v[end]);
		System.out.println(cnt[end]);
		
	}
}
