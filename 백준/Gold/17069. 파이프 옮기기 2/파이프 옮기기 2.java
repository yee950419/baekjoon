import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 1, 0};
    static int[][] arr;
    static long[][][] dp;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new long[N][N][3];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                for(int k=0; k<3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        System.out.println(dfs(0, 1, 0));
    }
    
    static long dfs(int x, int y, int direction) {
        if(dp[x][y][direction] >= 0) { //해당 위치에서 도착지점까지의 거리의 경우의 수가 이미 구해진 경우
            return dp[x][y][direction];
        }
        
        if(x==N-1 && y==N-1) { //도착점일 경우
            return 1;
        }
        
        long route = 0;
        
        for(int i=0; i<3; i++) {
            if(Math.abs(direction - i) > 1) { //가로 -> 세로, 세로 -> 가로 갈 수 없으므로
                continue;
            }
            
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            
            if(i != 1 && arr[nx][ny] == 0) { //가로, 세로 파이프인 경우
                route += dfs(nx, ny, i);
            } else if(i == 1 &&
                    arr[nx][ny] + arr[nx-1][ny] + arr[nx][ny-1] == 0) { //대각선 파이프인 경우
                route += dfs(nx, ny, 1);
            }
        }
        
        return dp[x][y][direction] = route;
    }
}