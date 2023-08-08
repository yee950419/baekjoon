import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static final int CAN_BUY = 2;
	static int totalWeight;
	static int maxWeight;
	static int T;
	static int N, M;
	static int[] weights;
	
	public static void main(String[] args) throws IOException {
		
		T = Integer.parseInt(br.readLine());
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			sb.append("#" + testCase + " ");
			
			inputDatas();
			
			totalWeight = 0;
			maxWeight = -1;
			getResult(0, 0);
			sb.append(maxWeight + "\n");
		}
	}
	
	static void inputDatas() throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		weights = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0, size=weights.length; i<size; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void getResult(int depth, int start) {
		
		if(depth == CAN_BUY) {
			if(totalWeight <= M && maxWeight < totalWeight) {
				maxWeight = totalWeight;
			}
			return;
		}
		
		for(int i=start; i<N; i++) {
			totalWeight += weights[i];
			getResult(depth+1, i+1);
			totalWeight -= weights[i];
		}
	}
}