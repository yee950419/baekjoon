import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static int[][] schedule;
	private static int N;
	private static int max;
	
	public static void main(String[] args) throws IOException {
	
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		schedule = new int[N][2];
		
		for(int i=0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				schedule[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(getMaxGain(0, 0));
	}
	
	public static int getMaxGain(int index, int gain) {
		
		if(index == N) {
			return gain < max ? max : gain;
		}
		for(int i=index; i<N; i++) {
			if(schedule[i][0] <= N - i) {
				gain += schedule[i][1];
				max  = gain < max ? max : gain;
				getMaxGain(schedule[i][0] + i, gain);
				gain -= schedule[i][1];
			}
		}
			
		return max;
	}
}