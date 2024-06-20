import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[] A = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(A);
		for(int loop=0; loop<m; loop++) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());
			
			if(query == 1) {
				long k = Long.parseLong(st.nextToken());
				getCaseOne(k, A);
			}
			else if(query == 2) {
				long k = Long.parseLong(st.nextToken());
				getCaseTwo(k, A);
			}
			else if(query == 3) {
				long i = Long.parseLong(st.nextToken());
				long j = Long.parseLong(st.nextToken());
				getCaseThree(i, j, A);
			}
		}
		
		System.out.println(sb);
		
	}
	
	static void getCaseOne(long k, long[] A) {
		
		int left = 0;
		int right = A.length - 1;
		while(left <= right) {
			
			int mid = (left + right) / 2;
			if(A[mid] >= k) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		int result = A.length - left;
		
		sb.append(result).append("\n");
	}
	
	static void getCaseTwo(long k, long[] A) {
		
		int left = 0;
		int right = A.length - 1;
		while(left <= right) {
			
			int mid = (left + right) / 2;
			if(A[mid] > k) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		int result = A.length - 1 - right;
		
		sb.append(result).append("\n");
	}
	
	static void getCaseThree(long i, long j, long[] A) {
		
		int left = 0;
		int right = A.length - 1;
		while(left <= right) {
			
			int mid = (left + right) / 2;
			if(A[mid] >= i) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		int lowerIdx = left;
		
		left = 0;
		right = A.length - 1;
		while(left <= right) {
			
			int mid = (left + right) / 2;
			if(A[mid] > j) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		int upperIdx = right;
		
		int result = upperIdx - lowerIdx + 1;
		sb.append(result).append("\n");
	}
}