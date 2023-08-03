import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			//구간 합 구하기
			nums[i] = nums[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int a;
		int b;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			sb.append(nums[b] - nums[a-1] + "\n");
		}
		
		System.out.println(sb);
	}
}