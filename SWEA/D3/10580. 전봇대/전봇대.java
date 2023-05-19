import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int TC;
	private static int N;
	private static int[] A, B;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		TC = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		for(int testCase=1; testCase<=TC; testCase++) {
			sb.append("#" + testCase + " ");
			
			getDotCount();
		}
	}
	
	static void getDotCount() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		B = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<N; j++) {
			
				if(i != j) {
					if(A[i] < A[j] && B[i] > B[j]) {
						count++;
					}
					else if(A[i] > A[j] && B[i] < B[j]) {
						count++;
					}
				}
			}
		}
		
		//count가 두번 중첩되므로,
		count /= 2;
		
		sb.append(count + "\n");
	}
}