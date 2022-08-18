import java.io.*;
import java.util.*;

public class Main_백준_14500_테트로미노 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder(3000);
    static StringTokenizer st = null;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static int map[][];
    static boolean v[][];
    static int n;
    static int m;
    static int mx=0;
    static int tex[][] = {{0,1,-1},{1,1,1},{-1,-1,-1},{0,-1,1}};
    static int tey[][] = {{1,1,1},{0,-1,1},{0,-1,1},{-1,-1,-1}};
    static void DFS(int x,int y,int cnt,int num){
        if(cnt==4) {
            mx=Math.max(mx,num);
            return;
        }

        for(int i =0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0||nx>=n||ny<0||ny>=m||v[nx][ny])
                continue;
            v[nx][ny] = true;
            DFS(nx,ny,cnt+1,num+map[nx][ny]);
            v[nx][ny] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map=new int[n][m];
        v = new boolean[n][m];
        for(int i =0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0 ; i<n;i++){
            for(int j =0;j<m;j++){
                v[i][j] = true;
                DFS(i,j,1,map[i][j]);
                v[i][j] = false;
                for(int q = 0;q<4;q++){
                    int temp=map[i][j];
                    for(int p=0;p<3;p++){
                        int nx = i+tex[q][p];
                        int ny = j+tey[q][p];
                        if(nx<0||nx>=n||ny<0||ny>=m)
                            continue;
                        temp+=map[nx][ny];
                    }
                    mx=Math.max(mx,temp);
                }
            }
        }
        System.out.println(mx);
    }
}
