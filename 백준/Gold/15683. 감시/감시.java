import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	static ArrayList<int[]> cctvs = new ArrayList<>();
	static boolean[] visited;
	static int[][] tempMap;
	static int[][] map;
	static int[] directions;
	static int minSagak;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tempMap = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0 && map[i][j] < 6) {
					cctvs.add(new int[] {i, j, map[i][j]});
				}
			}
		}
		
		directions = new int[cctvs.size()];
		minSagak = Integer.MAX_VALUE;
		visited = new boolean[cctvs.size()];
		
		dfs(0);
		
		System.out.println(minSagak);
		
	}
	
	static void dfs(int depth) {
		
		// 1 2 3 4
		if(depth == cctvs.size()) {
			// 맵 원상복구
			copyMap();
			
			// 맵 change
			changeMap();

			int count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(tempMap[i][j] == 0) {
						count++;
					}
				}
			}
			
			if(count < minSagak) {
				minSagak = count;
			}
			
			return;
		}
		
		for(int i=1; i<=4; i++) {
			directions[depth] = i;
			dfs(depth+1);
		}
	}
	
	static void changeMap() {
		
		for(int i=0, size=cctvs.size(); i<size; i++) {
			
			int x = cctvs.get(i)[0];
			int y = cctvs.get(i)[1];
			int type = cctvs.get(i)[2];
			
			// 1 카메라일 때
			if(type == 1) {
				// 방향별 맵 바꾸기
				if(directions[i] == 1) {
					upChange(x, y);
				}
				else if(directions[i] == 2) {
					rightChange(x, y);
				}
				else if(directions[i] == 3) {
					downChange(x, y);
				}
				else if(directions[i] == 4) {
					leftChange(x, y);
				}
			}

			// 2 카메라일 때
			else if (type == 2) {
				if(directions[i] == 1 || directions[i] == 3) {
					upChange(x, y);
					downChange(x, y);
				}
				else if(directions[i] == 2 || directions[i] == 4) {
					rightChange(x, y);
					leftChange(x, y);
				}
			}
			
			else if(type == 3) {
				if(directions[i] == 1) {
					upChange(x, y);
					rightChange(x, y);
				}
				else if(directions[i] == 2) {
					rightChange(x, y);
					downChange(x, y);
				}
				else if(directions[i] == 3) {
					downChange(x, y);
					leftChange(x, y);
				}
				else if(directions[i] == 4) {
					leftChange(x, y);
					upChange(x, y);
				}
			}
			else if(type == 4) {
				if(directions[i] == 1) {
					leftChange(x, y);
					upChange(x, y);
					rightChange(x, y);
				}
				else if(directions[i] == 2) {
					upChange(x, y);
					rightChange(x, y);
					downChange(x, y);
				}
				else if(directions[i] == 3) {
					rightChange(x, y);
					downChange(x, y);
					leftChange(x, y);
				}
				else if(directions[i] == 4) {
					downChange(x, y);
					leftChange(x, y);
					upChange(x, y);
				}
			}
			else if(type == 5) {
				upChange(x, y);
				rightChange(x, y);
				downChange(x, y);
				leftChange(x, y);
			}
		}
	}
	
	static void upChange(int x, int y) {
		while(x > 0 && tempMap[x-1][y] != 6) {
			if(tempMap[x-1][y] < 6 && tempMap[x-1][y] > 0 && tempMap[x-1][y] == -1) {
				x--;
				continue;
			}
			tempMap[--x][y] = -1;
		}
	}
	
	static void rightChange(int x, int y) {
		while(y < M-1 && tempMap[x][y+1] != 6) {
			if(tempMap[x][y+1] < 6 && tempMap[x][y+1] > 0 && tempMap[x][y+1] == -1) {
				y++;
				continue;
			}
			tempMap[x][++y] = -1;
		}
	}
	
	static void downChange(int x, int y) {
		while(x < N-1 && tempMap[x+1][y] != 6) {
			if(tempMap[x+1][y] < 6 && tempMap[x+1][y] > 0 && tempMap[x+1][y] == -1) {
				x++;
				continue;
			}
			tempMap[++x][y] = -1;
		}
	}
	
	static void leftChange(int x, int y) {
		while(y > 0 && tempMap[x][y-1] != 6) {
			if(tempMap[x][y-1] < 6 && tempMap[x][y-1] > 0 && tempMap[x][y-1] == -1) {
				y--;
				continue;
			}
			tempMap[x][--y] = -1;
		}
	}
	
	static void copyMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
	}
}