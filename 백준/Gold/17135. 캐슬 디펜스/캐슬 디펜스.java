import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, D;
	static int map[][];
	static int tempMap[][];
	static int maxKill;
	static int[] archers;
	static int totalKill;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M];
		tempMap = new int[N+1][M];
		archers = new int[3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		maxKill = 0;
		copyMap();
		combi(0, 0);
		System.out.println(maxKill);
	}
	
	static void combi(int depth, int start) {
		
		if(depth == 3) {
			getMaxKills();
			if(totalKill > maxKill) {
				maxKill = totalKill;
			}
			copyMap();
			return;
		}
		
		for(int i=start; i<M; i++) {
			archers[depth] = i;
			combi(depth+1, i+1);
		}
	}
	
	static void getMaxKills() {
		
		totalKill = 0;
		while(true) {
			
			// 가장 가까운 적들 타게팅
			List<int[]> willRemove = new ArrayList<>();
			for(int archer=0; archer<3; archer++) {
				int dis = 0;
				int minDis = Integer.MAX_VALUE;
				int minX = Integer.MAX_VALUE;
				int minY = Integer.MAX_VALUE;
				boolean hasValue = false;
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						if(tempMap[i][j] == 1) {
							dis = Math.abs(i-N) + Math.abs(j - archers[archer]);
							if(dis <= D) {
								
								if(minDis > dis) {
										hasValue = true;
										minDis = dis;
										minX = i;
										minY = j;
								}
								else if(minDis == dis) {
									if(j < minY) {
										hasValue = true;
										minDis = dis;
										minX = i;
										minY = j;
									}
								}
							}
						}
					}
				}
				if(hasValue) {
					boolean isDuplicated = false;
					for(int[] point : willRemove) {
						if(point[0] == minX && point[1] == minY) {
							isDuplicated = true;
							break;
						}
					}
					if(!isDuplicated) {
						willRemove.add(new int[]{minX, minY});
					}
				}
			}
			
			// 타게팅된 적들 제거
			for(int[] point : willRemove) {
				tempMap[point[0]][point[1]] = 0;
				totalKill++;
			}
				
			// 적들 한칸씩 내리기
			for(int i=N-1; i>=0; i--) {
				for(int j=M-1; j>=0; j--) {
					if(tempMap[i][j] == 1) {
						if(i+1 == N) {
							tempMap[i][j] = 0;
						}
						else {
							tempMap[i][j] = 0;
							tempMap[i+1][j] = 1;
						}
					}
				}
			}
			
			// map 전체가 0인지 확인
			boolean isAllZero = true;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(tempMap[i][j] == 1) {
						isAllZero = false;
					}
				}
			}

			if(isAllZero){
				break;
			}
		}
	}
	
	// tempMap 복구
	static void copyMap() {
		for(int i=0; i<N+1; i++) {
			for(int j=0; j<M; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
	}
}