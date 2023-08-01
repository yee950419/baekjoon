import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[] data;

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[M];
		dfs(0, 0);
		System.out.println(sb);
	}
	
	static void dfs(int depth, int flag) {
		
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(data[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if((flag & 1<<i) == 0) {
				data[depth] = i+1;
				dfs(depth+1, flag | 1<<i);
			}
		}
	}
}