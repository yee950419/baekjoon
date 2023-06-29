import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static int N, M;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			sb.append("#" + testCase + " ");
			
			getMaxResult();
		}
	}
	
	static void getMaxResult() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		int[] B = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		if(A.length < B.length) {
			getResult(A, B);
		}
		else {
			getResult(B, A);
		}
	}
	
	static void getResult(int[] shorter, int[] longger) {
		
		int maxSum = 0;
		for(int i=0; i<=longger.length-shorter.length; i++) {
			
			int sum = 0;
			for(int j=0; j<shorter.length; j++) {
				sum += shorter[j] * longger[i+j];
			}
			
			if(maxSum < sum) {
				maxSum = sum;
			}
		}
		
		sb.append(maxSum + "\n");
	}
}