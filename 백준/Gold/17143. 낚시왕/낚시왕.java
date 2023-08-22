import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static class Shark {
		int x;
		int y;
		int speed;
		int dir;
		int size;
		boolean isKilled;
		
		public Shark(int x, int y, int speed, int dir, int size) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
			this.isKilled = false;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R, C, M;
	static ArrayList<Shark> sharks;
	static int killCount;
	static int map[][];
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sharks = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			sharks.add(new Shark(x, y, speed, dir, size));
		}
		
		// 상어들 속도 초기화
		for(int i=0, size=sharks.size(); i<size; i++) {
			if(sharks.get(i).dir == 1 || sharks.get(i).dir == 2) {
				sharks.get(i).speed %= (R-1)*2;
			}
			else if(sharks.get(i).dir == 3 || sharks.get(i).dir == 4) {
				sharks.get(i).speed %= (C-1)*2;
			}
		}
		
		killCount = 0;
		getResult();
		System.out.println(killCount);
	}
	
	static void getResult() {
		
		for(int fisher=1; fisher<=C; fisher++) {

			// 땅에 가장 가까운 상어 있는지 확인하여 kill
			for(int i=1; i<=R; i++) {
				getMap();	// map 초기화
				
				if(map[i][fisher] != 0) {
					
					killCount += sharks.get(map[i][fisher]-1).size;
					sharks.get(map[i][fisher]-1).isKilled = true;
					break;
				}
			}

			// 상어들 이동
			for(int i=0, size=sharks.size(); i<size; i++) {
				
				int speed = sharks.get(i).speed;
				int sharkX = sharks.get(i).x;
				int sharkY = sharks.get(i).y;
				int dir = sharks.get(i).dir;
				
				if(dir == 1 || dir == 2) {
					
					while(speed > 0) {
						if(sharkX > 1 && dir == 1) {
							sharkX--;
						}
						else if(sharkX == 1) {
							sharkX++;
							dir = 2;
						}
						else if(sharkX < R && dir == 2) {
							sharkX++;
						}
						else if(sharkX == R) {
							sharkX--;
							dir = 1;
						}
						speed--;
					}
					
				}
				else if(dir == 3 || dir == 4) {
					
					while(speed > 0) {
						if(sharkY < C && dir == 3) {
							sharkY++;
						}
						else if(sharkY == C) {
							sharkY--;
							dir = 4;
						}
						else if(sharkY > 1 && dir == 4) {
							sharkY--;
						}
						else if(sharkY == 1) {
							sharkY++;
							dir = 3;
						}
						speed--;
					}
				}
				sharks.get(i).x = sharkX;
				sharks.get(i).y = sharkY;
				sharks.get(i).dir = dir;
				
			}
		}
	}
	
	static void getMap() {
		
		// sharks list에서 겹치는 상어 있으면 잡아먹고, map 초기화
		map = new int[R+1][C+1];
		for(int i=0, size=sharks.size(); i<size; i++) {
			
			Shark find = sharks.get(i);
			if(!find.isKilled) {		
				int idx = map[find.x][find.y];
				if(idx != 0) {
					if(find.size > sharks.get(idx-1).size) {
						sharks.get(idx-1).isKilled = true;
						map[find.x][sharks.get(i).y] = i+1;
					}
					else {
						sharks.get(i).isKilled = true;
					}
				}
				else {
					map[find.x][find.y] = i+1;
				}
			}
		}
	}
}