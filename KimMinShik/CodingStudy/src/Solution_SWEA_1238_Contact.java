
import java.io.*;
import java.util.*;


class Solution_SWEA_1238_Contact
{
	static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	public static void main(String args[]) throws Exception
	{

		int T=10;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(1000);
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			List<Integer>[] nummap = new ArrayList[101];
			boolean[] v = new boolean[101];
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0 ; i <n/2;i++)
			{
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if(nummap[from]==null)
					nummap[from] = new ArrayList<Integer>();
				
				nummap[from].add(to);
			}
			Queue<Integer> q = new LinkedList<Integer>();
			Queue<Integer> cntq = new LinkedList<Integer>();
			v[start] = true;
			q.add(start);
			cntq.add(0);
			int mxcnt = 0;
			int mxnum = start;
			while(!q.isEmpty())
			{
				int nt = q.poll();
				int cnt = cntq.poll();
				
				if(cnt> mxcnt)
				{
					mxcnt = cnt;
					mxnum = nt;
				}
				else if(cnt == mxcnt)
				{
					mxnum = Math.max(mxnum, nt);
				}
				if(nummap[nt]==null)
					continue;
				
				for(int i = 0;i<nummap[nt].size();i++)
				{
					int temp = nummap[nt].get(i);
					if(v[temp])
						continue;
					
					q.add(temp);
					cntq.add(cnt+1);
					v[temp] = true;
					
				}
			}
			sb.append("#").append(test_case).append(" ").append(mxnum).append("\n");
		}
		System.out.println(sb);
		return;
	}
}