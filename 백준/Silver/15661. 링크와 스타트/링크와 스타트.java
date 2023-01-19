import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static int N;
	private static int[][] S;
	private static int[][] result;
	private static boolean[] visit;
	private static int min;
	private static int difference;
	
	public static void main(String[] args) throws IOException {
	
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = new int[N][N];
		visit = new boolean[N];
		result = new int[N][N];
		
		for(int i=0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		initializeResult();
		
		min = 100 * N-1;
		System.out.println(getLeastDifference(0, 0));
	}
	
	public static int getLeastDifference(int index, int depth) {
		
		if(depth == N-1) {
			return min < difference ? min : difference;
		}
		
		for(int i=index; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				difference = getDifference();
				min = min < difference ? min : difference;
				min = getLeastDifference(i + 1, depth + 1);
				visit[i] = false;
			}
		}
		
		return min;
	}
	
	public static int getDifference() {
		
		int startTeamSum = 0;
		int linkTeamSum = 0;
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(visit[i] && visit[j]) {
					startTeamSum += result[i][j];
				}
				if(!visit[i] && !visit[j]) {
					linkTeamSum += result[i][j];
				}
			}
		}
		return Math.abs(startTeamSum - linkTeamSum);
	}
	
	public static void initializeResult() {

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				result[i][j] = S[i][j] + S[j][i];
			}
		}
	}
}