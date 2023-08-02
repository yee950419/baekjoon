import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	static int[][] map;
	static List<Place> homeList = new ArrayList<>();
	static List<Place> chickenList = new ArrayList<>();
	static boolean[] visit;
	static int minDistance;
	static int distance;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		//데이터 입력과 동시에 치킨집, 집 리스트 저장
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					homeList.add(new Place(i, j));
				}
				else if(map[i][j] == 2) {
					chickenList.add(new Place(i, j));
				}
			}
		}
		
		visit = new boolean[chickenList.size()];
		minDistance = Integer.MAX_VALUE;
		combi(0, 0);
		System.out.println(minDistance);
	}
	
	static void combi(int depth, int start) {
		
		if(depth == M) {
			
			getChickenDistance();
			if(distance < minDistance) {
				minDistance = distance;
			}
			return;
		}
		
		for(int i=start, size=chickenList.size(); i<size; i++) {
			visit[i] = true;
			combi(depth+1, i+1);
			visit[i] = false;
		}
	}
	
	//치킨거리 구하기
	static void getChickenDistance() {
		
		distance = 0;
		for(int i=0, homeSize=homeList.size(); i<homeSize; i++) {
			
			int min = Integer.MAX_VALUE;
			for(int j=0, chickenSize=chickenList.size(); j<chickenSize; j++) {
				
				if(visit[j]) {
					
					int temp = Math.abs(homeList.get(i).x - chickenList.get(j).x) + 
							Math.abs(homeList.get(i).y - chickenList.get(j).y);
					if(min > temp) {
						min = temp;
					}
				}
			}
			
			distance += min;
		}
	}
	
	static class Place{
		int x;
		int y;
		public Place(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
