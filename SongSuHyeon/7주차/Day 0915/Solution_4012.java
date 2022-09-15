import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012 {

    static int T, N, sum1, sum2, min = Integer.MAX_VALUE;
    static int[] selected1, selected2, ingredient1, ingredient2;
    static boolean[] isSelected;
    static int[][] S;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());  // N개의 식재료

            S = new int[N][N];  // 시너지
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    S[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            selected1 = new int[N / 2]; // 선택한 재료 그룹 1
            selected2 = new int[N / 2]; // 선택한 재료 그룹 2

            comb(0, 0);  // N/2개 선정

            sb.append("#").append(testCase).append(" ").append(min).append("\n");
            min = Integer.MAX_VALUE;
        }
        System.out.println(sb);
    }

    private static void comb(int cnt, int start) {

        isSelected = new boolean[N];  // 재료 선택 여부 저장

        if (cnt == N / 2) {
            for (int j = 0; j < N / 2; j++) {
                isSelected[selected1[j]] = true;  // 선택 그룹 1에 저장된 재료라면 true
            }
            int i = 0;
            for (int j = 0; j < N; j++) {
                if (!isSelected[j])
                    selected2[i++] = j;
            }

            ingredient1 = new int[2];
            ingredient2 = new int[2];

            sum1 = 0;
            sum2 = 0;

            min = Math.min(min, perm(0,0));

            return;
        }

        for (int i = start; i < N; i++) {
            selected1[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }

    private static int perm(int cnt, int flag) {

        if (cnt == 2) {

            sum1 += S[ingredient1[0]][ingredient1[1]];
            sum2 += S[ingredient2[0]][ingredient2[1]];

            return Math.abs(sum1 - sum2);
        }

        for (int i = 0; i < N / 2; i++) {

            if ((flag & 1 << i) != 0)
                continue;

            ingredient1[cnt] = selected1[i];
            ingredient2[cnt] = selected2[i];

            perm(cnt + 1, flag | (1 << i));

        }
        return Math.abs(sum1 - sum2);
    }


} // end of class
