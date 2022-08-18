import java.io.*;
import java.util.*;

public class Main_백준_18406_럭키스트레이트 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder(3000);
    static StringTokenizer st = null;
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        int temp1 =0;
        int temp2 = 0;
        for(int i =0;i<s.length()/2;i++){
            temp1+=s.charAt(i)-'0';
        }
        for(int i =s.length()/2;i<s.length();i++){
            temp2+=s.charAt(i)-'0';
        }
        if(temp1==temp2)
            System.out.println("LUCKY");
        else
            System.out.println("READY");
    }
}
