import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static int N, M;
	private static int[] A, B;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			sb.append("#" + testCase + " ");
			
			inputLength();
			inputData();
			getResult();
		}
	}
	
	static void inputLength() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	}
	
	static void inputData() throws IOException {

		A = new int[N];
		B = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			
			B[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void getResult() {
		
		int[] bigArray, smallArray;
		int biggestSum, sum;
		
		if(N>M) {
			bigArray = A;
			smallArray = B;
		}
		else {
			bigArray = B;
			smallArray = A;
		}
		
		biggestSum = 0;
		for(int i=0; i<bigArray.length - smallArray.length + 1; i++) {
			
			sum = 0;
			for(int j=0; j<smallArray.length; j++) {
				sum += bigArray[j+i] * smallArray[j];
			}
			
			if(biggestSum < sum) {
				biggestSum = sum;
			}
		}
		
		sb.append(biggestSum + "\n");
	}
}