import java.io.*;
import java.util.*;

public class Main_백준_10972_다음순열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder(3000);
    static StringTokenizer st = null;
    static void swap(int[] num,int a,int b){
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
    static boolean np(int[] num,int n){

        int i = n-1;
        int j = n-1;
        int k = n-1;
        while(i>0&&num[i-1]>=num[i]) i--;
        if(i==0)
            return false;
        while(num[i-1]>=num[j]) j--;
        swap(num,i-1,j);
        while(i<k) swap(num,i++,k--);
        return true;
    }
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int num[] =new int [n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i =0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        if(np(num,n)){
            for(int i=0;i<n;i++)
                System.out.print(num[i]+" ");
        }
        else
            System.out.println(-1);
    }
}
