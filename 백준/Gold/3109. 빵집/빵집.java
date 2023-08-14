import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R, C;
	static char[][] map;
	static int count;
	static boolean isSuccess;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		count = 0;
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), "");
			String str = st.nextToken();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for(int i=0; i<R; i++) {
			isSuccess = false;
			dfs(i, 0);
		}
		
		System.out.println(count);
	}
	
	static void dfs(int x, int y) {
		
		if(y == C-1) {
			count++;
			isSuccess = true;
			return;
		}
		
		if(x-1 >= 0 && map[x-1][y+1] == '.') {
			map[x-1][y+1] = 'X';
			dfs(x-1, y+1);
		}
		if(!isSuccess) {
			if(map[x][y+1] == '.') {
				map[x][y+1] = 'X';
				dfs(x, y+1);
			}
		}
		if(!isSuccess) {
			if(x+1 < R && map[x+1][y+1] == '.') {
				map[x+1][y+1] = 'X';
				dfs(x+1, y+1);
			}
		}
	}
}