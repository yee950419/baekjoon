import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static class Fireball{
		int r;
		int c;
		int m;	// 질량
		int s;	// 속력
		int d;	// 방향
		
		Fireball(int r, int c, int m, int s, int d){
			this.r = r ;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, K;
	static ArrayList<Fireball> map[][];
	static ArrayList<Fireball> list = new ArrayList<>();
	static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};
	
 	public static void main(String[] args) throws IOException {
 		
 		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N+1][N+1];
		for(int i=0; i<N+1; i++) {
			for(int j=0; j<N+1; j++) {
				
				map[i][j] = new ArrayList<Fireball>();
			}
		}
		
		for(int i=0; i<M; i++) {
			
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			map[r][c].add(new Fireball(r,c,m,s,d));
			list.add(new Fireball(r,c,m,s,d));
		}
		
		while(K-- > 0) {
			
			// 파이어볼 이동
			move();
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					if(map[i][j].size() >= 2) {
						// 2개 이상일 경우 합치고 퍼뜨리기
						merge(i,j);
					}
				}
			}
			
			// 움직이고 합친 후 리스트에 담기
			makeList();
		}
		
		int totalM = 0;
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				
				if(map[i][j].size() > 0) {
					for(Fireball ball : map[i][j]) {
						
						totalM += ball.m;
					}
				}
			}
		}
		
		System.out.println(totalM);
	}
 	
 	public static void makeList(){
 		list = new ArrayList<>();
 		for(int i=1; i<N+1; i++) {
 			for(int j=1; j<N+1; j++) {
 				if(map[i][j].size() > 0){
 					for(Fireball cur : map[i][j]) {
 						list.add(cur);
 					}
 				}
 			}
 		}
 	}
	
	public static void move() {
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				map[i][j] = new ArrayList<Fireball>();
			}
		}
		
		for(Fireball ball : list) {
			ball.r = ball.r + dx[ball.d]*(ball.s%N);
			ball.c = ball.c + dy[ball.d]*(ball.s%N);
			
			if(ball.r > N) ball.r %= N;
			if(ball.c > N ) ball.c %= N;
			if(ball.r <= 0 ) ball.r = N - Math.abs(ball.r);
			if(ball.c <= 0) ball.c = N - Math.abs(ball.c);
			
			map[ball.r][ball.c].add(ball);
		}
		
	}
	
	public static void merge(int x, int y) {
		
		int sumM = 0, sumS = 0, sumCnt = 0, sumD = 0;
		boolean isEven = true;
		boolean isOdd = true;
		for(Fireball ball : map[x][y]) {
			
			sumM += ball.m;
			sumS += ball.s;
			sumCnt++;
			if(ball.d % 2 == 0) {
				isOdd = false;
			}else {
				isEven = false;
			}
		}
		
		int M = sumM / 5;
		int S = sumS / sumCnt;
		
		map[x][y] = new ArrayList<>();
		if(M <= 0) {
			return;
		}
		
		if(isEven || isOdd) {
			for(int i=0; i<4; i++) {
				map[x][y].add(new Fireball(x,y,M,S,i*2));
			}
		}else {
			for(int i=0; i<4; i++) {
				map[x][y].add(new Fireball(x,y,M,S,i*2+1));
			}
		}
		
	}
}