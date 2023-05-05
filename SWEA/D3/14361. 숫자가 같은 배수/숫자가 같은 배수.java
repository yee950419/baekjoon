import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static int N;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			sb.append("#" + testCase + " ");
			
			validateIsPossible();
		}
	}
	
	static void validateIsPossible() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int sizeN = String.valueOf(N).length();
		
		boolean[] visit1 = new boolean[sizeN];
		boolean[] visit2 = new boolean[sizeN];
		
		String strN = String.valueOf(N);

		String strMultipleN;
		for(int i=2; sizeN==String.valueOf(N*i).length(); i++) {
			
			strMultipleN = String.valueOf(N*i);
			Arrays.fill(visit1, false);
			Arrays.fill(visit2, false);
			for(int j=0; j<sizeN; j++) {
				
				for(int k=0; k<sizeN; k++) {
					
					if(visit1[j] == false) {
						if(strMultipleN.charAt(j) == strN.charAt(k) && visit2[k] == false) {
							visit1[j] = true;
							visit2[k] = true;
						}
					}
				}
			}
			
			if(checkIsTrue(visit1) && checkIsTrue(visit2)) {
				break;
			}
		}
		
		if(checkIsTrue(visit1) && checkIsTrue(visit2)) {
			sb.append("possible\n");
		}
		else {
			sb.append("impossible\n");
		}

	}
	
	static boolean checkIsTrue(boolean[] visit) {
		
		for(int i=0; i<visit.length; i++) {
			
			if(visit[i] == false) {
				return false;
			}
		}
		
		return true;
	}
}