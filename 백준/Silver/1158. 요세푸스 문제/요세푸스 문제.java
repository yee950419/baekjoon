import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		sb.append("<");
		for(int i=0; i<N; i++) {
			
			int temp;
			for(int j=0; j<M-1; j++) {
				temp = queue.poll();
				queue.add(temp);
			}
			
			temp = queue.poll();
			if(i == N-1) {
				sb.append(temp + ">");
			}
			else {
				sb.append(temp + ", ");
			}
		}
		System.out.println(sb);
	}
}
