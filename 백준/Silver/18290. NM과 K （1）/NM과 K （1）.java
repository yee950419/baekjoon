import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static int N, M, K;
	private static int max;
	private static int[][] arr;
	private static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visit = new boolean[N][M];
		int[] temp = new int[N*M];
		
		max = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				temp[M*i + j] = arr[i][j];
			}
		}
		
		Arrays.sort(temp);
		
		for(int i=0; i<K; i++) {
			max += temp[i];
		}

		max = dfs(0, 0);
		
		System.out.println(max);
	}
	
	public static int dfs(int index, int sum) {
		
		if(index == K) {
			return sum < max ? max : sum;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visit[i][j] == false) {
					if(!isAttached(i, j)) {
						visit[i][j] = true;
						sum += arr[i][j];
						max = dfs(index + 1, sum);
						sum -= arr[i][j];
						visit[i][j] = false;
					}
				}
			}
		}
		
		return max;
	}
	
	public static boolean isAttached(int i, int j) {
		
		if(N == 1 && M == 1) {
			return false;
		}
		if(N == 1 && M != 1) {
			if(j == 0) {
				if(visit[i][j+1] == false) {
					return false;
				}
			}
			else if(j == M-1) {
				if(visit[i][j-1] == false) {
					return false;
				}
			}
			else {
				if(visit[i][j-1] == false && visit[i][j+1] == false) {
					return false;
				}
			}
		}
		if(N != 1 && M == 1) {
			if(i == 0) {
				if(visit[i+1][j] == false) {
					return false;
				}
			}
			else if(i == N-1) {
				if(visit[i-1][j] == false) {
					return false;
				}
			}
			else {
				if(visit[i+1][j] == false && visit[i-1][j] == false) {
					return false;
				}
			}
		}
		if(N != 1 && M != 1) {
			if(i == 0) {
				if(j == 0) {
					if(visit[i+1][j] == false && visit[i][j+1] == false) {
						return false;
					}
				}
				else if(j == M-1) {
					if(visit[i][j-1] == false && visit[i+1][j] == false) {
						return false;
					}
				}
				else {
					if((visit[i][j-1] == false && visit[i][j+1] == false) && visit[i+1][j] == false) {
						return false;
					}
				}
			}
			else if(i == N-1) {
				if(j == 0) {
					if(visit[i-1][j] == false && visit[i][j+1] == false) {
						return false;
					}
				}
				else if(j == M-1) {
					if(visit[i][j-1] == false && visit[i-1][j] == false) {
						return false;
					}
				}
				else {
					if((visit[i][j-1] == false && visit[i][j+1] == false) && visit[i-1][j] == false) {
						return false;
					}
				}
			}
			else {
				if(j == 0) {
					if((visit[i-1][j] == false && visit[i][j+1] == false) && visit[i+1][j] == false) {
						return false;
					}
				}
				else if(j == M-1) {
					if((visit[i][j-1] == false && visit[i-1][j] == false) && visit[i+1][j] == false) {
						return false;
					}
				}
				else {
					if(((visit[i][j-1] == false && visit[i][j+1] == false) && visit[i-1][j] == false) && visit[i+1][j] == false) {
						return false;
					}
				}
			}
		}
		return true;
	}
}