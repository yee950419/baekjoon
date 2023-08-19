import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static class Tank {
		int x;
		int y;
		char dir;
		public Tank(int x, int y, char dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int T, H, W;
	static char[][] map;
	static int N;
	static String orders;
	static Tank tank;
	
	public static void main(String[] args) throws IOException {
		
		T = Integer.parseInt(br.readLine());
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int tc=1; tc<=T; tc++) {
			
			sb.append("#" + tc + " ");
			
			inputDatas();
			getResult();
		}
	}
	
	static void getResult() {
		
		for(int i=0; i<N; i++) {
			// 슈팅했을때
			if(orders.charAt(i) == 'S') {
				// 윗방향을 바라볼 때
				if(tank.dir == 'u') {
					for(int j=tank.x; j>=0; j--) {
						// 강절을 만나면
						if(map[j][tank.y] == '#') {
							break;
						}
						// 벽돌이면 평지로
						if(map[j][tank.y] == '*') {
							map[j][tank.y] = '.';
							break;
						}
					}
				}
				
				// 오른쪽을 바라볼 때
				if(tank.dir == 'r') {
					for(int j=tank.y; j<W; j++) {
						// 강절을 만나면
						if(map[tank.x][j] == '#') {
							break;
						}
						// 벽돌이면 평지로
						if(map[tank.x][j] == '*') {
							map[tank.x][j] = '.';
							break;
						}
					}
				}
				
				// 아래쪽을 바라볼 때
				if(tank.dir == 'd') {
					for(int j=tank.x; j<H; j++) {
						// 강절을 만나면
						if(map[j][tank.y] == '#') {
							break;
						}
						// 벽돌이면 평지로
						if(map[j][tank.y] == '*') {
							map[j][tank.y] = '.';
							break;
						}
					}
				}
				
				// 왼쪽을 바라볼 때
				if(tank.dir == 'l') {
					for(int j=tank.y; j>=0; j--) {
						// 강절을 만나면
						if(map[tank.x][j] == '#') {
							break;
						}
						// 벽돌이면 평지로
						if(map[tank.x][j] == '*') {
							map[tank.x][j] = '.';
							break;
						}
					}
				}
			}
			
			// Up 일 때
			else if(orders.charAt(i) == 'U') {
				map[tank.x][tank.y] = '^';
				tank.dir = 'u';
				if(tank.x - 1 >= 0 && map[tank.x-1][tank.y] == '.') {
					map[tank.x][tank.y] = '.';
					tank.x--;
					map[tank.x][tank.y] = '^';
				}
			}
			else if(orders.charAt(i) == 'D') {
				map[tank.x][tank.y] = 'v';
				tank.dir = 'd';
				if(tank.x + 1 < H && map[tank.x+1][tank.y] == '.') {
					map[tank.x][tank.y] = '.';
					tank.x++;
					map[tank.x][tank.y] = 'v';
				}
			}
			else if(orders.charAt(i) == 'R') {
				map[tank.x][tank.y] = '>';
				tank.dir = 'r';
				if(tank.y + 1 < W && map[tank.x][tank.y+1] == '.') {
					map[tank.x][tank.y] = '.';
					tank.y++;
					map[tank.x][tank.y] = '>';
				}
			}
			else if(orders.charAt(i) == 'L') {
				map[tank.x][tank.y] = '<';
				tank.dir = 'l';
				if(tank.y - 1 >= 0 && map[tank.x][tank.y-1] == '.') {
					map[tank.x][tank.y] = '.';
					tank.y--;
					map[tank.x][tank.y] = '<';
				}
			}
		}
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
	}
	
	static void inputDatas() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		for(int i=0; i<H; i++) {
			String str = br.readLine();
			for(int j=0; j<W; j++) {
				map[i][j] = str.charAt(j);
				switch(map[i][j]) {
				case '^' :
					tank = new Tank(i, j, 'u');
					break;
				case '>' :
					tank = new Tank(i, j, 'r');
					break;
				case 'v' :
					tank = new Tank(i, j, 'd');
					break;
				case '<' :
					tank = new Tank(i, j, 'l');
					break;
				}
			}
		}
		
		N = Integer.parseInt(br.readLine());
		orders = br.readLine();
	}
}