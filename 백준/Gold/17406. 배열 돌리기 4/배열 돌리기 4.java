import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, K;
	static int[][] A;
	static int[][] tempA;
	static int[][] result;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[][] rotation;
	static int[][] toRotate;
	static int minNum;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N+1][M+1];
		tempA = new int[N+1][M+1];
		result = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotation = new int[K][3];
		toRotate = new int[K][3];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			rotation[i][0] = Integer.parseInt(st.nextToken());
			rotation[i][1] = Integer.parseInt(st.nextToken());
			rotation[i][2] = Integer.parseInt(st.nextToken());

		}
		
		minNum = Integer.MAX_VALUE;
		recur(0, 0);
		
		System.out.println(minNum);
	}
	
	static void recur(int depth, int flag) {
		
		if(depth == K) {
			
			// tempA 복구
			for(int i=0; i<N+1; i++) {
				for(int j=0; j<M+1; j++) {
					tempA[i][j] = A[i][j];
				}
			}
			
			// result 초기화
			for(int i=0; i<N+1; i++) {
				for(int j=0; j<M+1; j++) {
					result[i][j] = A[i][j];
				}
			}
			
			for(int i=0; i<K; i++) {
				rotateArray(toRotate[i]);
			}
			
			int sum;
			for(int i=1; i<N+1; i++) {
				sum = 0;
				for(int j=0; j<M+1; j++) {
					sum += result[i][j];
				}
				if(sum < minNum) {
					minNum = sum;
				}
			}
			
			return;
		}
		
		for(int i=0; i<K; i++) {
			if((flag & 1<<i) == 0) {
				toRotate[depth] = rotation[i];
				recur(depth+1, flag | 1<<i);
			}
		}
	}
	
	//rotate[0] = r, rotate[1] = c, rotate[2] = s
	static void rotateArray(int[] rotate) {
		
		for(int i=1; i<=rotate[2]; i++) {
			
			int x = rotate[0]-i;
			int y = rotate[1]-i;
			result[x][y] = tempA[x+1][y];
			
			// 오른쪽 방향
			while(y < rotate[1]+i) {
				x = x + dr[0];
				y = y + dc[0];
				result[x][y] = tempA[x][y-1];
			}
			
			// 아랫방향
			while(x < rotate[0]+i) {
				x = x + dr[1];
				y = y + dc[1];
				result[x][y] = tempA[x-1][y];
			}
			
			// 왼쪽 방향
			while(y > rotate[1]-i) {
				x = x + dr[2];
				y = y + dc[2];
				result[x][y] = tempA[x][y+1];
			}
			
			// 윗 방향
			while(x > rotate[0]-i+1) {
				x = x + dr[3];
				y = y + dc[3];
				result[x][y] = tempA[x+1][y];
			}
		}
		
		// 기존 맵 초기화
		for(int i=0; i<N+1; i++) {
			for(int j=0; j<M+1; j++) {
				tempA[i][j] = result[i][j];
			}
		}
	}
}
