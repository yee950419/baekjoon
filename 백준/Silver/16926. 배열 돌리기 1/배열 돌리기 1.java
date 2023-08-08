import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	int value;
	Point next;
	
	public Point(int x, int y, int value, Point next) {
		this.x = x;
		this.y = y;
		this.value = value;
		this.next = next;
	}
}

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M, R;
	static int map[][];
	static int resultMap[][];
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		resultMap = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int rotateCount = N > M ? M/2 : N/2;
		for(int rotate=0; rotate<rotateCount; rotate++) {
			
			List<Point> list = new ArrayList<>();
			while(true) {
				int i=rotate;
				int j=rotate;
				int idx=0;
				while(i < N-1-rotate) {
					list.add(new Point(i, j, map[i][j], null));
					if(idx != 0) {
						list.get(idx-1).next = list.get(idx);
					}
					i++;
					idx++;
				}
				
				while(j < M-1-rotate) {
					list.add(new Point(i, j, map[i][j], null));
					list.get(idx-1).next = list.get(idx);
					j++;
					idx++;
				}
				
				while(i > 0+rotate) {
					list.add(new Point(i, j, map[i][j], null));
					list.get(idx-1).next = list.get(idx);
					i--;
					idx++;
				}
				
				while(j > 0+rotate) {
					list.add(new Point(i, j, map[i][j], null));
					list.get(idx-1).next = list.get(idx);
					j--;
					idx++;
				}
				
				list.get(idx-1).next = list.get(0);
				break;
			}

			int recurCount = R % list.size();

			for(int i=0; i<recurCount; i++) {
				int temp = list.get(0).value;
				for(int j=list.size()-1; j>=0; j--) {
					list.get(j).next.value = list.get(j).value;
				}
				list.get(0).next.value = temp;
			}
	
			for(int i=0, size=list.size(); i<size; i++) {
				int x = list.get(i).x;
				int y = list.get(i).y;
				int value = list.get(i).value;
				resultMap[x][y] = value;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(resultMap[i][j] + " ");
			}
			System.out.println();
		}
	}
}