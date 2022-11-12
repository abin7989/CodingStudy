package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 4008. 숫자 만들기
public class SWEA_4008 {

	static int N, plus, minus, multiple, divide, min, max;
	static int[] nums;
	static char[] opers, madeOpers;
	static boolean[] isSelected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            N = Integer.parseInt(br.readLine()); // 숫자의 개수
            
            nums = new int[N];
            opers = new char[N-1];
            madeOpers = new char[N-1];
            isSelected = new boolean[N-1];
            
            st = new StringTokenizer(br.readLine(), " ");
            plus = Integer.parseInt(st.nextToken());
            minus = Integer.parseInt(st.nextToken());
            multiple = Integer.parseInt(st.nextToken());
            divide = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
            
            for (int i = 0; i < plus; i++) {
				opers[i] = '+';
			}
            for (int i = plus; i < plus+minus; i++) {
				opers[i] = '-';
			}
            for (int i = plus+minus; i < plus+minus+multiple; i++) {
            	opers[i] = '*';
			}
            for (int i = plus+minus+multiple; i < N-1; i++) {
				opers[i] = '/';
			}
            
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            
            makeOrder(0);
            
//            System.out.println(Arrays.toString(opers));
            
            sb.append(max - min).append("\n");
        }
        System.out.println(sb);
	}
	
	private static void makeOrder(int cnt) {
		if (cnt == N-1) {
			int ans = calc();
			max = Math.max(ans, max);
			min = Math.min(ans, min);
			return;
		}
		
		char duplication = '.';
		for (int i = 0; i < N-1; i++) {
			if (isSelected[i]) continue;
			if(duplication == opers[i]) continue;
			madeOpers[cnt] = opers[i];
			isSelected[i] = true;
			makeOrder(cnt + 1);
			isSelected[i] = false;
			duplication = opers[i];
		}
	}
	
	private static int calc() {
		int ans = nums[0];
		for (int i = 0; i < N-1; i++) {
			switch(madeOpers[i]) {
			case('+'):
				ans += nums[i+1];
				break;
			case('-'):
				ans -= nums[i+1];
			break;
			case('*'):
				ans *= nums[i+1];
			break;
			case('/'):
				ans /= nums[i+1];
			break;

			}
		}
		return ans;
	}

}
