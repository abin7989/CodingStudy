import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder(3000);
    static StringTokenizer st = null;
    static int sm;
    static int sc;
    static int si;
    static  int map[];
    static char oper[];
    static  char str[];

    static int pointer = 0;
    static  int strpoint = 0;
    static void helpOper(char t){
        switch (t){
            case'-':
                map[pointer]--;
                break;
            case'+':
                map[pointer]++;
                break;
            case'<':
                if(pointer==0)
                    pointer=sm-1;
                else
                    pointer--;
                break;
            case'>':
                if(pointer==sm-1)
                    pointer=0;
                else
                    pointer++;
                break;
            case',':
                if(strpoint==si)
                    map[pointer]=255;
                else
                    map[pointer] = str[strpoint++];
                break;
        }

    }
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int test =0;test<T;test++){
            st = new StringTokenizer(br.readLine(), " ");
            sm = Integer.parseInt(st.nextToken());
            sc = Integer.parseInt(st.nextToken());
            si = Integer.parseInt(st.nextToken());
            map = new int[sm];
            oper = new char[sc];
            str = new char[si];
            String temps = br.readLine();
            for(int i =0;i<sc;i++){
                oper[i]= temps.charAt(i);
            }
            temps = br.readLine();
            for(int i =0;i<si;i++){
                str[i]= temps.charAt(i);
            }
            pointer = 0;
            strpoint = 0;
            bf:for(int i = 0;i<sc;i++){
               if(oper[i]=='[') {
                   int cnt = 0;
                   int end = 0;
                   for (int j = i; j < sc; j++) {
                       if (oper[j] == ']') {
                           end = j;
                       }
                   }
                   while (map[pointer] != 0) {
                       for (int j = i + 1; j < end; j++) {
                            helpOper(oper[j]);
                       }
                       cnt++;
                       if (cnt >= 50_000_000){
                           sb.append("Loops ").append(i).append(" ").append(end).append("\n");
                           break bf;
                       }
                   }
                   i=end+1;
               }else{
                   helpOper(oper[i]);
               }
            }
            sb.append("Terminates\n");

        }
        System.out.println(sb);
    }
}
