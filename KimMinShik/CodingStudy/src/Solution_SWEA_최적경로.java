import java.util.*;
import java.io.*;

class Solution_SWEA_최적경로
{
	public static void swap(int[] nums,int a, int  b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
	}
	public static boolean nextPermutation(int[] nums)
	{
		int i = nums.length-1;
		int j = nums.length-1;
		while(i > 0 && nums[i-1] >= nums[i]) --i;
	
		if(i <= 0) return false;

		while(nums[i-1] > nums[j]) --j;
	
		swap(nums,i-1,j);
		
		j = nums.length - 1;
		while(i<j) swap(nums, i++, j--);
		return true;
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st =null;
		int T;
		T=Integer.parseInt(br.readLine());


		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			int startx = Integer.parseInt(st.nextToken());
			int starty = Integer.parseInt(st.nextToken());
			int[] posx = new int[n];
			int[] posy = new int[n];
			int[] num = new int[n];
			int homex = Integer.parseInt(st.nextToken());
			int homey = Integer.parseInt(st.nextToken());
			for(int i = 0 ; i<n;i++)
			{
				posx[i] = Integer.parseInt(st.nextToken());
				posy[i] = Integer.parseInt(st.nextToken());
				num[i]=i;
			}
			int mn = 987654321;
			do
			{
				int prex = startx;
				int prey = starty;
				int temp =0;
				for(int i = 0 ; i < n ; i ++)
				{
					temp+= Math.abs(prex-posx[num[i]])+Math.abs(prey-posy[num[i]]);
					prex = posx[num[i]];
					prey = posy[num[i]];
				}
				temp+= Math.abs(prex-homex)+Math.abs(prey-homey);
				mn= Math.min(mn, temp);
			}while(nextPermutation(num));
			
			
			System.out.println("#"+test_case+" "+mn);
		}
		
		return;
	}
}