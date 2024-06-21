import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		if(K > C*R) {
			System.out.println(0);
			return;
		}
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
	    int[][] map = new int[C+1][R+1];

	    int count = 1;
	    int x = 1;
	    int y = 1;
	    int xP = 0;
	    int yP = 0;
	    int dir = 0;
	    while(count != K) {
	    	
    		map[x][y] = count;
	    	xP = x + dx[dir];
	    	yP = y + dy[dir];
	    	if(xP > C || xP < 1 || yP > R || yP < 1 || map[xP][yP] != 0) {
	    		
	    		dir = (dir+1) % 4;
	    		xP = x + dx[dir];
	    		yP = y + dy[dir];
	    	}
	    	
    		x = xP;
    		y = yP;
    		count++;
	    }

	    System.out.println(x + " " + y);
	}
}